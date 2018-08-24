package net.jrat.core.packet.client;

import net.jrat.core.connection.SystemInformations;
import net.jrat.core.packet.IPacket;

@SuppressWarnings("unused")
public class C0PacketConnect implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	private SystemInformations informations;
	
	public C0PacketConnect(SystemInformations informations)
	{
		this.informations = informations;
	}
	
	public void execute(Object object) throws Exception {}
}

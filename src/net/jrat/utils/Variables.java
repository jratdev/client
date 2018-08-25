package net.jrat.utils;

import net.jrat.core.connection.OS;

public class Variables
{
	public static Variables instance;
	
	public OS operatingSystem;
	
	public String address;
	public int port;
	
	public Variables create()
	{
		instance = this;
		
		this.operatingSystem = Utils.getOperatingSystem();
		
		return instance;
	}
}

package net.jrat.utils;

import java.io.File;

import net.jrat.core.connection.OS;

public class Variables
{
	public static Variables instance;
	
	public String workDir;
	public OS operatingSystem;
	
	public String address;
	public int port;
	
	public Variables create()
	{
		instance = this;
		
		this.workDir = System.getProperty("user.dir") + File.separator;
		this.operatingSystem = Utils.getOperatingSystem();
		
		return instance;
	}
}

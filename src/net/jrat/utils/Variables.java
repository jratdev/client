package net.jrat.utils;

public class Variables
{
	public static Variables instance;
	
	public String address;
	public int port;
	
	public Variables create()
	{
		instance = this;
		
		return instance;
	}
}

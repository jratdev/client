package net.jrat.utils;

public class Variables
{
	public static Variables instance;
	
	public String address;
	public int port;
	
	public Variables create()
	{
		instance = this;
		
		this.address = "localhost";
		this.port = 1337;
		
		return instance;
	}
}

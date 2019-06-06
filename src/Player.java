import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Player extends JComponent
{
	boolean isAlive;
	private BufferedImage image;
	private int x;
	private int y;
	
	private ArrayList<Bullet> bullets;
	
	public Player() throws IOException
	{
		//Set up player in middle of screen
		isAlive = true;
		x = Game.screenWidth / 2;
		y =  20;
		
		bullets = new ArrayList<Bullet>();
		image = loadPlayerImage();
	}
	
	public void fireBullet()
	{
		bullets.add(new Bullet(this));
	}
	
	private BufferedImage loadPlayerImage() throws IOException
	{
		 return ImageIO.read(getClass().getResource("/assets/player.png"));
	};
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
	}
	
}

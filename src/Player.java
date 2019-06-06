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
	private int dX;
	private int inY;
	private int points;
	
	private Bullet bullet;
	
	public Player(int x, int y) 
	{
		isAlive = true;
		setBounds(x, y, 100,100);
	}
	
	public void fireBullet()
	{
		bullet = new Bullet(this);
		bullet.setDy(5);
		bullet.setDx(0);
	}
	
	private BufferedImage loadPlayerImage() throws IOException
	{
		 return ImageIO.read(getClass().getResource("RocketSadBlackUp.png"));
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;	
		try {BufferedImage image = ImageIO.read(getClass().getResourceAsStream("RocketSadBlackUp.png"));
		g2.drawImage(image, 0, 0, null);} 
		catch (IOException e) {e.printStackTrace();}
		
	}
	
	public void addPoints(int a)
	{
		points += a;
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public void setDx(int x)
	{
		dX = x; 
	}
	
	public boolean bulletHit(int x, int y)
	{
		return bullet.hit(x, y);
	}
	
	public void update()
	{
		this.setLocation(this.getX() + dX, inY); 
	}
}

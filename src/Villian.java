import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Villian extends JComponent
{
	private int dX;
	private int dY;
	private int point;
	private VillianType villianType;
	private boolean alive;
	private int move = 2; 
	private int before;
	private int villianNum;
	private Bullet pew;
	private BufferedImage image;
	
	public enum VillianType
	{
		SQUID, FOURLEGGED, METROID
	}
	
	public Villian(int x, int y, int pNum, VillianType villianType)
	{
		dX = 0;
		dY = 0;
		setBounds(x, y, 100, 100);
		point = pNum;
		this.villianType = villianType;
		alive = true;
		
		switch(villianType)
		{
			case SQUID:
				try {image = ImageIO.read(getClass().getResourceAsStream("villian1BS.png"));} 
				catch (IOException e) {e.printStackTrace();}
				break;
				
			case FOURLEGGED:
				try {image = ImageIO.read(getClass().getResourceAsStream("villian2BS.png"));} 
				catch (IOException e) {e.printStackTrace();}
				break;
				
			case METROID:
				try {image = ImageIO.read(getClass().getResourceAsStream("villian3BS.png"));} 
				catch (IOException e) {e.printStackTrace();}
				break;
			
			default:
				System.out.println("Villian doesn't have a type!");
				break;
		}
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0, 0, null);
	}
	
	
	public int getPoints()
	{
		return point;
	}
	
	public void setDx(int x)
	{
		dX = x; 
	}
	
	public void setDy(int y)
	{
		dY = y;
		before = this.getY();
	}
	
	public void fire()
	{
		pew = new Bullet(this);
		pew.setDy(5);
		pew.setDx(0);
	}
	
	public void updateHorizontal()
	{
		this.setLocation(this.getX() + dX, this.getY()); 
	}
	
	public void updateVertical()
	{
		this.setLocation(this.getX(), this.getY() + 5);
	}
	
	public void updateBullet()
	{
		if(pew != null && pew.getY() < 0)
		{
			remove(pew);
			pew = null;
		}
		
		if(pew != null)
			pew.update();
	}
}

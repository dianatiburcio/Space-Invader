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
	
	public enum VillianType
	{
		SQUID, FOURLEGGED, METROID
	}
	
	public Villian(int x, int y, int pNum, VillianType villianType)
	{
		dX = 0;
		dY = 0;
		this.setLocation(x,y);
		point = pNum;
		this.villianType = villianType;
		alive = true; 
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		if(villianNum == 1)
		{	
			try {BufferedImage image = ImageIO.read(getClass().getResourceAsStream("villian1BS.png"));} 
			catch (IOException e) {e.printStackTrace();}
		}
		
		switch(villianType)
		{
			case SQUID:
				try {BufferedImage image = ImageIO.read(getClass().getResourceAsStream("villian1BS.png"));} 
				catch (IOException e) {e.printStackTrace();}
				break;
				
			case FOURLEGGED:
				try {BufferedImage image = ImageIO.read(getClass().getResourceAsStream("villian2BS.png"));} 
				catch (IOException e) {e.printStackTrace();}
				break;
				
			case METROID:
				try {BufferedImage image = ImageIO.read(getClass().getResourceAsStream("villian3BS.png"));} 
				catch (IOException e) {e.printStackTrace();}
				break;
			
			default:
				System.out.println("Villian doesn't have a type!");
				break;
		}
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
	
	public void update()
	{
		this.setLocation(this.getX() + dX, this.getY() + dY);  
		if(this.getY() == move + before) 
			setDy(0);
	}
}

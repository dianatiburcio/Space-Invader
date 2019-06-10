import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Bullet extends JComponent
{
	private int dY = -10;
	private int dX = 0;
	private Ellipse2D bullet; 
	private boolean kill;
	
	public Bullet(JComponent a)
	{
		this.setLocation(a.getX(), a.getY());
		this.setSize(50,50);
		bullet = new Ellipse2D.Double(25,0,10,10);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		g2.fill(bullet);
	}
	
	public void setDx(int x)
	{
		dX = x; 
	}
	
	public void setDy(int y)
	{
		dY = y;
	}
	
	public void update()
	{
		this.setLocation(this.getX() + dX, this.getY() + dY);  
	}
	
	public boolean hit(JComponent ree)
	{
		if(this.getX()>ree.getX() && this.getX()<ree.getX()+ree.getWidth() && this.getY()>ree.getY() && this.getY()<ree.getY()+ree.getHeight())
			return true;
		else
		{return false;}
	}
}

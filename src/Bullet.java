import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Bullet extends JComponent
{
	private int dY;
	private int dX;
	private Ellipse2D bullet; 
	private boolean kill;
	
	public Bullet(Player a)
	{
		this.setLocation(a.getX(), a.getY());
		this.setSize(50,50);
		bullet = new Ellipse2D.Double(25,0,25,25);
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
	
	public boolean hit(int x, int y)
	{
		if(this.getX() == x && this.getY() == this.getX())
			return true;
		else
		{return false;}
	}
}

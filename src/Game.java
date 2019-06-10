/**
 * 
 * @author jjacobson20
 *
 */

//Input
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
//Window
import javax.swing.JFrame;
import javax.swing.JLabel;

//Utils
import java.util.ArrayList;
import javax.swing.Timer;


import javax.imageio.ImageIO;

public class Game extends JFrame implements KeyListener, ActionListener
{
	final static int screenHeight = 768;
	final static int screenWidth = 1366;
	static int screenCrop = screenWidth / 16;
	static int screenIncrement = (screenWidth - screenCrop) / 3;
	private int point;
	private Blocks block1;
	private Blocks block2;
	private Blocks block3;
	private Player rocket;
	private int points;
	private Bullet pew;
	private VillianManager villianManager;
	private ArrayList<Bullet> pewpew = new ArrayList<Bullet>();
	JLabel pointNum = new JLabel("");
	
	public Game()
	{
		setLayout(null);
		setBounds(200, 100, screenWidth, screenHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setBackground(Color.black);
		
		JLabel points = new JLabel("pts:");
		points.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 34));
		points.setForeground(Color.white);
		points.setBounds(5, 5, 100, 50);
		add(points);
		
		pointNum.setBounds(105,0, 100, 50);
		pointNum.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 34));
		pointNum.setForeground(Color.white);
		
		add(pointNum);
		
		BufferedImage a = null;
		try {a = ImageIO.read(new File("RocketSadBlack.png"));
		System.out.println(new File("Rocket.png").getAbsolutePath());} 
		catch (IOException e) {e.printStackTrace();}
		
		JLabel life1 = new JLabel(new ImageIcon(a));
		life1.setBounds(1185, 5, 100, 100);
		add(life1);
		
		JLabel life2 = new JLabel(new ImageIcon(a));
		life2.setBounds(1290, 5,100, 100);
		add(life2);
		
		JLabel life3 = new JLabel(new ImageIcon(a));
		life3.setBounds(1395, 5, 100, 100);
		add(life3);

		//shield positions are based on a 'square' cut out
		//of the screen then are placed into 1/3 increments in
		//5/6 of the way down
		block1 = new Blocks(screenCrop + screenIncrement, (screenHeight / 6) * 5);
		add(block1);
		block2 = new Blocks(screenCrop + (screenIncrement * 2), (screenHeight / 6) * 5);
		add(block2);
		block3 = new Blocks(screenCrop + (screenIncrement * 3), (screenHeight / 6) * 5);
		add(block3);
		
		rocket = new Player(screenWidth / 2, 300);
		add(rocket);
		
		this.addKeyListener(new KeyListener() 
		{
			public void keyTyped(KeyEvent eT) 
			{}
			public void keyPressed(KeyEvent eT) 
			{
				if (eT.getKeyCode() == KeyEvent.VK_LEFT)
				{
					rocket.setDx(-20);
				}
				if (eT.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					rocket.setDx(20);
				}
				if (eT.getKeyCode() == KeyEvent.VK_SPACE)
				{
					pew = new Bullet(rocket);
					pewpew.add(pew);
					add(pew);
				}
			}
			
			public void keyReleased(KeyEvent eT) 
			{
				if (eT.getKeyCode() == KeyEvent.VK_LEFT)
				{
					rocket.setDx(0);
				}
				if (eT.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					rocket.setDx(0);
				}
			}
		});
		
		villianManager = new VillianManager(this);
		
		Timer t = new Timer(2,this);
		t.start();
		
		repaint();
		revalidate();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void updatePoints()
	{
		points += 10;
		setPoints(points);
	}
	
	public void setPoints(int p)
	{pointNum.setText("" + rocket.getPoints());}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		
		if(rocket.getX()+rocket.getDx()>= 0 && rocket.getX()+rocket.getDx()<= this.getWidth()-rocket.getWidth())
			rocket.update();
		if(!pewpew.isEmpty())
		{
			for(int i = 0; i<pewpew.size(); i++)
			{
				pewpew.get(i).update();
				if(pewpew.get(i).getY() > this.getHeight())
				{
					remove(pewpew.get(i));
					pewpew.remove(i);
				}	
			}
		}
		
		villianManager.UpdatePositions();
		
		repaint();
	}

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

}

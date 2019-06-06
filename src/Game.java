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

public class Game extends JFrame implements KeyListener
{
	final static int screenHeight = 1700;
	final static int screenWidth = 1400;
	private int point;
	private Blocks block1;
	private Blocks block2;
	private Blocks block3;
	private Player rocket;
	JLabel pointNum = new JLabel("");

	
	public Game()
	{
		setLayout(null);
		setBounds(200, 100, screenHeight, screenWidth);
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

		block1 = new Blocks(150,1100);
		add(block1);
		block2 = new Blocks(600, 1100);
		add(block2);
		block3 = new Blocks(1050,1100);
		add(block3);
		
		rocket = new Player(5);
		add(rocket);
		
		repaint();
		revalidate();
		
		if(!rocket.isAlive)
		{
			
		}
		
		
//		timer.start();
//		addKeyListener(this);
		
		System.out.println(getClass());
		getClass().getResourceAsStream("/");
	}

	public void setPoints(int p)
	{
		pointNum.setText("" + rocket.getPoints());
	}


	@Override
	public void keyPressed(KeyEvent arg0) 
	{}
	@Override
	public void keyReleased(KeyEvent eT) 
	{
		if (eT.getKeyCode() == KeyEvent.VK_LEFT)
		{
			rocket.setDx(-5);
		}
		if (eT.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rocket.setDx(5);
		}
		if (eT.getKeyCode() == KeyEvent.VK_SPACE)
		{
			rocket.fireBullet();
		}
		
	}
	@Override
	public void keyTyped(KeyEvent eT) 
	{
		if (eT.getKeyCode() == KeyEvent.VK_LEFT)
		{
			rocket.setDx(0);;
		}
		if (eT.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rocket.setDx(0);
		}
	}

}

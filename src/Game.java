/**
 * 
 * @author jjacobson20
 *
 */

//Input
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
	final static int screenWidth = 1500;
	private int points;
	JLabel pointNum = new JLabel("");
	
	public Game()
	{
		setLayout(null);
		setBounds(200, 100, screenHeight, screenWidth);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JLabel points = new JLabel("pts:");
		points.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 34));
		points.setBounds(5, 5, 100, 50);
		add(points);
		
		pointNum.setBounds(105,0, 100, 50);
		pointNum.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		add(pointNum);
		
		BufferedImage a = null;
		try {a = ImageIO.read(new File("Rocket.png"));} 
		catch (IOException e) {e.printStackTrace();}
		
		JLabel life1 = new JLabel(new ImageIcon(a));
		life1.setBounds(340, 5, 50, 70);
		add(life1);
		life1.setVisible(true);
		
		JLabel life2 = new JLabel(new ImageIcon(a));
		life2.setBounds(395, 5, 50, 70);
		add(life2);
		life2.setVisible(true);
		
		JLabel life3 = new JLabel(new ImageIcon(a));
		life3.setBounds(450, 5, 50, 70);
		add(life3);
		life3.setVisible(true);
		
//		timer.start();
//		addKeyListener(this);
		
		System.out.println(getClass());
		getClass().getResourceAsStream("/");
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				//shift left
				break;
				
			case KeyEvent.VK_RIGHT:
				//shift right
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void setPoints(int p)
	{
		pointNum.setText("p");
	}
	
	public void updatePoints()
	{
		points += 10;
		setPoints(points);
	}

}

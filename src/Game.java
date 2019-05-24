/**
 * 
 * @author jjacobson20
 *
 */

//Input
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Window
import javax.swing.JFrame;

//Utils
import java.util.ArrayList;
import javax.swing.Timer;

public class Game extends JFrame implements KeyListener
{
	public Game()
	{
		setLayout(null);
		setBounds(200, 100, 400, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
//		timer.start();
//		addKeyListener(this);
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

}

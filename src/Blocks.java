import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Blocks extends JComponent
{
	private boolean[][] block;
	
	public Blocks(int x, int y)
	{
		setBounds(x,y,300,300);
		
		block = new boolean[12][12];
		block[0][0]= true;
		block[1][0]= true;
		block[2][0]= true;
		block[0][1]= true;
		block[1][1]= true;
		block[2][1]= true;
		
		block[9][0]= true;
		block[10][0]= true;
		block[11][0]= true;
		block[9][1]= true;
		block[10][1]= true;
		block[11][1]= true;
		
		block[3][11]= true;
		block[4][11]= true;
		block[5][11]= true;
		block[6][11]= true;
		block[7][11]= true;
		block[8][11]= true;
		block[3][10]= true;
		block[4][10]= true;
		block[5][10]= true;
		block[6][10]= true;
		block[7][10]= true;
		block[8][10]= true;
		block[3][9]= true;
		block[4][9]= true;
		block[5][9]= true;
		block[6][9]= true;
		block[7][9]= true;
		block[8][9]= true;
		
		block[4][8]= true;
		block[5][8]= true;
		block[6][8]= true;
		block[7][8]= true;
		
	}
	
	public void paintComponent(Graphics g) 
	{
		for(int i = 0; i<block.length; i++)
		{
			for(int j=0; j<block[0].length; j++)
			{
				if(block[i][j] == false)
					g.setColor(Color.GREEN);
					g.fillRect(i*25, j*10, 25, 10);
				if(block[i][j] == true)
					g.setColor(Color.BLACK);
					g.fillRect(i*25, j*10, 25, 10);
			}
		}
	}
	
	public void hit(int x, int y)
	{
		if(block[x/25][y/10] == false)
			block[x/25][y/10] = true;
	}
	
	
}

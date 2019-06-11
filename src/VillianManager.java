public class VillianManager
{
	Villian[][] villians;
	boolean moveLeft = true;
	boolean moveRight = false;
	Game game;
	private boolean alive = true;
	int guess = 6;
	
	public VillianManager(Game game)
	{
		villians = new Villian[5][11];
		this.game = game;
		
		int x = Game.screenCrop;
		
		//back row
		for(int j = 0; j < villians[0].length; j++)
		{
			villians[0][j] = new Villian(x, (Game.screenHeight / 32) * 5, 100, Villian.VillianType.SQUID);
			x += 150;
		}
		
		x = Game.screenCrop;
		
		//second row
		for(int j = 0; j < villians[0].length; j++)
		{
			villians[1][j] = new Villian(x, (Game.screenHeight / 32) * 8, 50, Villian.VillianType.FOURLEGGED);
			x += 150;
		}
		
		x = Game.screenCrop;

		//third row
		for(int j = 0; j < villians[0].length; j++)
		{
			villians[2][j] = new Villian(x, (Game.screenHeight / 32) * 11, 50, Villian.VillianType.FOURLEGGED);
			x += 150;
		}
		
		x = Game.screenCrop;
		
		//fourth row
		for(int j = 0; j < villians[0].length; j++)
		{
			villians[3][j] = new Villian(x, (Game.screenHeight / 32) * 14, 25, Villian.VillianType.METROID);
			x += 150;
		}
		
		x = Game.screenCrop;
		
		//front row
		for(int j = 0; j < villians[0].length; j++)
		{
			villians[4][j] = new Villian(x, (Game.screenHeight / 32) * 17, 25, Villian.VillianType.METROID);
			x += 150;
		}
		
		//fill all rows		
		for(int i = 0; i < villians.length; i++)
		{
			for(int j = 0; j < villians[i].length; j++)
			{
				game.add(villians[i][j]);
			}
		}
	}
	
	public void UpdatePositions()
	{
		if(moveLeft)
		{
			//check the leftmost row that contains enemies
			for(int i = 0; i < villians[0].length; i++)
			{
				if(checkColumnContainsEnemy(i))
				{
					if(isPastRightWall(i))
					{
						moveLeft = false;
						moveRight = true;
						shiftDown();
					}
					
					else
					{
						shiftLeft();
					}
				}
			}
		}
		
		if(moveRight)
		{
			for(int i = villians[0].length - 1; i > 0; i--)
			{
				if(checkColumnContainsEnemy(i))
				{
					if(isPastLeftWall(i))
					{
						moveLeft = true;
						moveRight = false;
						shiftDown();
					}
					
					else
					{
						shiftRight();
					}
				}
			}
		}
		
		for(int i = 0; i < villians.length; i++)
		{
			for(int j = 0; j < villians[i].length; j++)
			{
				if(villians[i][j] != null)
				{
					villians[i][j].updateHorizontal();
					villians[i][j].updateBullet();
				}
			}
		}
	}
	
	public boolean checkColumnContainsEnemy(int column)
	{
		for(int row = 0; row < villians.length; row++)
		{
			if(villians[row][column] != null) return true;
		}
		
		return false;
	}
	
	public boolean isPastRightWall(int column)
	{
		//wall collision check
		for(int r = 0; r < villians.length; r++)
		{
			for(Villian villian : villians[r])
			{
				if(villian.getX() > Game.screenWidth - villian.getWidth())
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isPastLeftWall(int column)
	{
		//wall collision check
		for(int r = 0; r < villians.length; r++)
		{
			for(Villian villian : villians[r])
			{
				if(villian.getX() < 0)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void shiftDown()
	{
		for(int i = 0; i < villians.length; i++)
		{
			for(int j = 0; j < villians[i].length; j++)
			{
				if(villians[i][j] != null)
				{
					villians[i][j].updateVertical();
				}
			}
		}
	}
	
	public void shiftRight()
	{
		{
			for(int i = 0; i < villians.length; i++)
			{
				for(int j = 0; j < villians[i].length; j++)
				{
					if(villians[i][j] != null)
					{
						villians[i][j].setDx(-20);
					}
				}
			}
		}
	}
	
	public void shiftLeft()
	{
		{
			for(int i = 0; i < villians.length; i++)
			{
				for(int j = 0; j < villians[i].length; j++)
				{
					if(villians[i][j] != null)
					{
						villians[i][j].setDx(20);
					}
				}
			}
		}
	}
	
	public void vilShoot()
	{
		for(int i = 0; i<villians.length; i++)
		{
			for(int j = 0; j<villians[0].length; j++)
			{
				if((int) ((Math.random()*10)+1) == guess)
				{
					if(villians[i][j] != null)
					{
						villians[i][j].fire();
					}
				}
			}
		}
		
		
	}
	
	public void KillVillian(Bullet pew)
	{
		for(int i = 0; i<villians.length; i++)
		{
			for(int j = 0; j<villians[0].length; j++)
			{
				if(pew.getX() > villians[i][j].getX() && pew.getX() < villians[i][j].getX()+villians[i][j].getWidth() && pew.getY() < villians[i][j].getY() && pew.getX() < villians[i][j].getY()+villians[i][j].getHeight())
				{
					alive = false;
				}
			}
		}
		game.updatePoints();
	}
}

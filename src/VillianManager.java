public class VillianManager
{
	Villian[][] villians;
	boolean moveLeft;
	boolean moveRight;
	Game game;
	private boolean alive = true;
	int guess = 6;
	
	public VillianManager(Game game)
	{
		villians = new Villian[5][11];
		this.game = game;
		
		int x = game.screenCrop;
		
		//back row
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < villians[i].length; j++)
			{
				villians[i][j] = new Villian(x, (game.screenHeight / 32) * 6, 100, Villian.VillianType.SQUID);
				x += 100;
			}
		}
		
		x = game.screenCrop;
		
		//middle 2 rows
		for(int i = 1; i < 3; i++)
		{
			for(int j = 0; j < villians[i].length; j++)
			{
				villians[i][j] = new Villian(x, (game.screenHeight / 32) * 8, 50, Villian.VillianType.FOURLEGGED);
				x += 100;
			}
		}
		
		x = game.screenCrop;

		//front 2 rows
		for(int i = 2; i < 5; i++)
		{
			for(int j = 0; j < villians[i].length; j++)
			{
				villians[i][j] = new Villian(x, (game.screenHeight / 32) * 10, 25, Villian.VillianType.METROID);
				x += 100;
			}
		}
		
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
					if(isPastLeftWall(i))
					{
						moveLeft = false;
						moveRight = true;
						//shift everyone down
					}
				}
			}
		}
		
		if(moveRight)
		{
			for(int i = villians[0].length; i > 0; i--)
			{
				if(checkColumnContainsEnemy(i))
				{
					if(isPastLeftWall(i))
					{
						moveLeft = false;
						moveRight = true;
					}
				}
			}
		}
	}
	
	public boolean checkColumnContainsEnemy(int column)
	{
		for(int i = 0; i < villians.length; i++)
		{
			if(villians[i][column] != null) return true;
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
				if(villian.getX() > Game.screenWidth)
				{
					return true;
				}
			}
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
					villians[i][j].setDy(10);
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
	
	public void update()
	{
		
	}
}

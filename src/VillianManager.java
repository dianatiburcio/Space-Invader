public class VillianManager
{
	Villian[][] villians;
	boolean moveLeft;
	boolean moveRight;
	Game game;
	
	public VillianManager(Game game)
	{
		Villian[][] villians = new Villian[5][11];
		this.game = game;
		
		int x = 30;
		
		//back row
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < villians[i].length - 1; i++)
			{
				villians[i][j] = new Villian(x, 60, 10, Villian.VillianType.SQUID);
				x += 30;
			}
		}
		
		x = 30;
		
		//middle 2 rows
		for(int i = 1; i < 3; i++)
		{
			for(int j = 0; j < villians[i].length - 1; i++)
			{
				villians[i][j] = new Villian(x, 90, 10, Villian.VillianType.FOURLEGGED);
			}
		}
		
		x = 30;

		//front 2 rows
		for(int i = 3; i < 5; i++)
		{
			for(int j = 0; j < villians[i].length - 1; i++)
			{
				villians[i][j] = new Villian(x, 120, 10, Villian.VillianType.METROID);
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
	
	public void KillVillian(int row, int column)
	{
		int points = 10;
		
		game.updatePoints();
	}
}

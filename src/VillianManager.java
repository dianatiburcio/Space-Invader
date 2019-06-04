
public class VillianManager
{
	Villian[][] villians;
	boolean moveLeft;
	boolean moveRight;
	
	public VillianManager()
	{
		Villian[][] villians = new Villian[5][11];
		
		//back row
		for(int i = 0; i < villians[0].length; i++)
		{
			villians[0][i] = new Villian(stuff);
		}
		
		//middle 2 rows
		for(int i = 1; i < 3; i++)
		{
			for(int j = 0; j < villians[i].length; i++)
			{
				villians[i][j] = new Villian(stuff);
			}
		}
		
		//front 2 rows
		for(int i = 3; i < 5; i++)
		{
			for(int j = 0; j < villians[i].length; i++)
			{
				villians[i][j] = new Villian(stuff);
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
	}
	
	/*
	 * Returns amount of points gained from villian type killed
	 */
	public int KillVillian(int row, int column)
	{
		int points;
		
		Game.updatePoints(points);
	}
}

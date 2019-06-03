
public class VillianManager
{
	Villian[][] villians;
	
	public VillianManager()
	{
		Villian[][] villians = new Villian[5][11];
		
		//back row
		for(int i = 0; i < villians[0].size; i++)
		{
			villians[0][i] = new Villian(stuff);
		}
		
		//middle 2 rows
		for(int i = 1; i < 3; i++)
		{
			for(int j = 0; j < villians[i].size; i++)
			{
				villians[i][j] = new Villian(stuff);
			}
		}
		
		//front 2 rows
		for(int i = 3; i < 5; i++)
		{
			for(int j = 0; j < villians[i].size; i++)
			{
				villians[i][j] = new Villian(stuff);
			}
		}
	}
	
	public void UpdatePositions()
	{
		//check if the left most villian is touching a wall
		for(int i = 0; i < villians.size; i++)
		{
			
		}
	}
	
	public void KillVillian(int x, int y)
	{
		
	}
}

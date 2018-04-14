
public class College 
{
	int[] preference;
	int capacity;
	int[] beProposed;
	int[] matchTo;
	
	public College(int[] p, int ca)
	{
		setPreference(p);
		setCapacity(ca);
		setMatchTo();
	}
	
	public void setPreference(int[] p)
	{
		preference = p;
	}
	
	public int[] getPreference()
	{
		return preference;
	}
	public void setCapacity(int ca)
	{
		capacity = ca;
	}
	public int getCapacity()
	{
		return capacity;
	}
	public void setBeProposed()
	{
		beProposed = new int[capacity];
		for(int i = 0; i < capacity; i++)
		{
			beProposed[i] = -1;
		}
	}
	
	public int[] getBeProposed()
	{
		return beProposed;
	}
	
	public void setMatchTo()
	{
		matchTo = new int[capacity];
		for(int i = 0; i < matchTo.length; i++)
		{
			matchTo[i] = -1;
		}
	}
	public void setMatchTo(int student, int count)
	{
		matchTo[count] = student;
	}
	public int[] getMatchTo()
	{
		return matchTo;
	}
	public boolean isAllocated(int st)
	{
		boolean result = false;
		for(int i = 0; i < matchTo.length; i++)
		{
			if(matchTo[i] == st)
			{
				result = true;
				break;
			}
		}
		return result;		
	}
}

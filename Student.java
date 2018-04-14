
public class Student 
{
	int[] preference;
	boolean[] rejected;
	int proposeTo;
	int count = 0;
	int matchTo;
	
	public Student(int[] p)
	{
		setPreference(p);
		setRejected();
	}
	
	public void setPreference(int[] p)
	{
		preference = p;
	}
	
	public int[] getPreference()
	{
		return preference;
	}
	
	public void setRejected()
	{
		rejected = new boolean[preference.length];
		for(int i = 0; i < preference.length; i++)
		{
			rejected[i] = false;
		}
	}
	public void setBeRejected()
	{
		rejected[count] = true;
		count++;
	}
	public boolean[] getRejected()
	{
		return rejected;
	}
	
	public void setProposeTo()
	{
		for(int i = 0; i < preference.length; i++)
		{
			if(rejected[i] == false)
			{
				proposeTo = preference[i];
				break;
			}
			proposeTo = -1;
		}
	}
	public int getProposeTo()
	{
		return proposeTo;
	}
	
	
}

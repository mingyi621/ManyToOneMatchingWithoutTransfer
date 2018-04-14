import java.util.Scanner;
public class Main {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Number of Colleges:");
		int nOfCollege = sc.nextInt();
		College[] college = new College[nOfCollege];
		
		System.out.printf("Number of Students:");
		int nOfStudent = sc.nextInt();
		Student[] student = new Student[nOfStudent];
		
		int[][] preferenceOfCollege = new int[nOfCollege][nOfStudent];
		int[][] preferenceOfStudent = new int[nOfStudent][nOfCollege];
		
		for(int i = 0; i < nOfCollege; i++)
		{
			System.out.printf("The capacity of college %d:", i);
			int ca = sc.nextInt();
			System.out.printf("The preference of college %d:", i);
			for(int j = 0; j < nOfStudent; j++)
			{
				preferenceOfCollege[i][j] = sc.nextInt();
			}
			college[i] = new College(preferenceOfCollege[i], ca);
		}
		
		for(int i = 0; i < nOfStudent; i++)
		{
			System.out.printf("The preference of student %d:", i+1);
			for(int j = 0; j < nOfCollege; j++)
			{
				preferenceOfStudent[i][j] = sc.nextInt();
			}
			student[i] = new Student(preferenceOfStudent[i]);
		}
		
		// Start Deferred Acceptance Algorithm.
		for(int i = 0; i < nOfStudent; i++)
		{
			student[i].setProposeTo();
			System.out.printf("Student %d propose to college %d.\n", i, student[i].getProposeTo());
		}
		
		boolean globalRejected;
		do{
			globalRejected = false;
			for(int i = 0; i < nOfCollege; i++)
			{
				int[] preference = college[i].getPreference();
				int capacity = college[i].getCapacity();
				int count = 0;
				for(int j = 0; j < preference.length; j++)
				{
					if(preference[j] == -1)
						break;
					if(student[preference[j]].getProposeTo() == i)
					{
						college[i].setMatchTo(preference[j], count);
						System.out.printf("College %d tentatively accepted student %d.\n", i, preference[j]);
						count++;
						if(count == capacity)
							break;
					}
				}
			}
			for(int i = 0; i < nOfStudent; i++)
			{
				if(student[i].getProposeTo() == -1)
					break;
				if(!college[student[i].getProposeTo()].isAllocated(i)) // rejected
				{
					student[i].setBeRejected();
					System.out.printf("Student %d is rejected.", i);
					student[i].setProposeTo();
					System.out.printf("Student %d again propose to %d.\n", i, student[i].getProposeTo());
					globalRejected = true;
				}
			}
		}while(globalRejected);
		// End of Deferred Acceptance Algorithm
		
		// Print out the result
		for(int i = 0; i < nOfStudent; i++)
		{
			if(student[i].getProposeTo() == -1)
				System.out.printf("Student %d doesn't match.\n", i);
			else
				System.out.printf("Student %d matches to College %d\n", i, student[i].getProposeTo());
		}
		
	}

}

/*	insertion sort table plot	*/
import java.util.Scanner;
import java.util.Random;

class InsertionSort
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

		int numArr;
		long DelT[]=new long[150];

		for(numArr=500;numArr<=15000;numArr=numArr+500)
		{
		
			int array[]=new int[numArr];
		
			Random rand=new Random();
			for(int i=0;i<numArr;i++)
			{
				array[i]=rand.nextInt();
			}

			int temp=array[0];
			long time1 = System.nanoTime();
			//System.out.println(time1);
			for(int i=1;i<numArr;i++)
			{
				temp=array[i];
				for(int j=0;j<i;j++)
				{
					if(array[i]<array[j])
					{
						for(int k=i;k>j+1;k--)
							array[k]=array[k-1];
						array[j]=temp;
						break;
					}							
				}
			}
			long time2 = System.nanoTime();
			//System.out.println(time2);
			DelT[numArr/500]=time2-time1;
		
			System.out.println(DelT[numArr/500]);
		}	
	}
}

/*	Table in excel	*/

import java.util.Scanner;
import excelCell.*;

class Trial
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		HashTable ht=new HashTable();
		String ch="";
		while(ch!="q")
		{
			System.out.println("Enter cell to be edited:");
			ch=sc.next();
			if(ch=="q")
				break;
			System.out.println("Enter cell contents:");
			String exp=sc.next();

			int k=0;
			int i=0;
			
			while(ch.charAt(k)>=65 && ch.charAt(k)<91)
			{
				i+=ch.charAt(k++)-65;
			}
			int j= Integer.parseInt(ch.substring(k));
			System.out.println(i+" "+ j);
			
			ht.update(i,j,exp);
			ht.display();


		}

	}
}

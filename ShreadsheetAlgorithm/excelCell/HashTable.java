/*	Hash Table	*/

package excelCell;

public class HashTable
{
	HashNode arr2D[][]=new HashNode[26][10];
	int i,j;
	LLNode root;

	public HashTable()
	{
		root=new LLNode(this);
		for(i=0;i<26;i++)
		{
			for(j=0;j<10;j++)
			{	
				arr2D[i][j]=new HashNode((i+65)+""+j);
			}
		}
	}

	public LLNode getNode(String name)
	{
		int k=0;
		i=0;
		while(name.charAt(k)>=65 && name.charAt(k)<91)
		{
			i+=name.charAt(k++)-65;
		}
		j= Integer.parseInt(name.substring(k));
		//System.out.println(arr2D[i][j].getLink().getValue());
		return arr2D[i][j].getLink();
				
	}

	public void update(int i, int j, String exp)
	{
		arr2D[i][j].updateExpression(exp);
	}

	public void display()
	{
		for(i=0;i<26;i++)
		{
			for(j=0;j<10;j++)
			{	
				System.out.print(arr2D[i][j] + " | ");
			}
			System.out.println();
		}
	}
}

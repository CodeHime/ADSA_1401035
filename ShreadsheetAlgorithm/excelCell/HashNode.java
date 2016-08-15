/*	Hash Node	*/

package excelCell;

public class HashNode
{
	String expression,cellName;
	double value;
	LLNode link;

	public HashNode()
	{
		link=new LLNode(this);
		cellName="";
	}

	public HashNode(String cn)
	{
		link=new LLNode(this);
		cellName=cn;
	}
	
	public void updateExpression(String exp)
	{
		expression=exp;
		if(expression.charAt(0)!='=')
			value=Integer.parseInt(expression);
		System.out.println(expression);
		link.update(exp);
	}

	public void updateValue()
	{
		value=link.getValue();
		System.out.println(value);
	}

	public LLNode getLink()
	{
		return link;
	}

	public String toString()
	{
		return value+"";
	}
}

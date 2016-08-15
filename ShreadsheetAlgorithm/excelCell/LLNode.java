/*	Dependency MultiLinkedList in tree struct		*/
package excelCell;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class LLNode
{
	LLNode head,tail,cur,next;
	LLNode varLL[]=new LLNode[15];					//15 max variables in a cell
	int varCount=0;
	int order=0,preNo=-1;
	String expression;
	String tempExp;
	double value;
	HashNode cell;
	static HashTable htab;

	static LLNode root;
	
	LLNode(HashTable ht)
	{
		htab=ht;
		root= new LLNode(-1);
	}

	LLNode(int minusOne)
	{
		head=null;
		tail=null;
		expression=null;
		order=-1;
		varCount=0;
	}

	LLNode(HashNode h1){
		head=null;
		tail=null;
		cell=h1;
		if(h1.expression!=null)
		{
			expression=h1.expression;
			decryptExpression();
		}
	}

	void decryptExpression()
	{
		tempExp="";
		if (expression.charAt(0)=='=')
		{
			String varName="";
			for(int i=1;i<expression.length();i++)
			{
				if(expression.charAt(i)>='A' && expression.charAt(i)<='Z')
				{
					varName=varName+expression.charAt(i);
					System.out.println(varName);
				}
				else if	(expression.charAt(i)>='0' && expression.charAt(i)<='9')
				{	
					varName=varName+expression.charAt(i);
					System.out.println(varName);
				}
				else
				{
					System.out.println(varName);
					LLNode varCell=htab.getNode(varName);
					this.addVar(varCell);
					if(varCell.getOrder()>=order)
					{
						order=varCell.getOrder()+1;
						preNo=varCount++;
						System.out.println(preNo);
					}
					tempExp=tempExp + varCell.getValue() + expression.charAt(i);
					varName="";
				}
				
			}
					System.out.println(varName);
					LLNode varCell=htab.getNode(varName);
					this.addVar(varCell);
					if(varCell.getOrder()>=order)
					{
						order=varCell.getOrder()+1;
						preNo=varCount++;
						System.out.println(preNo);
					}
					tempExp=tempExp + varCell.getValue();
					System.out.println(varCell.getValue());
					varName="";
			if(preNo!=-1)
				varLL[preNo].LLNodeAdd(this);
		}
		else
		{
			root.LLNodeAdd(this);
			tempExp=expression;
		}

		try{
		System.out.println("temp exp:" + tempExp);
		ScriptEngineManager mgr = new ScriptEngineManager();
    		ScriptEngine engine = mgr.getEngineByName("JavaScript");
    		value=Double.parseDouble(engine.eval(tempExp).toString());
		System.out.println("updated decrpt "+value);
		cell.updateValue();
		}
		catch(Exception e)
		{}
	}

	void addVar(LLNode var)
	{
		varLL[varCount]=var;
		varLL[varCount].LLNodeAdd(this);
	}

	void LLNodeAdd(LLNode dependent)
	{
		if(head==null)
		{
			head=dependent;
			tail=head;	
			System.out.println("Head"+head.cell);
		}
		else
		{
			tail.next=dependent;
			tail=tail.next;
		}

	}

	double getValue()
	{
		return value;
	}

	int getOrder()
	{
		return order;
	}

	void updatedVar()
	{
		decryptExpression();		
		for(cur=head;cur!=tail;cur=cur.next)
		{
			cur.updatedVar();
		}
	}

	void update(String exp)
	{
		expression=exp;
		updatedVar();
	}
}


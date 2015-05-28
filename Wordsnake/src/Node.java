import java.util.*;
import java.lang.String;

public class Node extends Object
{
	private ArrayList nodes = new ArrayList();
	private Vector values = new Vector();
	
	private String word;
	
	
	public Node(String str)
	{
		word = new String(str);		
	}
	
	public void addNode(Object node)
	{
		nodes.add(node);
	}
	
	public void addValue(Object value)
	{
		values.add(value);
	}
	public Object getValue(int index)
	{
		return values.get(index);		
	}
	
	public String getWord()
	{
		return word;
	}
	
	public void printVals()
	{
		for (int i = 0; i < nodes.size(); i++)
		{
			Node node = (Node)nodes.get(i);
			//System.out.print(node.getWord()+ values.get(i) + " " );
		}
	}
	public Node getNodeFromList(int i)
	{
		return (Node)nodes.get(i);		
	}
	
	public Vector getValues()
	{
		return values;
	}
}
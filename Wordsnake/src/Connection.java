
public class Connection
{
	private int value;
	private Node fromNode;
	private Node toNode;

	public void setFrom(Node from)
	{
		fromNode = from;
	}
	
	public void setTo(Node to)
	{
		toNode = to;
	}
	
	public void setValue(int val)
	{
		value = val;
	}
	
	public void printConnection()
	{
		System.out.println("\nFrom node = "+ fromNode.getWord());
		System.out.println("To node = "+ toNode.getWord());
		System.out.println("Value = " + value);
	}
	
	public Node getFromNode()
	{
		return fromNode;
	}
	
	public Node getToNode()
	{
		return toNode;
		
	}
	public int getValue()
	{
		return value;
	}
}
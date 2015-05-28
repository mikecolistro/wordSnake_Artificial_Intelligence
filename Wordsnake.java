import java.io.*;
import java.util.*;

public class Wordsnake
{
	public static void main(String[] args)
	{
		Graph newGraph = new Graph();
		int bufReader = newGraph.makeGraph();
		if(bufReader == -1)
		{
			System.out.println("Could not open the file");
			return;
		}
				
		newGraph.printNodes();
		int value = 0;
		
		do
		{
			Connection maxLink = newGraph.findMaxValue();
			maxLink.printConnection();
			value += maxLink.getValue()*maxLink.getValue();
			
			Node from = maxLink.getFromNode();
			Node to = maxLink.getToNode();
			newGraph.joinWords(from.getWord(),to.getWord(),maxLink.getValue());
			newGraph.redoGraph();
		
			newGraph.printNodes();
			//System.out.println("\nNumber of words = " +newGraph.getWords().size());
		}while(newGraph.getWords().size() > 1);
		
		System.out.print("\nFinal word = "+ (String)newGraph.getWords().get(0));
		System.out.print("\nMaximal number = " + value);
	}
}
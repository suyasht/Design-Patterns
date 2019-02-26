package wordCount.treesForStrings;

import wordCount.util.Results;
import java.util.ArrayList;
import wordCount.modules.ModuleVisitor;
import wordCount.treesForStrings.Node;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

public class TreeMaker {
	private Node root;
	private int countCharacters=0;
	private ArrayList<String> words = new ArrayList<String>();
	private int distinctCount=0;
	
	/**
	 * Constructs a TreeMaker object with a blank root
	 */
	public TreeMaker() {
		Logger.writeMessage("Constructing a TreeMaker...",DebugLevel.CONSTRUCTOR);
		root = null;
	}
	
	/**
	 * Inserts a node into the tree in tree order
	 * @param node Node to insert into the tree
	 */
	public void insertNode(Node node) {
		Logger.writeMessage("Attempting to insert node...", DebugLevel.TREE_MAKER);
		if(root==null) {
			root = node;
			Logger.writeMessage("Node is set as root.", DebugLevel.TREE_MAKER);
			return;
		}
		Node temp = root;
		while(true) {
			if(node.compareTo(temp)<0) {
				if(temp.getLeft()==null) {
					temp.setLeft(node);
					Logger.writeMessage("Node was set to the left.", DebugLevel.TREE_MAKER);
					temp = null;
					return;
				}
				temp = temp.getLeft();
				continue;
			}
			else {
				if(temp.getRight()==null) {
					temp.setRight(node);
					Logger.writeMessage("Node was set to the right.", DebugLevel.TREE_MAKER);
					temp = null; //reference management
					return;
				}
				Logger.writeMessage("Temp moved to the right.", DebugLevel.TREE_MAKER);
				temp = temp.getRight();
				continue;
			}
		}
	}
	/**
	 * Searches for a node in the tree. Returns the node if it exists, null otherwise
	 * @param findMe Node to search for
	 * @return reference to the node if it exists in the tree, or null otherwise
	 */
	public Node search(Node findMe) {
		if(root==null)
			return null;
		Node temp = root;
		while(true) {
			if(findMe.equals(temp)) {
				Logger.writeMessage("Successfully found node.", DebugLevel.TREE_MAKER);
				return temp;
			}
			else if(findMe.compareTo(temp)<0) {
				if(temp.getLeft()==null)
					return null;
				temp = temp.getLeft();
				Logger.writeMessage("Temp moved left.", DebugLevel.TREE_MAKER);
				continue;
			}
			else if(findMe.compareTo(temp)>0) {
				if(temp.getRight()==null)
					return null;
				temp = temp.getRight();
				Logger.writeMessage("Temp moved right.", DebugLevel.TREE_MAKER);
				continue;
			}
		}
	}
	/**
	 * Stores contents of all node in tree in the Results instance
	 * @param r Results instance to write Node contents to
	 */
	public void printNodes(Results r) {
		Logger.writeMessage("Attempting to printNodes().", DebugLevel.TREE_MAKER);
		inOrderPrint(root,r);	
	}
	/**
	 * This calls the visit() method on the current visitor
	 * @param visitor visitor to defer to when calling the visit() method
	 */
	public void accept(ModuleVisitor visitor) {
		visitor.visit(this);
	}
	public int numberOfWords() 
	{        
        return numberOfWordsHelper(root);
	}
	private int numberOfWordsHelper(Node n) {
		if(n== null)
        {
        	return 0;
        }
        if (n.getLeft() == null && n.getRight() == null) 
        {
            return 1;
        }
        return numberOfWordsHelper(n.getLeft()) + numberOfWordsHelper(n.getRight()) +1 ;
	}
	
	public int numberOfCharacters()
	{
		return numberOfCharacterHelper(root);
	}
	public int numberOfCharacterHelper(Node n)
	{
		if(n==null)
			return 0;
		numberOfCharacterHelper(n.getLeft());
		words.add(n.toString());
		System.out.println(n.toString());
		countCharacters = countCharacters +  n.toString().length();
		numberOfCharacterHelper(n.getRight());
		return countCharacters;
	}
	
	public int numberOfDistinct() {
	
		return numberOfDistinctHelper (root);
	}
	
	public int numberOfDistinctHelper(Node n) 
	{
		 for (int i = 0; i < words.size(); i++)
	        {	          
	            int j;
	            for (j = 0; j < i; j++)
	            {
	            	if (words.get(i).equals(words.get(j)))
	                {
	            		break;
	                }
	            }
	            if (i == j)
	            {	            
	            	distinctCount++;
	            }
	        }
		 return distinctCount;
	}	
	/**
	 * Helper method to recursively print tree contents in sorted order
	 * @param n Node to recursively traverse
	 */
	private void inOrderPrint(Node n, Results result) {
		if(n==null)
			return;
		inOrderPrint(n.getLeft(),result);
		result.storeTestResult(n.toString()+"\n");
		inOrderPrint(n.getRight(),result);
	}

}
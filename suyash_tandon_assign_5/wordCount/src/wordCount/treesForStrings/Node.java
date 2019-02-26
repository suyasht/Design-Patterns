package wordCount.treesForStrings;

import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

public class Node implements Comparable<Node>{
	
	private Node left,right;
	private String data;
	/**
	 * Constructs a node containing a string
	 * @param data string to be stored in the node
	 */
	public Node(String data) {
		Logger.writeMessage("Constructing a Node.", DebugLevel.CONSTRUCTOR);
		this.data = data;
	}
	/**
	 * Returns the left node of the current node
	 * @return left left Node of the current node
	 */
	public Node getLeft() {
		return left;
	}
	/**
	 * Sets the left node of the current node
	 * @param left Node that will become the left node of the current node
	 */
	public void setLeft(Node left) {
		this.left = left;
	}
	/**
	 * Returns the right node of the current node
	 * @return right Node of the current node
	 */
	public Node getRight() {
		return right;
	}	
	/**
	 * Sets the right node of the current node
	 * @param right Node that will become the right node of the current node
	 */
	public void setRight(Node right) {
		this.right = right;
	}
	/**
	 * Returns the contents of the node
	 * @return string contained in the current node
	 */
	public String getData() {
		return data;
	}	
	/**
	 * @param other Node to compare to the current node
	 * @return true if the strings contained are equal, false otherwise
	 */
	public boolean equals(Node other) {
		return (this.data.equals(other.data));
	}
	@Override
	public int compareTo(Node other) {
		return this.data.compareTo(other.data);
	}
	/** 
	 * Returns string contained in the node
	 * @return returns data
	 */
	public String toString() {
		return data;
	}
}

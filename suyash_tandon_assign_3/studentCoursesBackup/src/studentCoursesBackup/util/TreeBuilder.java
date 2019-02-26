package studentCoursesBackup.util;

import java.io.IOException;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.MyLogger.debugLevel;

/**
 *  Reference taken from  : https://www.geeksforgeeks.org/
 *
 */
public class TreeBuilder {
	
	String bNum= " ";
	String msg=null;
	Node root;
	FileProcessor fp= new FileProcessor();
	debugLevel builder;
	String printToFile= " ";
	
	/**
	 *  Method to insert a Course 
	 *
	 */
	public Node treeInsert(Node root, int key, String newCourse)
	{
		if (root == null) 
		{
			root = new Node(key, newCourse);
			return root;
		}
		if (key < root.key)
		{
			root.left = treeInsert(root.left, key, newCourse);
		}
		else if (key > root.key)
		{
			root.right = treeInsert(root.right, key, newCourse);
		}
		else if (key == root.key) 
		{
			if (!root.courses.contains(newCourse)) 
			{
				root.courses.add(newCourse);
			}
		}
		return root;
	}
	/**
	 *  Method to insert bnumber for a course
	 *
	 */
	public Node treeInsert1(Node root, Node type1) 
	{
		if (root == null) 
		{
			root = type1;
			return root;
		}
		if (type1.key < root.key)
		{
			root.left = treeInsert1(root.left, type1);
		}
		else if (type1.key > root.key)
		{
			root.right = treeInsert1(root.right, type1);
		}
		else if (type1.key == root.key) 
		{
			root = type1;
		}
		return root;
	}
	/**
	 *  Method to delete a node 
	 *
	 */
	public Node treeDelete(Node root, String deleteCourse, int key)
	{
		if (root == null) 
		{
			return root;
		}
		if ((key == root.key) && (root.courses.contains(deleteCourse))) 
		{
			root.courses.remove(deleteCourse);
		}
		else if (key < root.key) 
		{
			root.left = treeDelete(root.left, deleteCourse, key); 
		} 
		else if (key > root.key) 
		{
			root.right = treeDelete(root.right, deleteCourse, key);
		}  
		return root;
	}
	
	/**
	 *  Method to split the bnumber and the course name and forward it for deletion 
	 *
	 */
	public void delete(String course) 
	{
		String course_name = course.substring(course.indexOf(":")+1);
		String st=course.substring(0,course.indexOf(":"));
		int b_number=Integer.parseInt(st);
		if((b_number <0000) || (b_number > 9999))
		{
			msg = "Course Number to be deleted is Invalid";
			MyLogger.writeMessage(msg, builder);
			System.exit(0);			
		}
		if(course_name.length()!=1)
		{
			msg ="Course Name to be deleted is Invalid";
			MyLogger.writeMessage(msg, builder);
			System.exit(0);
		}
		else if ((course_name.length()==1) && ((b_number > 0000) && (b_number < 9999)))
		{
			if(course_name.equals("A") || course_name.equals("B") || course_name.equals("C") || course_name.equals("D")
					|| course_name.equals("E")|| course_name.equals("F")|| course_name.equals("G") || course_name.equals("H") || 
					course_name.equals("I") || course_name.equals("J") || course_name.equals("K"))
			{
				root = treeDelete(root, course_name, b_number);
				root.notifyAll(root);
			}
			else
			{
				msg = "Course Name to be deleted is Invalid";
				MyLogger.writeMessage(msg, builder);
				System.exit(0);
			}
		}
	}
	
	/**
	 *  Method to search in the tree 
	 *
	 */
	public Node treeSearch(Node root, int key)
	{
		    
	    if (root==null || root.key==key)
	    {
	        return root;
	    }
	    if (root.key < key)
	    {
	        return treeSearch(root.right, key);
	    }
	    else
	    {
	    	return treeSearch(root.left, key);
	    }
	}
	/**
	 *  Method to split the bnumber and the course name and forward it for insertion 
	 *
	 */
	
	public Node[] splitNinsert(String course) 
	{
		String course_name = course.substring(course.indexOf(":")+1);
		String st=course.substring(0,course.indexOf(":"));
		int b_number=Integer.parseInt(st);
		if((b_number <0000) || (b_number > 9999))
		{
			msg = " Course Number is Invalid.";
			MyLogger.writeMessage(msg, builder);
			System.exit(0);
			return null;
		}
		
		if(course_name.length()!=1)
		{
			msg = "Course Name is Invalid.";
			MyLogger.writeMessage(msg, builder);
			System.exit(0);
			return null;
		}
		else if ((course_name.length()==1) && ((b_number > 0000) && (b_number < 9999)))
		{
			if(course_name.equals("A") || course_name.equals("B") || course_name.equals("C") || course_name.equals("D")
					|| course_name.equals("E")|| course_name.equals("F")|| course_name.equals("G") || course_name.equals("H") || 
					course_name.equals("I") || course_name.equals("J") || course_name.equals("K"))
			{
				root = treeInsert(root, b_number, course_name);
				Node[] cloneNode = new Node[2];
				cloneNode[0] = root.clone();
				cloneNode[1] = root.clone();
				root.observer1 = cloneNode[0];
				root.observer2 = cloneNode[1];
				return cloneNode;
			} 
			else
			{
				msg= "Course Name is Invalid.";
				MyLogger.writeMessage(msg, builder);
				System.exit(0);
			}
		}
		else
		{
			msg = "Cannot add multiple courses ";
			MyLogger.writeMessage(msg, builder);
			System.exit(0);
		}
		return null;
	}
	
	/**
	 *  Method used to print the data 
	 *
	 */
	public void printNodes(Node root) 
	{
		if (root != null) 
		{
			printNodes(root.left);
			printToFile = printToFile + root.key + ":" + root.courses + "\n";
			printNodes(root.right);
		}
	}
	/**
	 * Helper Method to call insertion method 
	 *
	 */
	public void addCourse(Node node) 
	{
		root = treeInsert1(root, node);
		root.observer1 = null;
		root.observer2= null;
	}
	
	public String printing() {
		// TODO Auto-generated method stub
		printToFile= "";
		printNodes(root);		
		return printToFile;
	}

}

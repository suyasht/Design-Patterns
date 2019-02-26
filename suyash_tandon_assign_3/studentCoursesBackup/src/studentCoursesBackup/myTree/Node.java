package studentCoursesBackup.myTree;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import studentCoursesBackup.util.FileProcessor;

public class Node implements Cloneable, SubjectI, ObserverI {
	
	public List<String> courses= new ArrayList<String>();
	public int key;
	public Node left;
	public Node right;
	public Node observer1;
	public Node observer2;
	
	public Node(int item, String name)
	{
		key=item;
		courses.add(name);
		left=null;
		right=null;
	}

	@Override
	public void update(Node update, Node type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyAll(Node i) {
		// TODO Auto-generated method stub
		
	}
	
	public Node clone()
	{
	
		Node cNode=null;
		try 
		{
			cNode=(Node) super.clone();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cNode;
	}

}

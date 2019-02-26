package maxKVisitors.util;

import java.util.ArrayList;

public class MyArray implements MyArrayI {

     public static ArrayList<Integer> intList = null;
     Results re=new Results();
     
     public MyArray()
     {
    	 intList=new ArrayList<Integer>();
     }

	public void addIntArray(int num) 
	{
		intList.add(num);
	}

	public void accept(PopulateVisitorI pv, int x)
	{		
		pv.visit(this,x);
	}
	public void printarray(int x)
	{
		for (int i=0; i<x; i++)
		{
			String str=" "+intList.get(i);
			re.writeToStdout(str);	
		}
		re.writeToStdout("\n");
	}
}
 
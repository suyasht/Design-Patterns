package maxKVisitors.util;

import java.util.Vector;

public class MyVector implements MyVectorI {

	public static Vector<Integer> intList= new Vector<Integer>();
	Results re=new Results();
	@Override
	public void addIntVector(int num) 
	{
		intList.add(num);
		
	}
	public void accept(PopulateVisitorI pv, int x)
	{
		pv.visit(this, x);
	}
	public void printVector(int x)
	{
		for (int i=0; i<x; i++)
		{
			String str=" "+intList.get(i);
			re.writeToStdout(str);	
		}
		re.writeToStdout("\n");
	}
}

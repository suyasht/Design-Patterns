package maxKVisitors.util;

import maxKVisitors.util.MyLogger.debugLevel;

public class BubbleSortArray 
{
	debugLevel bubble;
	public void BubbleSort()
	{	
		for (int i = 0; i < (MyArray.intList.size())-1; i++)
		{
		   for(int j = 0; j < (MyArray.intList.size()-i-1);j++)
		   {
			   if ( MyArray.intList.get(j) < MyArray.intList.get(j+1) )
	            {
	                int temp = MyArray.intList.get(j);
	                MyArray.intList.set(j, MyArray.intList.get(j+1));
	                MyArray.intList.set(j + 1, temp);	                
	            }
		   }
		}	
	}
	public void accept(ModifiedBubbleSortVisitorI mbsv)
	{
		
		mbsv.visit(this);
	}

}

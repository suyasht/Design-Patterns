package maxKVisitors.util;

import maxKVisitors.util.MyLogger.debugLevel;

public class BubbleSortVector {

	debugLevel bubble;
	public void BubbleSort()
	{			
		for (int i = 0; i < (MyVector.intList.size())-1; i++)
		{
		   for(int j = 0; j < (MyVector.intList.size()-i-1);j++)
		   {
			   if ( MyVector.intList.get(j) < MyVector.intList.get(j+1) )
	            {
	                int temp = MyVector.intList.get(j);
	                MyVector.intList.set(j, MyVector.intList.get(j+1));
	                MyVector.intList.set(j + 1, temp);	                
	            }
		   }
		}
	}
	public void accept(ModifiedBubbleSortVisitorI mbsv)
	{
		
		mbsv.visit(this);
	}
}

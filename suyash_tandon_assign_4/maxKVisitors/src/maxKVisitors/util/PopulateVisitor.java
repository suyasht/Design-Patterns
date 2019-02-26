package maxKVisitors.util;

import maxKVisitors.util.MyLogger.debugLevel;

public class PopulateVisitor implements PopulateVisitorI {

	debugLevel res;
	public void visit(MyArray myarray, int x) 
	{		
		
		myarray.addIntArray(x);
	}

	public void visit(MyVector myvector, int x) 
	{
		
		myvector.addIntVector(x);	
  	}

}
  
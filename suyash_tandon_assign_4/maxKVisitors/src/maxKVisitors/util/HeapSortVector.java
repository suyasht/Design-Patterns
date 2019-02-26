package maxKVisitors.util;

public class HeapSortVector {
	public void HeapSort()
	{
		HeapSort hs= new HeapSort();
		hs.sort(MyVector.intList);				
	}	
	
	public void accept(HeapSortVisitorI mhv)
	{
		mhv.visit(this);
	}

}

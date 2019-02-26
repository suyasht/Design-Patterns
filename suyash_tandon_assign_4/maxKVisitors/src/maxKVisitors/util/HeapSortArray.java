package maxKVisitors.util;

public class HeapSortArray {
	public void HeapSort()
	{
		HeapSort hs= new HeapSort();
		hs.sort(MyArray.intList);
	}	
	
	public void accept(HeapSortVisitorI mhv)
	{
		mhv.visit(this);
	}

}

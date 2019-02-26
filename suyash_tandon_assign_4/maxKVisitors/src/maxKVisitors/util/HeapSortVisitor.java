package maxKVisitors.util;

public class HeapSortVisitor implements HeapSortVisitorI {

	@Override
	public void visit(HeapSortArray heapsortarray)
	{
		heapsortarray.HeapSort();
	}

	@Override
	public void visit(HeapSortVector heapsortvector) {
		heapsortvector.HeapSort();
		
	}


}

package maxKVisitors.util;

public class ModifiedBubbleSortVisitor implements ModifiedBubbleSortVisitorI{

	
	BubbleSortArray bsa=new BubbleSortArray();
	BubbleSortVector bsv= new BubbleSortVector();
	
	public void visit(BubbleSortArray bubblesortarray)
	{
		bsa.BubbleSort();
	}

	
	public void visit(BubbleSortVector bubblesortvector)
	{	
		bsv.BubbleSort();
	}

}
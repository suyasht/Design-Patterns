package maxKVisitors.driver;

import java.io.FileNotFoundException;
import java.io.IOException;

import maxKVisitors.util.BubbleSortArray;
import maxKVisitors.util.BubbleSortVector;
import maxKVisitors.util.FileProcessor;
import maxKVisitors.util.HeapSortArray;
import maxKVisitors.util.HeapSortVector;
import maxKVisitors.util.HeapSortVisitor;
import maxKVisitors.util.HeapSortVisitorI;
import maxKVisitors.util.ModifiedBubbleSortVisitor;
import maxKVisitors.util.ModifiedBubbleSortVisitorI;
import maxKVisitors.util.MyArray;
import maxKVisitors.util.MyLogger;
import maxKVisitors.util.MyLogger.debugLevel;
import maxKVisitors.util.MyVector;
import maxKVisitors.util.PopulateVisitor;
import maxKVisitors.util.PopulateVisitorI;
import maxKVisitors.util.Results;


public class Driver {

	static debugLevel driver;
	public static void main(String args[]) throws IOException
	{
		MyArray myarray1 =new MyArray();		
		MyVector myvector1=new MyVector();
		
		PopulateVisitorI pv= new PopulateVisitor();
		HeapSortVisitorI mhv= new HeapSortVisitor();
		ModifiedBubbleSortVisitorI mbsv= new ModifiedBubbleSortVisitor();
		
		
		BubbleSortArray bsa= new BubbleSortArray();
		BubbleSortVector bsv= new BubbleSortVector();
		HeapSortArray hsa= new HeapSortArray();
		HeapSortVector hsv= new HeapSortVector();
		FileProcessor fp= new FileProcessor();
		FileProcessor fp1= new FileProcessor();
		Results re=new Results();
		String message=null;
		int k=Integer.parseInt(args[1]);
		if(args.length == 3)
		{
			int debugLevel = Integer.parseInt(args[2]);
			if((args[0].equals("input.txt")) && ((debugLevel>=1) && (debugLevel<=6))) 
			{
				try
				{
					while ((fp.readline(args[0])) != null) 
					{						
						try 
						{
							int x= fp1.nextInt(args[0]);
							myarray1.accept(pv,x);
							myvector1.accept(pv,x);							
						}
						
						catch(Exception  e) 
						{					
							message = "Check values";
							MyLogger.writeMessage(message, driver);
						}
					}	
					re.writeToStdout("Result after Bubble Sort on Array \n");
					bsa.accept(mbsv);
					myarray1.printarray(k);
					re.writeToStdout("Result after Bubble Sort on Vector \n");
					bsv.accept(mbsv);
					myvector1.printVector(k);
					re.writeToStdout("Result after heap Sort on Array \n");			
					hsa.accept(mhv);
					myarray1.printarray(k);
					re.writeToStdout("Result after heap Sort on Vector \n");
					hsv.accept(mhv);
					myvector1.printVector(k);
					
				}
				catch (FileNotFoundException e) 
				{
					message = "Input.txt not Found";
					MyLogger.writeMessage(message, driver);
					System.exit(0);
				}
				
				
			}
			else 		
			{				
				message = "Enter correct file names and/or debug level(<4)";
				MyLogger.writeMessage(message, driver);
				System.exit(0);
			}
		}
		else
		{			
			message = "Invalid number of arguements Entered.";
			MyLogger.writeMessage(message, driver);
			System.exit(0);
		} 	
	}
					
}


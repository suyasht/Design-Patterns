package myArrayList.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import myArrayList.MyArrayList;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;

public class myArrayListTest extends Results
{
	static MyArrayList mal=new MyArrayList();
	
	// Contains all the test cases
	
	public void testMe(MyArrayList myArrayList, Results results) throws IOException
	{
		
		
		myArrayListTest.sumOfValues();
		myArrayListTest.findIndexOfValueThatExists();
		myArrayListTest.removeAValueThatExits();
		myArrayListTest.sizeOfArray();
		myArrayListTest.sumBeforeAndAfterRemovingValue();
		myArrayListTest.sizeBeforeAndAfterRemovingValue();
		myArrayListTest.removeValueMoreThanOnce();
		myArrayListTest.removeAValueThatDoesNotExist();
		myArrayListTest.findIndexOfValueThatDoesNotExist();
		myArrayListTest.printArrayToConsole();
		
	}
	static void sumOfValues()
	{
		Results.storeNewResult("---------TEST NUMBER 1-----------");
		Results.storeNewResult("The sum of all the values in the array list is : " + mal.sum());					
		Results.storeNewResult("Test sumOfValues passed ");
	}
	static void findIndexOfValueThatExists()
	{
		Results.storeNewResult("---------TEST NUMBER 2-----------");
		Results.storeNewResult("Find Index of 50");
		int x= mal.indexOf(50);
		if(x==-1)
		{
			Results.storeNewResult("Element doesnt exist");
			Results.storeNewResult("Test findIndexOfValueThatExists Failed");
		}
		else
		{
			Results.storeNewResult("Element is at index " +x);
			Results.storeNewResult("Test findIndexOfValueThatExists Passed");
		}		
		
	}
	static void removeAValueThatExits()
	{
		Results.storeNewResult("---------TEST NUMBER 3-----------");
		Results.storeNewResult("Remove 50");
		String x= mal.removeValue(50);
		Results.storeNewResult(x);
		if(x.equals("Value Deleted"))
		{
			Results.storeNewResult("Test removeAValueThatExits Passed");		
		}
		else
		{
			Results.storeNewResult("Test removeAValueThatExits Failed");			
		}
	}
	static void sizeOfArray()
	{
		Results.storeNewResult("---------TEST NUMBER 4-----------");
		Results.storeNewResult("Size of the arrray is " +mal.size());
		Results.storeNewResult("Test sizeOfArray Passed");
	}
	
	
	static void sumBeforeAndAfterRemovingValue()
	{
		Results.storeNewResult("---------TEST NUMBER 5-----------");
		Results.storeNewResult("Compare sum before and after removing Value 65");
		int x=mal.sum();
		Results.storeNewResult("The sum of all the values in the array list is : " + x);
		Results.storeNewResult(mal.removeValue(65));
		int y=mal.sum();
		Results.storeNewResult("The sum of all the values in the array list is : " + y);
		if(x!= y)
		{
			Results.storeNewResult("Test sumBeforeAndAfterRemovingValue Passed");
		}
		else
		{
			Results.storeNewResult("Test sumBeforeAndAfterRemovingValue Failed");
		}
	}
	static void sizeBeforeAndAfterRemovingValue()
	{
		Results.storeNewResult("---------TEST NUMBER 6-----------");
		Results.storeNewResult("Compare size before and after removing Value 75");
		int x=mal.size();
		Results.storeNewResult("Size of the arrray is " +x);
		Results.storeNewResult(mal.removeValue(75));
		int y=mal.size();
		Results.storeNewResult("Size of the arrray is : " + y);
		if(x== y)
		{
			Results.storeNewResult("Test sizeBeforeAndAfterRemovingValue Passed");
		}
		else
		{
			Results.storeNewResult("Test sizeBeforeAndAfterRemovingValue Failed");
		}
	}
	static void removeValueMoreThanOnce()
	{
		Results.storeNewResult("---------TEST NUMBER 7-----------");
		Results.storeNewResult("Remove a value that exists more than once: 90");
		String x= mal.removeValue(90);
		Results.storeNewResult(x);		
		if(x.equals("Value Deleted"))
		{
			Results.storeNewResult("Test removeValueMoreThanOnce Passed");		
		}
		else
		{
			Results.storeNewResult("Test removeValueMoreThanOnce Failed");			
		}
	}
	static void removeAValueThatDoesNotExist()
	{
		Results.storeNewResult("---------TEST NUMBER 8-----------");
		Results.storeNewResult("Trying to remove a value that doesnt exist: 99");
		String x= mal.removeValue(99);
		Results.storeNewResult(x);
		
		if(x.equals("Value Deleted"))
		{
			Results.storeNewResult("Test removeAValueThatDoesNotExit Failed");		
		}
		else
		{
			Results.storeNewResult("Test removeAValueThatDoesNotExist Passed");			
		}
	}

	static void findIndexOfValueThatDoesNotExist()
	{
		Results.storeNewResult("---------TEST NUMBER 9-----------");
		Results.storeNewResult("Trying to find indexOF a value that doesnt exist: 199");
		int x= mal.indexOf(199);
		if(x==-1)
		{
			Results.storeNewResult("Element doesnt exist");
			Results.storeNewResult("Test findIndexOfValueThatDoesNotExist Passed");
		}
		else
		{
			Results.storeNewResult("Element is at index " +x);
			Results.storeNewResult("Test findIndexOfValueThatDoesNotExist Failed");
		}		
		
	}
	static void printArrayToConsole()
	{
		Results.storeNewResult("---------TEST NUMBER 10-----------");
		mal.printToString();
		Results.storeNewResult("Test printArrayToConsole Passed");
		
	}
	

}

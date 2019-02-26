package myArrayList.Driver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import myArrayList.MyArrayList;
import myArrayList.test.myArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;

public class Driver 
{
	// Main methods that calls method in MyArrayListTest
	
	public static void main(String []args)throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		//System.out.println("Enter the file name to be read");
		
		FileProcessor fp=new FileProcessor();
		MyArrayList mal=new MyArrayList();
		mal.MyArrayList();
		try
		{
			fp.readline(args[0]);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

		
		Results re=new Results();
		
		myArrayListTest malt=new myArrayListTest();
		
		malt.testMe(mal,re);
		
		
		re.printResult(args[1]);
		
		 System.out.println("Program Execution Completed. Check the output file created for test case evaluation");
		System.exit(0);
	}


}

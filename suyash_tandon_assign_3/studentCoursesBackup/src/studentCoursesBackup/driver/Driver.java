package studentCoursesBackup.driver;

import java.io.FileNotFoundException;
import java.io.IOException;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.MyLogger.debugLevel;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

public class Driver 
{

	static debugLevel driver;
	public static void main(String[] args) throws IOException 
	{
		TreeBuilder tree1 = new TreeBuilder();
		TreeBuilder tree2 = new TreeBuilder();
		TreeBuilder tree3 = new TreeBuilder();
		FileProcessor fp1 = new FileProcessor();
		FileProcessor fp2 = new FileProcessor();
		Results re = new Results();
		
		
		String message=null;
		String data=null;
		if(args.length == 6)
		{
			int debugLevel = Integer.parseInt(args[5]);
			if((args[0].equals("input.txt")) && (args[1].equals("delete.txt")) && (args[2].equals("output1.txt"))
					&& (args[3].equals("output2.txt")) && (args[4].equals("output3.txt")) && ((debugLevel>=1) && (debugLevel<=4))) 
			{
				try
				{
					while ((data = fp1.readline(args[0])) != null) 
					{
						Node[] n = new Node[2];
						try 
						{
							n = tree1.splitNinsert(data);
							if (n[0] != null) 
							{
								tree2.addCourse(n[0]);
								tree3.addCourse(n[1]);
							}
						}
						catch(ArrayIndexOutOfBoundsException e) 
						{					
							message = "Check courses";
							MyLogger.writeMessage(message, driver);
						}
					}
				}
				catch (FileNotFoundException e) 
				{
					message = "Input.txt not Found";
					MyLogger.writeMessage(message, driver);
					System.exit(0);
				}
				
				
				try 
				{
					while ((data = fp2.readline(args[1])) != null) 
					{
						tree1.delete(data);
					}
				}
				catch (FileNotFoundException e) 
				{
					
					message = "delete.txt not Found";
					MyLogger.writeMessage(message, driver);
					System.exit(0);
				}
			
				re.writeToFile(args[2], tree1);
				re.writeToFile(args[3], tree2);
				re.writeToFile(args[4], tree3);
			}
			else 		
			{				
				message = "Enter correct file names and debug level(<4)";
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

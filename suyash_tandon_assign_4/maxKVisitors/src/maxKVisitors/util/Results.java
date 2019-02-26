package maxKVisitors.util;

import java.io.IOException;
import java.io.PrintWriter;

import maxKVisitors.util.MyLogger.debugLevel;

/**
 * This class  prints the output nodes in output
 * file and in console.
 * It extends the interface StdoutDisplayInterface and FileDisplayInterface
 */
public class Results implements StdoutDisplayInterface, FileDisplayInterface
{
	debugLevel res;
	String message;
	PrintWriter writer;
	public void writeToStdout(String x) 
	{
		//message = t.printing();
		
		System.out.print(x);
	}
	public void writeToFile(String o) 
	{
		try 
		{
			 writer = new PrintWriter(o,"UTF-8");
			//writer.println(t.printing());
			
		} 
		catch (IOException e) 
		{
			message = "Output File not found";
			MyLogger.writeMessage(o, res);
		} 
		finally
		{
			writer.close();
		}
	}
}

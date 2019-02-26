package studentCoursesBackup.util;

import java.io.IOException;
import java.io.PrintWriter;

import studentCoursesBackup.util.MyLogger.debugLevel;

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
	public void writeToStdout(TreeBuilder t) 
	{
		message = t.printing();
		MyLogger.writeMessage(message, res);
	}
	public void writeToFile(String o,TreeBuilder t) 
	{
		try 
		{
			 writer = new PrintWriter(o,"UTF-8");
			writer.println(t.printing());
			
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

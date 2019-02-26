package fourWayStreetLights.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/*
 * This class is used to implement FileDisplayInterface, StdoutDisplayInterface
 * interfaces.
 * It has methods that write to file, console.
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface 
{
	
	private static List<String> storeResults = new ArrayList<String>();
	static int x=0;	
	// Writes the output stored in the list to file	
	public void writeToFile(String s) 
	{
		// TODO Auto-generated method stub
		PrintWriter writer = null;		
		try 
		{			
			writer = new PrintWriter(s, "UTF-8");
			for(String st: storeResults)
			{				
				writer.println(st);
			}			
		} 		
		catch (Exception e) 
		{			
			e.printStackTrace();
		}				
		finally
		{
			writer.close();
		}					
	}
	// Writes Output to Console. For Debugging purposes.
	@Override
	public void writeToStdout(String s)
	{
		// TODO Auto-generated method stub
		System.out.println(s);		
	}
	// Adds new result to the List
	public static void storeNewResult(String test)
	{
		storeResults.add(test);			
	}
	public static void printResult(String s)
	{
		Results re=new Results();
		re.writeToFile(s);
	}
}
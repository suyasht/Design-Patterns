package fourWayStreetLights.driver;

import java.io.FileNotFoundException;
import java.io.IOException;

import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Results;
import fourWayStreetLights.util.helper;
/*
 * This is the Driver class.
 * This has the main method for this project. 
 * Here instances of helper class and results are
 * created and methods on it
 * are called. 
 */
public class Driver {

	public static void main(String args[])throws IOException
	{
		helper hp=new helper();
		try
		{
			if(!(args[0].equals("input.txt")))
			{
				throw new FileNotFoundException("Error");
			}
			hp.accessInput(args[0]);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.err.println("Wrong Input File name entered");
			System.exit(1);
		}
		try
		{
			if(!(args[1].equals("output.txt")))
			{
				throw new FileNotFoundException("Error");
			}
			Results.printResult(args[1]);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.err.println("Wrong Output File name entered");
			System.exit(1);
		}
		try
		{
			if(Integer.parseInt(args[2]) > 14 )
			{
				throw new RuntimeException("Error");
			}
			Logger.setDebugValue(Integer.parseInt(args[2]));			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Wrong Logger Value entered");
			System.exit(1);
		}
		
		System.out.println("Complete");
		
	}
}
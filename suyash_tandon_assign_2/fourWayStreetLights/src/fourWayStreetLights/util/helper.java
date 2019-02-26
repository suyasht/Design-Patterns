package fourWayStreetLights.util;

import java.io.IOException;

import fourWayStreetLights.service.StreetLightsContext;

/*
 * This class takes each line from the FileProcessor class and 
 * sends it to the appropriate function in context class which 
 * then sends it to the appropriate state.
 */

public class helper {
	
	public void accessInput(String s)
	{
		String f=" ";
		FileProcessor fp=new FileProcessor();
		try 
		{
			StreetLightsContext slc= new StreetLightsContext();
			
			while(( f=fp.readline("input.txt"))!= null)
			{
				if(f.equals("All Lights Red"))
				{
					slc.changeAllToRed();
				}
				else if(f.equals("New Car at North") || f.equals("New Car at East") 
						|| f.equals("New Car at West") || f.equals("New Car at South") )
				{
					slc.addCar();
				}			
				else if(f.equals("East turns Green") || f.equals("West turns Green")
						|| f.equals("North turns Green") || f.equals("South turns Green"))
				{
					slc.changeToGreen();
				}
				else if(f.equals("East turns Red") || f.equals("West turns Red")
						|| f.equals("North turns Red") ||f.equals("South turns Red"))
				{
					slc.changeToRed();
				}
			}

			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

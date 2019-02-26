package fourWayStreetLights.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* This class has method readLine() which reads each line from the file 
 * and sends it to the helper class which performs the appropriate 
 * action on it by sending it to required state.
 */
public class FileProcessor {
	
	
	int x=1;
	BufferedReader br=null;
    Scanner sc= null;
	public  String readline(String filename) throws IOException
	{
		       
        //Logger.setDebugValue(1);
        
       // Logger.writeMessage("Entering readline in FileProcessore", );
        //List<String> eachLine= new ArrayList<String>();
        String fname=filename;
        try 
        {
   
            if(x==1)
            {
            		sc=new Scanner(new File(fname));
            		x++;
            }
            try
            {
            	if(sc.hasNext()) 
            	{
            		String line;
            		line=sc.nextLine();
            		return line;
            	
            	}           
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
        }
            
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + filename + "'");                
        }
        catch(IOException ex) 
        {
            ex.printStackTrace();
        }
        
        finally
        {
        	br.close();
        }
        return null;
		
    }

}
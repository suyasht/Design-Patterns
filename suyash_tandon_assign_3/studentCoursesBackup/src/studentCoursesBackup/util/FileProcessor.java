package studentCoursesBackup.util;


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
	
	
	boolean x=true;
	BufferedReader br=null;
    Scanner sc= null;
	public  String readline(String filename) throws IOException
	{
		              
        String fname=filename;
        try 
        {        	
            if(x)
            {
            		sc=new Scanner(new File(fname));
            		x=false;
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
        
        
        return null;
		
    }

}

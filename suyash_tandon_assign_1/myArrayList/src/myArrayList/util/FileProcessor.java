package myArrayList.util;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import myArrayList.MyArrayList;

public class FileProcessor {
	
	// Reads each line from the file and sends it to be added to an array
	
	public String readline(String filename) throws IOException
	{
		String line = null;        
        BufferedReader br=null;
        //List<String> eachLine= new ArrayList<String>();
        
        try 
        {
        	MyArrayList mal=new MyArrayList();
        	
            
            FileReader fileReader = new FileReader(filename);
            br = new BufferedReader(fileReader);

            while((line = br.readLine()) != null) 
            {
            	
            	mal.convertToIntandInsert(line);
            	
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
		return "" ;
    }

}

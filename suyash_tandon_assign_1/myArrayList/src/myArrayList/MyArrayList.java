package myArrayList;
import java.io.*;
import java.util.Arrays;

public class MyArrayList {

	private static int[] data;
	static int x=0;
	static int z=0;
    public static int arraySize=50;
	
    //Constructor to initialize array
	public static void MyArrayList()
	{
		data=new int[arraySize];
	}
		// Method to resize array
	static void ArrayResize() throws IOException
	{
		
			arraySize+=(arraySize/2);
			int temp[]=new int[arraySize];		
			for(int x=0;x<data.length;x++)
			{
				temp[x]=data[x];
			}
			MyArrayList();
			for(int x=0;x<temp.length;x++)
			{
				data[x]=temp[x];
			}
			
		
				
	}
	
	// Converts the String received form the file to an integer and passes it for insertion
	
	public void convertToIntandInsert(String s) throws IOException
	{
		
		int x= Integer.parseInt(s);
		MyArrayList.insertSorted(x);
		
	}
	
	//Inserts the items in the array keeping it sorted
	
	public static void insertSorted(int newVal)
	{		
		try
		{					
			if(data.length <= x)
			{
				MyArrayList.ArrayResize();				
			}
			else
			{									
				data[x]=newVal;
				z++;
				for(int z=0;z< x-1; z++)
				{					
					for(int y=0;y< x-z;y++)
					{
						if(data[y]> data[y+1])
						{
							int temp=data[y];
							data[y]=data[y+1];
							data[y+1]=temp;
						}
					}
				}
				//Arrays.sort(data);
				x++;
					
			}
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Removes all occurrences of the element and returns the appropriate output
	
	public String removeValue(int value)
	{
		int y=0;
		int f=0;
		for(int x=0;x<data.length;x++)
		{
			if(data[x] == value)
			{
				data[x]=data[x+1];
				//y++;
				f=1;
				if(((x+1)-data.length)==0)
				{
					data[x]=0;
				}
			}
		}
		if(f==1)
		{
			return "Value Deleted";
		}
		else
		{
			return "Given Value doesn't exist";
		}
	}
	
	//returns the index of the asked element, if present. Else gives an appropriate output
	
	public int indexOf(int value)
	{
		int index=0;
		int flag=0;
		for(int x=0;x<data.length;x++)
		{
			if(data[x]==value)
			{
				index= x;
				flag=0;
				break;
			}
			else
			{
				flag = 1;
			}
		}
		if(flag==1)
		{
			return -1;
		}
		return index;
		
	}
	
	// Returns the size of the array
	
	public static int size()
	{
		return z;
	}
	
	// Returns the sum of all the elements in the array
	
	public int sum()
	{
		int sum=0;
		for(int x=0;x<data.length;x++)
		{
			sum+=data[x];
		}
		return sum;
	}
	// Prints all the elements of the array
	public void printToString()
	{
		for(int x=0;x<data.length;x++)
		{			
			System.out.println("Value at index " +x+ ": "+data[x]);
		}
	}
}

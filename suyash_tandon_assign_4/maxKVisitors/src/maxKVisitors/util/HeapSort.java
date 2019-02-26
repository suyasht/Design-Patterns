package maxKVisitors.util;

import java.util.ArrayList;
import java.util.Vector;

import maxKVisitors.util.MyLogger.debugLevel;

/*
 * Implementation of Heap Sort
 * on ArrayList and VectorList
 */
public class HeapSort
{
	debugLevel heap;
	 public void sort(ArrayList<Integer> ls)
	 {
		 
	     int n = ls.size();
	     for (int i = n / 2 - 1; i >= 0; i--)
	     {
	         heapify(ls, n, i);
	     }
	     for (int i=n-1; i>=0; i--)
	     {      
	         int temp = ls.get(0);
	         ls.set(0, ls.get(i));
	         ls.set(i, temp);
	         heapify(MyArray.intList, i, 0);
	     }
	 }
	
	 void heapify(ArrayList<Integer> ls, int n, int i)
	 {
	     int smallest = i;
	     int l = 2*i + 1;
	     int r = 2*i + 2;
	     
	     if (l < n && ls.get(l) < ls.get(smallest))
	     {
	         smallest = l;
	     }
	     if (r < n && ls.get(r) < ls.get(smallest))
	     {
	         smallest = r;
	     }     
	     if (smallest != i)
	     {
	         int swap = ls.get(i);
	         ls.set(i, ls.get(smallest));
	         ls.set(smallest,swap);         
	         heapify(ls, n, smallest);
	     }
	 }
	 
	 public void sort(Vector<Integer> v)
	 {
		 
	     int n = v.size();
	     for (int i = n / 2 - 1; i >= 0; i--)
	     {
	         heapify(v, n, i);
	     }     
	     for (int i=n-1; i>=0; i--)
	     {
	         int temp = v.get(0);
	         v.set(0, v.get(i));
	         v.set(i, temp);      
	         heapify(v, i, 0);
	     }
	 }
	 void heapify(Vector<Integer> v, int n, int i)
	 {
	     int smallest = i;  
	     int l = 2*i + 1;  
	     int r = 2*i + 2;		    
	     if (l < n && v.get(l) < v.get(smallest))
	     {
	    	 smallest = l;
	     }            
	     if (r < n && v.get(r) < v.get(smallest))
	     {
	         smallest = r;
	     }     
	     if (smallest != i)
	     {
	         int swap = v.get(i);
	         v.set(i, v.get(smallest));
	         v.set(smallest,swap);    
	         heapify(v, n, smallest);
	     }
	 }
}
import java.util.ArrayList;
import java.util.Arrays;

/***********************************************************
 * Lab #8 (CIS 181, Fall 2008)                             *
 * Submitted By: Elijah Ellis
 * Date: March 29th 2017 
 ***********************************************************/

/**
 * @author Haiping Xu
 * Created on Nov. 1, 2008
 */
public class SortedList implements SortedListInterface {
    private static final int MAX_LIST = 50;
    private Object items[];  // an array of list items
    private int numItems;    // number of items in list

    // default constructor
    public SortedList() {
         items = new Object[MAX_LIST];
         numItems = 0;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }


    public int size() {
        return numItems;
    }

    public Object get(int index) throws ListException {

        if (index >= 1 && index <= size()) {
            return items[index-1];
        } else  {  // index out of range
            throw new ListException("get (index out of range): " + index);
        }
    }

    public void removeAll() {
        items = new Object[MAX_LIST];
        numItems = 0;
    }

    // new operations: sortedAdd
    public void sortedAdd(Comparable newItem) throws ListException {

        if (size() == MAX_LIST)
            throw new ListException("add (array is full)");

        /*
        int placementIndex = 0;
        int index = 0;

        for(;index < numItems; ++index) {
        	if(items[index] != null && newItem.compareTo(items[index]) > 0) {
        		placementIndex = index+1;  
        	} else  if(items[index] != null && newItem.compareTo(items[index]) == 0){
        		placementIndex = index;
        	} else {
        		placementIndex = index - 1; 
        	}
        }
        
        // Place it in the array 
        Object[] newArray = new Object[MAX_LIST]; 
        
        for(int i = 0; i <= numItems; ++i) {
           if(i == placementIndex) { 
        	   newArray[i] = newItem; 
        	   ++i; // move i ahead once 
           } else {
        	   newArray[i] = items[i]; 
           }
        }
        
        items = newArray;
        ++numItems;
        */ 

        // Optimization
        if(numItems == 0) {
        	items[0] = newItem; 
        	++numItems; 
        } else { 
        
        	// Find index 
			int selectionIndex = 0;
			
			while(items[selectionIndex] != null && newItem.compareTo(items[selectionIndex]) > 0) {
				selectionIndex++; 
			}
			
			// Append into array 
			Object[] a1 = this.getSub(0, selectionIndex, items);
			Object[] a2 = this.getSub(selectionIndex+1, numItems-1, items);
			
			a1[numItems-1] = newItem;
			
			
			for(int i = 0; i < a1.length; i++) {
				items[i] = a1[i];
			}

			for(int i = a1.length; i < a2.length; i++) {
				items[i] = a2[i];
			}
        }
    }

    // new operation: sortedRemove
    public void sortedRemove(Comparable anItem) throws ListException {
        int index = 1;

        // ToDo

    }

    // new operation: locateIndex
    public int locateIndex(Comparable anItem) {
        int index = 1;

        // ToDo

        return index;
    }
    
    private Object[] getSub(int start, int end, Object[] arr) { 
    	Object[] ret = new Object[end];
    	for(int i = 0;start <= end; ++start, ++i) {
    		ret[i] = arr[start];
    	}
    	return ret;
    }
}
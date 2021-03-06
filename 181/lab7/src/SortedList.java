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
			
			// Split array
			Object[] a1 = this.getSub(0, selectionIndex, items);
			Object[] a2 = this.getSub(selectionIndex, numItems, items);
			
			// Add item to array
			a1[a1.length - 1] = newItem;
			++numItems;
			
			// Reconstruct the array
			for(int i = 0; i < a1.length; i++) {
				items[i] = a1[i];
			}

			for(int i = a1.length, j = 0; i < a2.length; i++ , j++) {
				items[i] = a2[j];
			}
        }
    }

    // new operation: sortedRemove
    public void sortedRemove(Comparable anItem) throws ListException {
        int index = locateIndex(anItem) - 1;
        
        if(index >= numItems)
        	throw new ListException("sortedRemove (item not found): " + anItem);
        
        for(int i = index; i < numItems; i++) {
        	items[i] = items[i+1];
        }

        --numItems;
    }

    // new operation: locateIndex
    public int locateIndex(Comparable anItem) {
    	int selectionIndex = 1;

		while(selectionIndex <= numItems && anItem.compareTo(items[selectionIndex - 1]) != 0) {
			selectionIndex++; 
		}
		return selectionIndex;
    }
    
    private Object[] getSub(int start, int end, Object[] arr) { 
    	Object[] ret = new Object[end+1];
    	for(int i = 0;start < end; ++start, ++i) {
    		ret[i] = arr[start];
    	}
    	return ret;
    }
}
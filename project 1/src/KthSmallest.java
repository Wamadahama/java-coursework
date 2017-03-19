/***********************************************************
 * Project #1 (CIS 181, Fall 2008)                         *
 * Submitted By: Elijah Ellis
 * Date: 3/18/2017
 ***********************************************************/

/*
 * File name: KthSmallest.java
 * @author Haiping Xu
 * Created on 2008-09-27
 */

public class KthSmallest {

    private  static void swap(int[] theArray, int i, int j){
        int temp = theArray[i];
        theArray[i] = theArray[j];
        theArray[j] = temp;
    }

    private static int partition(int[] theArray, int first, int last){
    // Returns the index of the pivot element after partitioning
    // theArray[first..last]

        int p = theArray[first];    // use the first item of the array as the pivot (p)
        int lastS1 = first + 1;         // set S1 and S2 to empty

        int i = lastS1;
        // iterate over the array and arrange it into S1 and S2 sections 
        while(i < last) {
        	if(theArray[i] < p) {
        		// Switch into S1
        		swap(theArray, i, lastS1);
        		lastS1++;
        	}

        	++i;
        }

        if(lastS1 <= last)
        	swap(theArray, first, (lastS1 - 1));

        // ToDo: Determine the regions S1 and S2
        // Refer to the partition algorithm on page 495 of the textbook.
        // Find where the 

        // This is where the pivot belongs 
        return lastS1 - 1;              // the index of the pivot element
    }

    public static int kSmall(int k, int[] anArray, int first, int last){
        int pivotIndex = partition(anArray, first, last);
        int p = anArray[pivotIndex]; // p is the pivot

        if(pivotIndex == (k - 1))
//        	return array[k-1];
        	return p;
        
        if(pivotIndex < (k-1))
        	return kSmall(k, anArray, pivotIndex+1, last);
        
        return kSmall(k, anArray, first, pivotIndex);

    }
}

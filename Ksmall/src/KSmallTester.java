
/***********************************************************
 * Project #1 (CIS 181, Fall 2008)                         *
 * Submitted By: Elijah Ellis
 * Date: 3/18/2017
 ***********************************************************/

/*
 * File name: KSmallTester.java
 * @author Haiping Xu
 * Created on 2008-09-27
 */

import java.util.*;

public class KSmallTester {

    public final static int SIZE_OF_ARRAY = 10;
    public final static String PROMPT = "Please  enter an integer k, 1<=k<=" +
        SIZE_OF_ARRAY + ", or 'R' to refill the array: ";

    public static void printArray(int[] array) {

        System.out.println("");
        System.out.print("array = [");
        for (int i=0; i < SIZE_OF_ARRAY-1; i++)
            System.out.print(""+ array[i]+" | ");
        System.out.println(""+ array[SIZE_OF_ARRAY-1]+"]");
        System.out.println("-------------------------------------------------"
                         + "-------------------");
    }

    public static void randFillArray(int[] array) {
        Random random = new Random();

        for (int i=0; i < SIZE_OF_ARRAY; i++)
            array[i] = random.nextInt(100);
    }

    
    // Used for initial testing of ksmall
    public static void test() {
    	int[] test = {5,8,4,31,7,3,42,51,32,45};
    	printArray(test);
    	
    	int firstSmallest = KthSmallest.kSmall(6, test, 0, 10);
    	
    	System.out.println(firstSmallest);
    }

    public static void main(String argv[]) {

        boolean state = true; // On or off
        
        while(state) {
        	
        	// Read user input 
        	Scanner inputReader = new Scanner(System.in);
        	
        	// Populate an array 
			int k = 1, kthSmallest = 0;
			int[] array = new int[SIZE_OF_ARRAY];


			randFillArray(array);
			printArray(array);

			// Ask the user
        	System.out.println("Enter k for the kth smallest element of the array");
        	
        	
        	// Read and check input 
        	try {
				String userInput = inputReader.nextLine();
				
				if(userInput.toUpperCase().trim().equals("Q")){ 
					break;
				} else if(Integer.parseInt(userInput) > 0) {
					// Output result
					k = Integer.parseInt(userInput);
					System.out.println("k smallest of array = " + KthSmallest.kSmall(k, array, 0, 10));
				} else if(Integer.parseInt(userInput) < 0) {
					System.out.println("Bad Input");
				}

			} catch (Exception e) {
        		System.out.println("Bad Input");
			}
        	
        	
        }
        // Note that your program should allow finding k-th smallest item from an array
        // continuously (i.e., more than once) , refilling the array, and exiting the
        // program when typing in "Q" or "q".

    }
    

}

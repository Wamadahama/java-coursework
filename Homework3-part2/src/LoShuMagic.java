/**
 * @author Elijah Ellis
 * Thursday December 8th 2016
 * LoShuMagic 
 */
public class LoShuMagic {
	// Test method, checks the conditions of a Lo Shu Magic Square 
	public boolean test(int[][] array) {
		
		// Test the array to see if there are any numbers that are greater than 9 
		// Also flatten the array into a temp array so we can easily check if there are
		// unique 1 through 9 

		int[] temp = new int[9];
		int ctr = 0; // counter for the temp population 

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				
				// Populate temp 
				temp[ctr] = array[i][j];
				
				// If there is a value greater than 9 exit 
				if (array[i][j] > 9) {
					return false;
				}
				
				ctr++;
			}
		}
		
		// Determine if the array contains distinct value
		// This can be done by performing a modified selection sort
		// and returning false if there is any equality 
		for (int j = 0; j < temp.length-1; j++) {
			int min = j; // First element is the supposed min 
			
			// Check against the rest of the array 
			for(int i = j+1; i < temp.length; ++i){
				if (temp[min] == temp[i]) { // If there is an equality then there are duplicated i.e 1 and 1 
					return false;
				}
			}
		}
		
		// Get row sum 
		int rowSums = 0;
		for (int i = 0; i < array.length; i++) {
			int row = 0;
			
			for (int j = 0; j < array.length; j++) {
				row += array[i][j];
			}
			
			rowSums += row;
		}	
		
		int colSums = 0; 
		
		for(int i = 0; i < array.length; i++) {
			
		}
	}
}

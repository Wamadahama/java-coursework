/**
 * @author Elijah Ellis
 * Thursday December 8th 2016
 * LoShuMagic 
 */
public class LoShuMagic {
	// Test method, checks the conditions of a Lo Shu Magic Square 
	public boolean test(int[][] array) {
		
		// LoShu Magic Square CONDITON 1 
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
		// This can be done by performing a modified standard selection sort
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
			
		
		// LoShu Magic Square CONDITION 2 
		
		int sum = array[0][0] + array[0][1] + array[0][2]; // Get a sum so we can do comparisons 
		
		
		// Sum up each row 
		int rowSum = 0;
		for (int i = 0; i < array[0].length; i++) {
			
			for (int j = 0; j < array[i].length; j++) { 
				 rowSum += array[i][j]; 
			}
			
			if(rowSum != sum) {
				System.out.println("Row: " + rowSum);
				return false;
			}

			// We are moving to the next item so reset the sum
			rowSum = 0;
		}
		
		// The reason that we can do this is because the array is square ( 3 x 3 )
		// Sum diagonally, in this case we are going to have two statements becuase
		// There are two diagonals (3 x 3) so there will be two iterators 
		int diagSum = 0;
		for (int i = 0; i < array[0].length; i++) {
			
			diagSum += array[i][i];
			
		}

		// Test to see if it is valid 
		if(diagSum != sum) {
			System.out.println("Diag1: " + diagSum);
			return false; 
		}
		
		diagSum = 0; // reset 

		// Sum the other diagonal 
		// This will walk backwards effectively 
		for (int i = array[0].length-1; i >= 0; i--){

			diagSum += array[i][i]; // Starts at the right position in the 3 x 3 matrix and moves back (--i)
			
		}
		
		
		// Test to see if it is valid 
		if(diagSum != sum){
			System.out.println("Diag 2"+ diagSum);
			return false;
		}

		// Sum up by column 
		int colSum = 0;
		for (int i = 0; i < array[0].length; i++) {

			for (int j = 0; j < array[i].length; j++) {
				colSum += array[j][0]; // Since we are only getting the first element we can put a zero here 
			}
			
			// Test to see if it is valid 
			if(colSum != sum){
				System.out.println("Col:" + colSum);
				return false;
			}
			
			// We are moving to the next item so reset the sum
			colSum = 0;

		}
		
		// Return true because it is valid if false hasnt been returned yet
		return true;
		
	}
}

/**
 * Name: Elijah Ellis
 * Date: Wednesday October 26, 2016
 * Description: Running total 
 * */
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// Instantiate running total 
		RunningTotal runningTotal = new RunningTotal();
		
		// First initialize based of the info stored in results.txt 
		// Read order: Sum, Product, Total Numbers entered 
		/*try {
			Scanner inputReader = new Scanner(new File("results.txt"));
			
			// Initialize runningTotal
			runningTotal.setSum(inputReader.nextDouble());
			runningTotal.setProduct(inputReader.nextDouble());
			runningTotal.setAverage(inputReader.nextDouble());
			runningTotal.setTotalNumbers(inputReader.nextInt());
			
			inputReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		
		
		// Now perform operations based on whats in numbers.txt 

		Scanner inputReader;
		try {
			
			// Set up reader 
			inputReader = new Scanner(new File("numbers.txt"));
			
			// Iterate through file 
			while(inputReader.hasNext()) {
				// See addNumber method 
				double value = inputReader.nextDouble();
				
				if(value >= 0) { 
					runningTotal.addNumber(value);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		// Update information contained in results 
		try {
			// Initialize the writing operation 
			FileWriter fw = new FileWriter("results.txt", true);
			PrintWriter fileWriter = new PrintWriter(fw);
			
			fileWriter.println(runningTotal.getSum());
			fileWriter.println(runningTotal.getProduct());
			fileWriter.println(runningTotal.getAverage());
			fileWriter.println(runningTotal.getTotalNumbersEntered());
			
			fileWriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}

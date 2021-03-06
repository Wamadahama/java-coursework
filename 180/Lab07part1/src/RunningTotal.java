/**
 * Name: Elijah Ellis
 * Date: Wednesday October 26, 2016
 * Description: Running total 
 * */

import java.util.*;

public class RunningTotal {
	
	private double product = 1;
	private double sum = 0;
	private int totalNumbersEntered = 0; 
	
	public RunningTotal() {
		
	}
	
	/** This method will use a while loop to  continuously
	 ask the user for positive numbers.  
	.*/
	public void getNumbersFromUser() {
		
		// Initialize the scanner for getting user input
		Scanner inputReader = new Scanner(System.in);
		
		
		// Perform a priming read of the users input 
		System.out.println("Please enter a positive number (Negative to cancel)");
		double userInput = inputReader.nextDouble();
		
		// Continually add this to the product, sum , and total numbers entered 
		while(userInput >= 0){ 	
			
			// Perform the accumulation operations 
			this.product *= userInput;
			this.sum += userInput;
			this.totalNumbersEntered++;
			
			// Get a new number, we can assign it to userInput because its up a scope 
			System.out.println("Please enter a positive number (Negative to cancel)");
			userInput = inputReader.nextDouble();
		}
	}
	
	/**
	 * Return the average associated with this object */
	public double getAverage() {
		return (this.sum / (double)this.totalNumbersEntered );
	}
	
	/**
	 * Return the product associated with this object */
	public double getProduct() {
		return this.product; 
	}
	
	/**
	 * Return the sum associated with this object.
	 * */
	public double getSum() {
		return this.sum;
	}
	
	public void printState() {
		System.out.println("Sum: " + this.sum);
		System.out.println("Product: " + this.product);
		System.out.println("Total numbers entered " + this.totalNumbersEntered);
	}
}

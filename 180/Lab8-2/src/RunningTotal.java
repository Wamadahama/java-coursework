/**
 * Name: Elijah Ellis
 * Date: Wednesday October 26, 2016
 * Description: Running total 
 * */

import java.util.*;

public class RunningTotal {
	
	private double product = 1;
	private double sum = 0;
	private double average = 0;
	private int totalNumbersEntered = 0; 
	
	public RunningTotal() {
		
	}
	
	/**
	 * Performs the getNumbers from users operations only once.
	 * */
	public void addNumber(double input) {
		this.product *= input;
		this.sum += input;
		this.totalNumbersEntered++;
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
		this.average = (this.sum / (double)this.totalNumbersEntered); 
		return this.average;
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
	
	/**
	 * Get total numbers 
	 */
	public int getTotalNumbersEntered() { 
		return this.totalNumbersEntered;
	}
	
	/**
	 * Prints out object properties 
	 * */
	public void printState() {
		System.out.println("Sum: " + this.sum);
		System.out.println("Product: " + this.product);
		System.out.println("Total numbers entered " + this.totalNumbersEntered);
	}
	
	
	/**
	 * Set the value of product 
	 * */
	public void setProduct(double product) {
		this.product = product;
	}
	
	/**
	 * Set the value of sum
	 * @param sum
	 */
	
	public void setSum(double sum) {
		this.sum = sum;
	}
	
	/**
	 * Set the total numbers entered 
	 * */
	public void setTotalNumbers(int total){
		this.totalNumbersEntered = total;
	}
	
	public void setAverage(double avg) {
		this.average = avg;
	}
}

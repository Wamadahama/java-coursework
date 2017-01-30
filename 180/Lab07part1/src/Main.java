/**
 * Name: Elijah Ellis
 * Date: Wednesday October 26, 2016
 * Description: Running total 
 * */
public class Main {

	public static void main(String[] args) {
		// Instantiate running total 
		RunningTotal runningTotal = new RunningTotal();
		
		// Call get numbers from users 
		runningTotal.getNumbersFromUser();
	
		// Print out the information stored in the class.
		System.out.println("Sum: " + runningTotal.getSum());
		System.out.println("Product: " + runningTotal.getProduct());
		System.out.println("Average: " + runningTotal.getAverage());
	}

}

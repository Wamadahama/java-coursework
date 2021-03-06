package lab3;

import java.util.*;
public class AckerApp {
	public static void main(String args[]){
		int m = 0,n = 0;
		
		Scanner inputReader = new Scanner(System.in);
		
		// Prompt for input
		System.out.println("Input Two integers separated by a space character (enter \"q\" to quit)");
		
		// Get m and n
		try {
			m = inputReader.nextInt();
			n = inputReader.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
		
		AckerFunction ak = new AckerFunction();
		
		int result = ak.acker(m, n);
		
		System.out.println("Total Number of invocations = " + ak.countOfInvocations() + " result = " + result);
		
		inputReader.close();
		
	}
}

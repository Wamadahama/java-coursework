/**
 * Name: Elijah Ellis
 * Date: Wednesday October 26, 2016
 * Description: Convert a while loop to a do loop
 * */
public class DoWhileConversion {

	public static void main(String[] args) {
		int loopVariable = 0;
		
		// Execute this 
		do {
			System.out.println("Loop iteration # " + loopVariable);
			loopVariable++;
		} while (loopVariable < 50); // As long as this evaluates to true `
	}

}

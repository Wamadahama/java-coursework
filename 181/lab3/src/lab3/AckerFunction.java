package lab3;

public class AckerFunction {
	private int spaces = 0;
	private int numberOfInvocations = 0;
	
	// getter for data field "numberOfInvocations"
	public int countOfInvocations() {
		return numberOfInvocations;
	}
	
	public int acker(int m, int n) {
		
		++numberOfInvocations;
		++spaces;

		printSpaces();
		System.out.print("Enter Method Acker: m = " + m + " n = " + n + "\n");

		int result = 0;
		
		
		if(m == 0)
			result = n+=1;
		else if(n == 0) {
			result = acker(m-1, 1);
		} else {
			result = acker(m-1, acker(m,n-1));
		}
		
		printSpaces(); 
		System.out.print("Leave Method Acker: m = " + m + " n = " + n + "\n");
		
		this.spaces -= 1;
		
		return result;
	}
	
	private void printSpaces() {
		for(int i = 0; i < spaces; i++)
			System.out.print("	");
	}
}

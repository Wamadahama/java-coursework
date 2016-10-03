/*
 * Name: Elijah Ellis
 * Date: 9/18/16
 * Description: 
 * Calculates the gross pay based off of a defined hour count and pay rate
 */
public class Payroll {

	public static void main(String[] args) {
		int hours = 40;
		double grossPay, payRate = 25.0;
		
		grossPay = hours * payRate;
		
		System.out.println("Your gross pay is $" + grossPay);
	}

}

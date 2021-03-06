/**
 * Name: Elijah Ellis
 * Date: Wednesday November 16, 2016
 * Description: Convert a passed in integer to a different numerical type
 * */

public class IntegerConverter {
	public static String toHex(int number)
	{
		String total = "";

		//If the number is negative, make it positive
		if(number<0)
		{
			number = number*-1;
		}

		do{
			int value = number % 16;
			//If the value of 'value' is greater than 9, assign the appropriate letter
			switch(value)
			{
			case 10:
				total+="A";
				break;
			case 11:
				total+="B";
				break;
			case 12:
				total+="C";
				break;
			case 13:
				total+="D";
				break;
			case 14:
				total+="E";
				break;
			case 15:
				total+="F";
				break;
			default:
				total+=value;

			}

			//divide out 16 and repeat
			number=number/16;
		}
		while(number!=0);

		//reverse the string
		total = (new StringBuilder(total)).reverse().toString();
		return total;
	}

	public static String toBinary(int number)
	{
		String total = "";

		do {
			// Divide by two
			int value = number % 2;

			if (value == 1) {
				total += "1";
			} else { // Its 0
				total += "0";
			}

			number = number / 2;
		} while(number > 0);

		return (new StringBuilder(total).reverse().toString());
	}

	public static String toRomanNumeral(int number)
	{
		/*
		 * I = 1
		 * IV = 4
		 * V = 5
		 * IX = 9
		 * X = 10
		 * XL = 40
		 * L = 50
		 * XC = 90
		 * C = 100
		 * CD = 400
		 * D = 500
		 * CM = 900
		 * M = 1000
		 *
		 * Rules
		 * the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively
		 * X can be placed before L and C to make 40 (XL) and 90 (XC) respectively
		 * C can be placed before D and M to make 400 (CD) and 900 (CM) according to the same pattern
		 *
		 *
		 */
		String total = "";

		// Start from the bottom of the list and append the roman numeral equivalent if needed. If not then
		// continue iteration.
		do {
			if (number - 1000 >= 0) {
				total += "M";
				number -= 1000;
			} else if (number - 900 >= 0) {
				total +=  "CM";
				number -= 900;
			} else if (number - 500 >= 0) {
				total += "D";
				number -= 500;
			} else if (number - 400 >= 0) {
				total += "CD";
				number -= 400;
			} else if (number - 100 >= 0) {
				total += "C";
				number -= 100;
			} else if (number - 90 >= 0) {
				total += "XC";
				number -= 90;
			} else if (number - 50 >= 0) {
				total += "L";
				number -= 50;
			} else if (number - 40 >= 0) {
				total += "XL";
				number -= 40;
			} else if (number - 10 >= 0) {
				total += "X";
				number -= 10;
			} else if (number - 9 >= 0) {
				total += "IX";
				number -= 9;
			} else if (number - 5 >= 0) {
				total += "V";
				number -= 5;
			} else if (number - 4 >= 0) {
				total += "IV";
				number -= 4;
			} else if (number - 1 >= 0) {
				total += "I";
				number -= 1;
			}
		} while (number != 0);

		return total;
	}

}

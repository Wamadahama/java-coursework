/*
 * Name: Elijah Ellis
 * Date: Thursday October 2016
 * Description: Generates ASCII art based off the user input
 * */
import java.util.*;

public class ASCIIArt {
	public static void main(String[] args) {

		// Initialize the scanner needed for user input
		Scanner inputReader = new Scanner(System.in);

		// ask the user for a character
		System.out.println("Please enter a character for ascii art");
		System.out.println("Valid characters: i,u, ^, +, and |");
		char userInput = inputReader.nextLine().toCharArray()[0];

		// Based off of the user input, print out the ascii representation of that input 
		switch (userInput) {
			case 'i':
				System.out.println("      ****");
				System.out.println("      ****");
				System.out.println("");
				System.out.println("      ****");
				System.out.println("      ****");
				System.out.println("      ****");
				System.out.println("      ****");
				System.out.println("      ****");
				System.out.println("      ****");
				System.out.println("      ****");
				break;
			case 'u':
				System.out.println("****         ****");
				System.out.println("****         ****");
				System.out.println("****         ****");
				System.out.println("****         ****");
				System.out.println("****         ****");
				System.out.println("****         ****");
				System.out.println("****         ****");
				System.out.println(" ***         ***  ");
				System.out.println("    *********    ");
				System.out.println("      *****      ");
				break;
			case '^':
				System.out.println("     *  ");
				System.out.println("    * *");
				System.out.println("  *    *");
				System.out.println(" *      *");
				System.out.println("*        *");
				System.out.println("");
				break;
			case '+':
				System.out.println("     ****");
				System.out.println("     ****");
				System.out.println("***************");
				System.out.println("***************");
				System.out.println("     ****");
				System.out.println("     ****");
				break;
			case '|':
				System.out.println("****");
				System.out.println("****");
				System.out.println("****");
				System.out.println("****");
				System.out.println("****");
				System.out.println("****");
				System.out.println("****");
				System.out.println("****");
				System.out.println("****");
				System.out.println("****");
				System.out.println("****");
				System.out.println("****");
				System.out.println("****");
				System.out.println("****");
				break;
			default:
				System.out.println("Please enter a valid character");
				break;
		}

	}
}

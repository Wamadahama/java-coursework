/*
* Name: Elijah Ellis
* Date: 9/28/16
* Description: A tool that will on a given input amount of people, will
* calculate number of hot dog and bun packages that need to be purchases
* with the minimum amount of left overs.
*/

import java.util.*;

public class HotDogCalculator {
	public static void main(String[] args) {

		// Get the following inputs needed for calculation
		// 1. How many people are attending the cookout
		// 2. How many hot dogs each person will be given

		// Initialize scanner needed for reading user input
		Scanner InputReader = new Scanner(System.in);

		// Get input from the user
		System.out.println("How many people are attending the cookout?");
		int attendanceCount = InputReader.nextInt();

		System.out.println("How many hot dogs will each person get?");
		int hotDogsEach = InputReader.nextInt();

		// Determine how many hot dogs that are needed
		int hotDogCount = (attendanceCount * hotDogsEach);

		// Calculate the amount of hot dog packages that are needed
		int bunPackageCount = hotDogCount / 8;
		int hotDogPackageCount = hotDogCount / 10;

		int bunRemainder = hotDogCount % 8;
		int hotDogRemainder = hotDogCount % 10;

		// If there is a remainder then add one more bun package so there is enough
		if (bunRemainder > 0) {
			bunPackageCount++;
		}

		// If there is a remainder then add one more hot dog package so there are enough hot dogs
		if (hotDogRemainder > 0) {
			hotDogPackageCount++;
		}


		// Now that we have computed the needed information, print out this information to the user
		// - The minimum number of package of hot dogs required
		// - The minimum number of packages of buns required
		// - The number of hot dogs that will be left over
		// - The number of buns that will be left over

		System.out.println("The minimum number of packages of hot dogs required: " + hotDogPackageCount);
		System.out.println("The minimum number of packages of of buns required: " + bunPackageCount);
		System.out.println("The remaining hot dogs: " + hotDogRemainder);
		System.out.println("The number of buns that will be left over: " + bunRemainder);

	}
}

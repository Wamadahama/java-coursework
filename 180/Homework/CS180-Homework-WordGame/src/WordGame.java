/*
* Name: Elijah Ellis
* Date: 9/26/2016
* Description: 'Madlib': Asks the users for inputs and uses that to generate a
* story
*/

import java.util.Scanner;

public class WordGame {

	public static void main(String[] args) {

		// Initialize the scanner object that is used for reading user input
		Scanner InputReader = new Scanner(System.in);

		// Initialize the variables  that will be uses for the mad lib
		String Name, Age, City, College, Profession, FavoriteAnimal, PetName;

		// Read the input from the user
		System.out.println("Enter a name: ");
		Name = InputReader.nextLine();

		System.out.println("What is your age: ");
		Age = InputReader.nextLine();

		System.out.println("What city are you from: ");
		City = InputReader.nextLine();

		System.out.println("What College do you go to: ");
		College = InputReader.nextLine();

		System.out.println("What is your profession: ");
		Profession = InputReader.nextLine();

		System.out.println("What is your favorite kind of animal (non plural): ");
		FavoriteAnimal = InputReader.nextLine();

		System.out.println("What is your pets name: ");
		PetName = InputReader.nextLine();

		// Concatenate the variables into the strings and then print them out as a story
		System.out.println("--------------- Story 1 ---------------");
		System.out.println("There once was a person named " + Name + " who lived in a " + City);
		System.out.print("At the age of " + Age + ", " + Name + " went to ");
		System.out.println("college at " + College + ". " + Name + " graduated and went to work as a");
		System.out.print(Profession + ". Then " + Name);
		System.out.println("Adopted a(n) " + FavoriteAnimal + " named " + PetName + ". They both lived happily ever after!");

		System.out.println("--------------- Story 2  ---------------");
		System.out.println(Name + " an " + Age + " year old resident of " + City + " and a lover of " + FavoriteAnimal + "s");
		System.out.println("after the loss of his favorite pet: " + PetName + " " + Name + " was never the same. He decided to make something of his life and enrolled at " + College + ".");
		System.out.println("After graduation " + Name + " went to work as a " + Profession);
	}

}

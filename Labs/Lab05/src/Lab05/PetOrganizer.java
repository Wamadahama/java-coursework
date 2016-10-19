/***
 * Name: Elijah Ellis
 * Date: Wednesday 12 2016
 * Description: Tracks a pets stores pets and their properties
 */
package Lab05;
import java.util.*;

public class PetOrganizer {

	public static void main(String[] args) {

		// Instantiate a pet object
		Pet p1 = new Pet();

		// Initialize the scanner used to get the users response
		Scanner inputReader = new Scanner(System.in);

		// Initialize the variables needed to read user input
		String petName,petType,ownerName;
		int petAge;

		System.out.println("Pet 1:");
		// Ask the user for the name, age, type, and owner name
		System.out.println("What is the pets name");
		petName = inputReader.nextLine();

		System.out.println("What is the pets age");
		petAge = inputReader.nextInt();
		inputReader.nextLine(); // Move past the \n

		System.out.println("What is the pets type (Dog, Cat, Mouse, Ferret)");
		petType = inputReader.nextLine();

		System.out.println("What is the owners name");
		ownerName = inputReader.nextLine();

		// Set the properties of the class to the values of the local variables
		p1.setPetName(petName);
		p1.setPetAge(petAge);
		p1.setPetType(petType);
		p1.setPetOwner(ownerName);


		// Reset local variables
		petAge 			= 0;
		petName 		= "";
		petType 		= "";
		ownerName	 	= "";

		// Instantiate a pet object
		Pet p2 = new Pet();


		System.out.println("Pet 2:");

		// Ask the user for the name, age, type, and owner name
		System.out.println("What is the pets name");
		petName = inputReader.nextLine();

		System.out.println("What is the pets age");
		petAge = inputReader.nextInt();
		inputReader.nextLine(); // Move past the \n

		System.out.println("What is the pets type (Dog, Cat, Mouse, Ferret)");
		petType = inputReader.nextLine();

		System.out.println("What is the owners name");
		ownerName = inputReader.nextLine();

		// Set the properties of the class to the values of the local variables
		p2.setPetName(petName);
		p2.setPetAge(petAge);
		p2.setPetType(petType);
		p2.setPetOwner(ownerName);

		// Reset local variables
		petAge 			= 0;
		petName 		= "";
		petType 		= "";
		ownerName	 	= "";

		// Instantiate a pet object
		Pet p3 = new Pet();


		System.out.println("Pet 3:");

		// Ask the user for the name, age, type, and owner name
		System.out.println("What is the pets name");
		petName = inputReader.nextLine();

		System.out.println("What is the pets age");
		petAge = inputReader.nextInt();
		inputReader.nextLine(); // Move past the \n

		System.out.println("What is the pets type (Dog, Cat, Mouse, Ferret)");
		petType = inputReader.nextLine();

		System.out.println("What is the owners name");
		ownerName = inputReader.nextLine();

		// Set the properties of the class to the values of the local variables
		p3.setPetName(petName);
		p3.setPetAge(petAge);
		p3.setPetType(petType);
		p3.setPetOwner(ownerName);

		// Reset local variables
		petAge 			= 0;
		petName 		= "";
		petType 		= "";
		ownerName	 	= "";

		// Print out the pet info
		System.out.println("*********** Pet 1 **************");
		p1.printPetInfo();
		System.out.println("*********************************");

		System.out.println("*********** Pet 2 **************");
		p2.printPetInfo();
		System.out.println("*********************************");

		System.out.println("*********** Pet 3 **************");
		p3.printPetInfo();
		System.out.println("*********************************");

	}

}

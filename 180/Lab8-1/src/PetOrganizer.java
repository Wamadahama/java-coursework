/***
 * Name: Elijah Ellis
 * Date: Thursday November 10 2016
 * Description: Tracks a pets stores pets and their properties
 */

import java.util.*;
import java.io.*;

public class PetOrganizer {

	public static void main(String[] args) {
		// Array to store the pet info 
		Pet pets[] = new Pet[100];
		
		// Initialize the variables needed to read input 
		String petName = "",petType = "",ownerName = "";
		int petAge = 0;
		
		int recordCount = 0;
		

		try {
			// Read from input.txt
			// Read order = Name, petType, ownerName, Age
			
			// Initialize the scanner used to get data from the input file 
			File inputFile = new File("input.txt");
			Scanner inputReader = new Scanner(inputFile);
			
			// Record count is at the top of the file
			recordCount = inputReader.nextInt();
			inputReader.nextLine(); // Push along by one line 
			
			for(int i = 0; i < recordCount; ++i) {

					
				petName = inputReader.nextLine();
				//System.out.println(petName);
					
				petType = inputReader.nextLine();
				//System.out.println(petType);
					
				ownerName = inputReader.nextLine();
				//System.out.println(ownerName);
					
				petAge 	= inputReader.nextInt();
				//System.out.println(petAge);
				
				if (inputReader.hasNext()) {
					inputReader.nextLine(); 
				}
				
				pets[i] = new Pet(petName, petAge, ownerName, petType);
				
			}	
		
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}	
		
		// Write to output file 
		try {
			PrintWriter outputWriter = new PrintWriter("output.txt");
			
			for(int i = 0; i < recordCount; ++i) {
				outputWriter.println("Name: "  + pets[i].getPetName());
				outputWriter.println("Owner: " + pets[i].getPetOwner());
				outputWriter.println("Type: "  + pets[i].getPetType());
				outputWriter.println("Age:  "  + pets[i].getPetAge());
			}
			
			outputWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}

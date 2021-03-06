/**
 * Elijah Ellis 
 * Decemeber 5th 2016
 * Sorting programs 
 * */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class MainClass {

	public static Winner [] listOfWinners;
	public static void loadFromFile()
	{
		try{
			//Create instance of Scanner and provide instance of File pointing to the txt file
			Scanner input = new Scanner(new File("WorldSeriesWinners.txt"));
			
			//Get the number of teams
			int years = input.nextInt();
			input.nextLine();//move to the next line
			
			//Create the array
			listOfWinners = new Winner[years];
			
			//for every year in the textfile
			for(int index = 0; index<years; index++)
			{
				//Get the year
				int year = input.nextInt();
				input.skip("	");
				//Get the team
				String team = input.nextLine();
				
				//Create an instance of Winner and add it to the next spot in the array
				listOfWinners[index] = new Winner(team,year);
			}
		}catch(Exception e)
		{
			System.out.println("Hey Meatbag, I'm Bender, and something wrong in the loadFromFile method happened!");
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	public static void sortByTeamName()
	{		
		// Counters
		int i,j;
		
		// Iterate through the array 
		for(j = 0; j < listOfWinners.length-1; ++j){
			
			// Set the min to the first one 
			int min = j; 
			
			// Look through the rest of the array to see if there is a new min
			for	(i = j+1; i < listOfWinners.length; ++i){
				// Compare to see which of the two strings is greater 
				if (listOfWinners[i].getTeam().compareTo(listOfWinners[min].getTeam()) < 0){
					min = i;	
				}

			}
			
			if (min != j) {
				// Swap the two values 
				Winner temp = listOfWinners[j];
				listOfWinners[j] = listOfWinners[i];
				listOfWinners[i] = temp;
			}
		}	
	}
	
	/**
	 * Sort the array by year 
	 * */
	public static void sortByYear()
	{
		// Counters
		int i,j;
		
		// Iterate through the array 
		for(j = 0; j < listOfWinners.length-1; ++j){
			
			// Set the min to the first one 
			int min = j; 
			
			// Look through the rest of the array to see if there is a new min
			for	(i = j+1; i < listOfWinners.length ;++i){
				
				if (listOfWinners[i].getYear() < listOfWinners[min].getYear()){
					// New min 
					min = i;
				}
			}
			
			if (min != j) {
				// Swap the two values 
				Winner temp = listOfWinners[j];
				listOfWinners[j] = listOfWinners[i];
				listOfWinners[i] = temp;
			}
		}
	}
	
	public static void printArray()
	{
		//Print the array
		for(int index=0; index<listOfWinners.length; index++)
		{
			System.out.println(listOfWinners[index].getYear()+" Winners " + listOfWinners[index].getTeam());
		}
	}
	
	public static void searchForWinnerByYear(int year)
	{
		System.out.println("Winners for the year of " + year);
		
		for (int i = 0; i < listOfWinners.length; i++) {
			
			if(listOfWinners[i].getYear() == year){
				
				System.out.println(listOfWinners[i].getTeam());
				
			}
		
		}
	}
	
	public static void searchForYearsATeamWon(String team)
	{
		System.out.println("Years that the " + team + " have won: ");
		for (int i = 0; i < listOfWinners.length; i++) { // Search the array 
			if(listOfWinners[i].getTeam().compareTo(team) == 0){
				// Print out if that team won this year 
				System.out.println(listOfWinners[i].getYear());
			}
		}
	}
	
	public static void main(String[] args) {
		
		int choice;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("World Series Program");
		
		//Load textfile 
		loadFromFile();
		do{
			System.out.println("1.........Print out the Winner List sorted by team name");
			System.out.println("2.........Print out the Winner List sorted by years");
			System.out.println("3.........Print out the Winner of a particular year");
			System.out.println("4.........Print out the years a particular team won");
			System.out.println("5.........Exit the Program");
			System.out.println("Which Choice Would You Like?");
			choice = keyboard.nextInt();
			
			switch(choice)
			{
			case 1:
				//Option 1, sort array by name and print out.
				sortByTeamName();
				printArray();
				break;
			case 2:
				//Option 2, sort array by year and print out.
				sortByYear();
				printArray();
				break;
			case 3:
				//Option 3 Search for winner by year
				System.out.println("What year would you like to find the winner?");
				int year = keyboard.nextInt();
				searchForWinnerByYear(year);
				break;
			case 4:
				//Option 4 Search for years a team won
				System.out.println("What team would you like to check for years won?");
				keyboard.nextLine();
				String team = keyboard.nextLine();
				searchForYearsATeamWon(team);
				break;
			case 5://Exit
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}while(choice != 5);
		
		System.out.println("Goodbye!");
	}

}

/**
 * Name: Elijah Ellis
 * Date: Monday October 31 2016
 * Description: Item class for Inventory Tracker
 * */
import java.io.*;
import java.util.*;

public class Inventory {

  /**
   * Maintains a collection of the items used by the program
   */
  private Item[] itemArray = new Item[100];

  /**
   * Maintains a count of the items in the program
   */
  private int totalItems = 0;

  /**
   * Returns the total number of items associated with this instance
   */
  public int getTotalNumberOfItems() {
    return totalItems;
  }


  /**
   * Returns an item based on the input index
   */
  public Item getItem(int index) {
    /* If the index doesnt fall within the bounds of
       what is in the array then return null, if it does
       fall within the bounds then return the item
       associated with that index */
    if (index < 0 || index >= totalItems) {
      return null;
    } else {
      return itemArray[index];
    }
  }

  /**
  * Adds an item to the private member
  */
  public void addItem(Item newItem) {
    /*
      If the newItem passed in is null then
       alert the user it wont be added. If it isn't
       then  add it to the end of the array and increment totalItems
    */
    if (newItem == null) {
      System.out.println("Item not added.");
    } else {
      itemArray[totalItems] = newItem;
      ++totalItems;
    }
  }

  public void saveInventoryToFile(String fileName) {
    // Wrap this in a try catch because we are writing to a file
  	try {
  		// Open the file for writing
  		PrintWriter outputWriter = new PrintWriter(fileName);

  		// For each item in the itemArray
  		for (int i = 0; i < itemArray.length; i++) {
  			// Write the properties of the object to a file 
  			outputWriter.println(itemArray[i].getName());
  			outputWriter.println(itemArray[i].getPrice());
  			outputWriter.println(itemArray[i].getQuantity());
  			outputWriter.println(itemArray[i].getUpc());
  			
  			// Append a newline to be used a delimiter when reading 
  			outputWriter.println("");
  		}
  		
  		// Close the output stream 
  		outputWriter.close();
  		
  		// Alert that saving was successful
  		System.out.println("Successfully saved inventory to " + fileName);
  		

  	} catch (Exception e) {
  		System.out.println("An error occured why trying to write to the file");
  	}
  }

  public void loadInventoryFromFile(String fileName) {
	try {
		File inputFile = new File(fileName)
		Scanner inputReader = new Scanner(inputFile);
		
		// Until the end of the file 
		while(inputReader.hasNext()) {
			inputReader.
		}
		
	} catch (Exception e) {
		System.out.println("That file does not exist");
	}
  }

}

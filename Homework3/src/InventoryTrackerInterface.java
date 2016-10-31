/**
 * Name: Elijah Ellis
 * Date: Monday, October 31, 2016
 * Description: Inventory for the tracker
 * */
public class InventoryTrackerInterface {

	public static void main(String[] args) {
		// Test to see if the item class retains data

		Item itemTest = new Item("Foo", 10, 200.00, "Bar");

		System.out.println("Name: " 	+ itemTest.getName());
		System.out.println("Quantity: " + itemTest.getQuantity());
		System.out.println("UPC: " 		+ itemTest.getUpc());
		System.out.println("Price: " 	+ itemTest.getPrice());

		// Test out the Inventory.java get total number of items
		Inventory inventoryTest = new Inventory();

		System.out.println("Total items: " + inventoryTest.getTotalNumberOfItems());

		// Test out the add/get item

		Inventory inventoryTest2  = new Inventory();

		inventoryTest2.addItem(new Item("Bazz", 20, 350.00, "Foo"));
		Item testItem = inventoryTest2.getItem(0);

		System.out.println("Name: " 		+ testItem.getName());
		System.out.println("Quantity: " + testItem.getQuantity());
		System.out.println("UPC: " 		  + testItem.getUpc());
		System.out.println("Price: " 	  + testItem.getPrice());

		System.out.println("Total items: " + inventoryTest2.getTotalNumberOfItems());
	}

}

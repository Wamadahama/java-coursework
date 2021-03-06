/**
 * Name: Elijah Ellis 
 * Date: Monday October 31 2016
 * Description: Item class for Inventory Tracker 
 * */
public class Item {
	
	/* Private members */
	private String name;
	private int quantity;
	private double price;
	private String upc;
	
	/* Default Constructor */
	public Item() {
		
	}
	
	/* Overloaded Constructor */
	public Item(String name, int qty, double price, String upc){
		this.name = name; 
		this.quantity = qty;
		this.price = price;
		this.upc = upc;
	}
	
	/* Getter methods */ 
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public String getUpc() {
		return upc;
	}
}

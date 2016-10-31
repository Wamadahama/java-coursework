/*
 * Name: Elijah Ellis
 * Date: Wednesday October 19, 2016
 * Description: box class for lab06
 * */
package lab06;

public class Box {
	
	//private class attributes
	private double width;
	private double length;
	private double height;
	private String label;
	
	//private constructors
	private Box()
	{
		//By having a private constructor, outside users can not create an instance
		//with a default constructor :-D
	}
	
	public Box(double w, double l, double h,String name)
	{
		//Fill in code to copy w, l, h, name to width, length, height, label respectively
		this.width  = w;
		this.length = l;
		this.height = h;
		this.label  = name;
	}
	
	public Box(Box cloneMe)
	{
		// If the clone is none existent then stop 
		if(cloneMe == null) 
			return;
		
		//Copy the attributes of cloneMe to this classes instance
		this.width  = cloneMe.getWidth();
		this.length = cloneMe.getLength();
		this.height = cloneMe.getHeight();
		this.label  = cloneMe.getLabel() + " Clone";
	}
	
	/**
	 * Calculates the volume of the cube
	 * */
	public double getVolume() {
		return (length * width * height);
	}
	

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	public double getHeight() {
		return height;
	}

	public String getLabel() {
		return label;
	}
	

}

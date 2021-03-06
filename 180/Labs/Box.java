package lab6;

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
	}
	
	public Box(Box cloneMe)
	{
		//Copy the attributes of cloneMe to this classes instance
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

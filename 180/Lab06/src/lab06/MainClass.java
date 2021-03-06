/*
 * Name: Elijah Ellis
 * Date: Wednesday October 19, 2016
 * Description: implementation of the box class for lab06
 * */
package lab06;

public class MainClass {

	public static void main(String[] args) {
		//Do not change any code in this class!
		Box b1 = new Box(7,8,9, "Box 1");
		Box b2 = new Box(7,7,7, "Box 2");
		Box b3 = new Box(b1);
		
		System.out.println("Box " + b1.getLabel() + " Stats:");
		System.out.println("Width = " + b1.getWidth());
		System.out.println("Length = " + b1.getLength());
		System.out.println("Height = " + b1.getHeight());
		//System.out.println("Area = " + b1.getArea());
		System.out.println("Volume = " + b1.getVolume());
		
		System.out.println("Box " + b2.getLabel() + " Stats:");
		System.out.println("Width = " + b2.getWidth());
		System.out.println("Length = " + b2.getLength());
		System.out.println("Height = " + b2.getHeight());
		//System.out.println("Area = " + b2.getArea());
		System.out.println("Volume = " + b2.getVolume());
		
		System.out.println("Box " + b3.getLabel() + " Stats:");
		System.out.println("Width = " + b3.getWidth());
		System.out.println("Length = " + b3.getLength());
		System.out.println("Height = " + b3.getHeight());
		//System.out.println("Area = " + b3.getArea());
		System.out.println("Volume = " + b3.getVolume());

	}

}

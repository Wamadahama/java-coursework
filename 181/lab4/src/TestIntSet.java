/***********************************************************
 * Lab #4 (CIS 181)                             *
 * Submitted By: Elijah Ellis
 * Date: 3/6/2017
 ***********************************************************/

public class TestIntSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] s = {2, 5, 11, 19};
		IntSet is = new IntSet(s);

		// Test cases
		System.out.println("Befroe insertion: " + is.toString());
		is.insert(34);
		System.out.println("After insertion: " + is.toString());

		System.out.println("\nBefroe insertion: " + is.toString());
		is.insert(-88);
		System.out.println("After insertion: " + is.toString());
		
		
		// Test cases

		IntSet s1 = new IntSet(new int[] {1, 2});
		IntSet s2 = new IntSet(new int[] {2, 3});
		
		// Test union
		System.out.println("Test union S1 U S2 ");
		System.out.println(s1.union(s2).toString());
		
		// Test Removal 
		IntSet s3 = new IntSet(new int[] {2, 3});

		System.out.println("Test removal of 2 from S3 {2 ,3}");
		s3.remove(2);
		System.out.println(s3.toString());

		
		// Test intersection
		System.out.println("Test intersection S1 ^ S2 ");
		System.out.println(s1.intersection(s2).toString());

		// Test complement
		System.out.println("Test complement S1 ");
		System.out.println(s1.complement().toString());
		
	}
}

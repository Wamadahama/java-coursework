/**
 * Name: Elijah Ellis
 * Date: Wednesday November 16, 2016
 * Description: Convert a passed in integer to a different numerical type
 * */
public class Main {
  public static void main(String args[]) {
	  String output = IntegerConverter.toBinary(2592);
	  System.out.println(output);
	  
	  output = IntegerConverter.toRomanNumeral(2592);
	  System.out.println(output);
	  
	  output = IntegerConverter.toHex(2592);
	  System.out.println(output);
  }
}

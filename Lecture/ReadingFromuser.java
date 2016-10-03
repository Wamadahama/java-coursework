import java.util.Scanner;

public class ReadingFromuser {
	public static void main(String[] Args){ 
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your favorite color?");
		
		String color;
		color = input.nextLine();
		
		System.out.println("How old are you (whole numbers only, no text)"?);
		int age = input.nextInt();
	}
}

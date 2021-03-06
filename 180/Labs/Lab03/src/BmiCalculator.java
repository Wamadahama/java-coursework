/*
* Name: Elijah Ellis
* Date: Thursday 29 2016
* Description: Calculate the body mass index by asking the users for their weights and heights anbd then using the BMI formula to calculate it.
* If they have a healthy BMI then tell them this, if theirs is unhealthy then reccomend that they see a doctor.
*/
// 6. Instead of using .nextDouble(); on the Scanner, instead use the .nextInt(); to read an integer. But the variables should also be of type int.
import java.util.*;

public class BmiCalculator {
  public static void main(String[] args) {
    // Calculate BMI with the following formula:
    // BMI = ( Weight in Pounds / ( Height in inches x Height in inches ) ) x 703

    // Create variables named weight and height because we will be populating
    // information from the user needed to calculate BMI.
    double weight;
    double height;

    // Instantiate a scanner object that will read input from the user.
    Scanner inputReader = new Scanner(System.in);

    // Ask the user for their weight in pounds
    // Store the weight in the weight variable
    System.out.println("Please enter your weight in pounds: ");
    weight = inputReader.nextDouble();

    // Ask the user for their height in inches
    // Store the height in the height variable
    System.out.println("Please enter your height in inches: ");
    height = inputReader.nextDouble();

    // Calculate BMI with the following formula:
    // BMI = ( Weight in Pounds / ( Height in inches x Height in inches ) ) x 703
    // and store the result of the calculation in the new variable bodyMassIndex
    double bodyMassIndex;
    bodyMassIndex = (weight * 708) / (height * height);

    // Print out their body mass index
    System.out.println("Your body mass index is " + bodyMassIndex);

    // If their bmi exceeds 25 then alert them that it is high
    if (bodyMassIndex > 25 ) {
      System.out.println("Your body mass index is exceedingly high, please consider seeing a doctor");
    } else if (bodyMassIndex < 18.5) {     // If their bmi is below 18.5 then alert them that it is low
      System.out.println("Your body mass index is exceedingly low, please consider seeing a doctor");
    } else {
      System.out.println("You are healthy!");
    }

  }
}

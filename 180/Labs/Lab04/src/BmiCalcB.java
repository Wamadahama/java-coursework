/*
* Name: Elijah Ellis
* Date: Thursday October 6 2016
* Description: Calculate the body mass index by asking the users for their weights and heights and then using the BMI formula to calculate it.
* If they have a healthy BMI then tell them this, if theirs is unhealthy then reccomend that they see a doctor.
*/
// 6. Instead of using .nextDouble(); on the Scanner, instead use the .nextInt(); to read an integer. But the variables should also be of type int.
import java.util.*;

public class BmiCalcB {
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

    if (bodyMassIndex >= 35) {
      System.out.println("You are very obese, please consider seeing a doctor");
    }
    else if (bodyMassIndex >= 30)  {
      System.out.println("You are obese, please consider seeing a doctor");
    }
    else if (bodyMassIndex >= 25)  {
      System.out.println("You are overweight, please consider seeing a doctor");
    }
    else if (bodyMassIndex >= 18.5)  {
      System.out.println("You have a normal BMI");
    }
    else if (bodyMassIndex >= 16)  {
      System.out.println("You are underweight, please consider seeing a doctor!");
    }
    else if (bodyMassIndex < 16) {
      System.out.println("You are very underweight, please consider seeing a doctor!");
    }
  }
}

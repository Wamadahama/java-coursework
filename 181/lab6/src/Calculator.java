
public class Calculator implements Process {

	SmallInt firstNumber = new SmallInt();
	SmallInt secondNumber = new SmallInt();

	private int offset = 0; 

    protected GUI gui;

    // Postcondition: This Age has been initialized.
    public Calculator() {           // default constructor
         gui = new GUI (this);
         gui.print("Please enter two numbers");
    }
    
	public void processInput(String s) {
		if (offset == 0) {
			
			// Get first number 
			firstNumber.setValue(s);

			++offset;
		} else {
			// Get second number
			secondNumber.setValue(s);
			
			// Addition 
			gui.print("\nAddition\n");
			gui.print(firstNumber.add(secondNumber) + "\n");
			
			
			// Subtraction 
			gui.print("Subtraction\n");
			gui.print(firstNumber.subtract(secondNumber) + "\n");
			
			// Multiplication
			gui.print("Multiplication \n");
			gui.print(firstNumber.multiply(secondNumber) + "\n");
			
			// Division
			gui.print("Divison \n");
			gui.print(firstNumber.divide(secondNumber) + "\n");
			
			// Disable input 
			gui.disableInputBar();
			
		}
	}
	
	public static void main(String[] args) {
		Calculator calc  = new Calculator();
	}
}

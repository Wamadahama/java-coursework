
public class SmallInt {
	
	// value associated with the small int 
	private int value; 

	public void setValue(String s) {
		// Parse passed string 
		int temp = Integer.parseInt(s);
		
		// Check bounds 
		if (this.withinBounds(temp)) {
			this.value = temp;
		} else {
			this.value = 0;
		}
	}
	
	// Returns the value associated with this instance 
	public int getValue() { 
		return this.value;
	}
	
	
	// Add another small int s
	public int add(SmallInt a) { 
		int addedValue = this.value + a.value; 
		
		if(this.withinBounds(addedValue)) {
			return addedValue;
		} else {
			return 0;
		}
	}
	
	
	// Subtract another small int s
	public int subtract(SmallInt a) { 
		int addedValue = this.value - a.value; 
		
		if(this.withinBounds(addedValue)) {
			return addedValue;
		} else {
			return 0;
		}
	}
	
	// Multiply another small int s
	public int multiply(SmallInt a) { 
		int addedValue = this.value * a.value; 
		
		if(this.withinBounds(addedValue)) {
			return addedValue;
		} else {
			return 0;
		}
	}
	// Divide another small int s
	public int divide(SmallInt a) { 
		int addedValue = this.value / a.value; 
		
		if(this.withinBounds(addedValue)) {
			return addedValue;
		} else {
			return 0;
		}
	}

	// DRY
	private boolean withinBounds(int n) {
		if (n <= Integer.MAX_VALUE && n >= Integer.MIN_VALUE) 
			return true;
		return false;
	}
}

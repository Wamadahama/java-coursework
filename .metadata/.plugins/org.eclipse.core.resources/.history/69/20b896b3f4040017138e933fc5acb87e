/***********************************************************
 * Lab #4 (CIS 181)                             *
 * Submitted By:  Elijah Ellis                      *
 * SID:  01646005                   *
 * Date: 3/1/17                              *
 ***********************************************************/

/**
 * Created on Sept. 24, 2006
 * Provides for creating and manipulating sets of non-negative integers.
 * The set can contain non-negative integers (0...) with values from min...max.
 *
 */

public class IntSet {

    //Attributes
    private final int min = 0, max = 100;
    private boolean[] contents = new boolean[101];
    private int cardinality = 0; //maintains the number of elements in the set

    //Constructors

    //Postcondition: Creates an empty set, cardinality()==0 and
    // for all i, such that min<=i<=max, contents[i]==false
    public IntSet(){
    }

    //Precondition: every element of values has the property min<=element<=max
    //Postcondition: For all x in values, such that min<=x<=max, contents[x]==true.
    public IntSet(int[] values){
	    for (int i = 0; i < values.length; i++) {
		    if (values[i] <= max && values[i] >= min ) {
			    this.contents[values[i]] = true;
			    this.cardinality++;
		    }
	    }
    }

    //Set Methods

    /**
     * Precondtion: null
     * Postcondition: return this.cardinality==0
     */
    public boolean isEmpty(){
	    return this.cardinality == 0;
    }

    /**
     * Precondition: null
     * Postcondition: return this.cardinality
     */
    public int cardinality(){
         return this.cardinality;
    }

    /**
     * Precondition: min<=element<=max
     * Postcondition: return this.contents[element]
     */
    public boolean isElement(int element){
	    if (element >= min && element <= max) {
		    return this.contents[element];
	    } else {
		    return false;
	    }
    }

    /**
     * Precondition: min<=element<=max and !isElement(element)
     * Postcondition: this.contents[element] = true.  returns true if successful,
     *                false otherwise
     *
     */
    public boolean insert(int element){

	    if ((element <= max && element >= min) && !this.isElement(element)) {
		    this.contents[element] = true;
		    this.cardinality++;
		    return true;
	    } else {
	    	System.out.println("Precondition is NOT satisfied: element = " + element);
		    return false;
	    }
    }

    /**
     * Precondition: min<=element<=max and isElement(element)
     * Postcondition: this.contents[element] = false. returns true if successful,
     *                false otherwise
     *
     */
    public boolean remove(int element){
    	if((element >= min && element <= max) && isElement(element)) {
    		this.contents[element] = false; 
    	} else {
    		return false;
    	}
    	
    	return true;
    }

    //Operations

    /**
     * Precondition: s is an IntSet object.
     * Postcondition: returns a new set that is the union of this set and set s
     */
    public IntSet union(IntSet s){

    	// Create new set 
    	IntSet newSet = new IntSet();
    	
    	// If its not null
    	if(s != null) {

    		// Add all the trues and false from s
    		for(int i = 0; i < s.contents.length; ++i) {
    			if(this.contents[i] == true || s.contents[i] == true) {
    				newSet.contents[i] = true;
    			}
    		}
    	}

    	return newSet;
    }

    /**
     * Precondition: s is an IntSet object.
     * Postcondition: returns a new set that is the intersection of this set and set s
     */
    public IntSet intersection(IntSet s){
    	IntSet newSet = new IntSet();
    	
    	// if s in an IntSet object 
    	if(s != null) {
    		for(int i = 0; i < this.contents.length; ++i) {
    			if(s.contents[i] == this.contents[i]) {
    				newSet.contents[i] = s.contents[i];
    			}
    		}
    	}

    	return newSet;
    }

    /**
     * Precondition: null
     * Postcondition: produces a new set representing those elements that are in the
     *            universal set but not in this set, this set is unchanged.
     */
    public IntSet complement(){
    	IntSet newSet = new IntSet();
    	
    	for(int i = 0; i < this.contents.length; i++){
    		if(this.contents[i] == false) {
    			newSet.contents[i] = true;
    		} else {
    			newSet.contents[i] = false;
    		}
    	}

    	return newSet;
    }

    //Utilities

    /**
     * Postcondition: returns a String representation of the calling Set. The
     *  representation is {int, int, int} beginning with the smallest value
     *  in the set to the largest from left to right.
     */
    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append("{");

        for (int i = 0; i <= max; i++) {
      	    if (this.contents[i]) {
      	 	    s.append(i + ", ");
      	    }
        }

        //remove the last "," and white space from the end of the stringbuffer
        if (s.length() > 1) {
      	    s.delete(s.length()-2, s.length());
        }
        s.append("}");

        return s.toString();
    }
}

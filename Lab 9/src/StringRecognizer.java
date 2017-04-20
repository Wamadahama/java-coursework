
public class StringRecognizer {

	/**
	 * precondition: none
	 * @param s: input string for testing
	 * @return true is s is in the language L = {w$w': w is a possibly empty string of characters
	 * 			other than $, w' = reverse(w)}; otherwise return false.
	 */
	boolean recognizeString(String s){	
		boolean answer = false;
		
		// Set up stack 
		char[] temp = s.toCharArray();
		StackArrayBased stack = new StackArrayBased();
	
		// Populate the stack 
		int i = 0;
		for(i = 0; i < temp.length; ++i) {
			if(temp[i] == '$') {
				break;
			}  else {
				stack.push(temp[i]);
			}
		}
		
		// i is the location of the $ so move beyond it 
		++i;
		for(;i< temp.length; ++i) {
			
			// Get item
			char item = ' ';

			if(!stack.isEmpty())
				item = (char)stack.pop();

			// Test to see if they are the smae 
			if(item == temp[i]) {
				answer = true;
			} else {
				answer = false;
			}
				
		}
		
		return answer;
	}
	
}
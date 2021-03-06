/**
 * @author Elijah Ellis
 * Monday january 30 2017
 * Sentence transformer 
 */

public class SentenceTransformer {
	
	static String firstWord (String thePhrase) {
		/* take 'thePhrase' and return only the first word*/
		return thePhrase.substring(0, thePhrase.indexOf(" "));
	}

	static String lastWords (String thePhrase) {
		/* take 'thePhrase' and return the entire phrase except the first word */
		return thePhrase.substring(thePhrase.indexOf(" "));
	}

	static int countCharacter(String thePhrase,char letter){
		/* take 'thePhrase' and return the number of times 'letter' occurs in it 
		 * example:    SentenceTransformer.countCharacter("This is one boring lab", 'o') 
		 * would return 2
		 */
		
		// Create for iteration
		char[] characterArray = thePhrase.toCharArray();
		int counter = 0;  

		// Iterate over the string
		for (int i = 0; i < characterArray.length; i++) {
			if(characterArray[i] == letter)
				++counter; // Letter found increment the counter
		}
		
		return counter;
	}
	
	static String depunctuate (String thePhrase){
		/* take 'thePhrase' and remove '.' '!' and '?' characters
		 * from it and replace them with ' ' (spaces)
		 */
		char[] punctuation = { '.', '!', '?' };

		// Create for iteration
		char[] characterArray = thePhrase.toCharArray();

		// Iterate over the string replacing punctuation 
		for (int i = 0; i < characterArray.length; i++) {
			switch (characterArray[i]) {
			case '.':
				characterArray[i] = ' ';
				break;

			case '!':
				characterArray[i] = ' ';
				break;

			case '?':
				characterArray[i] = ' ';
				break;

			default:
				break;
			}
		}
		
		return new String(characterArray);
	}
}

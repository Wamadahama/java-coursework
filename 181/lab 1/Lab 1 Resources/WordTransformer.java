/**
 * @author Elijah Ellis
 * Monday january 30 2017
 * Word transformer
 */
public class WordTransformer {

	
	static String makeCapital (String theWord){
		/* return 'theWord' with the first letter capitalized */
		return theWord.substring(0,1).toUpperCase() + theWord.substring(1);
	}

	static String lowerCase (String theWord){
		/* return 'theWord' with the first letter in lowercase */
		return theWord.substring(0,1).toLowerCase() + theWord.substring(1);
	}

	static String upperCaser (String theWord) {
		/* return 'theWord' in all uppercase */
		return theWord.toUpperCase();
	}

	static String lowerCaser (String thePhrase) {
		/* return 'theWord' in all lowerCase */
		return thePhrase.toLowerCase();
	}

	static String ezEncrypt (String theWord) {
		/* this method will take the every even/odd pair of letters and swaps them.
		 * In the case of an odd length word, the last letter will not move.
		 * Example theWord = "Super"
		 * returns "uSper"
		 */
		char[] wordArray = theWord.toCharArray();
		
		for(int i = 0; i < wordArray.length; ++i) {
			if(i+1 != wordArray.length) {
				char temp = wordArray[i+1];
				wordArray[i+1] = wordArray[i];
				wordArray[i] = temp;
			}
		}
		
		return wordArray.toString();
	}
	
	static String ezDecrypt(String theWord) {
		return ezEncrypt(theWord); 
	}
	
	private boolean isEven(int n) { 
		if(n % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}

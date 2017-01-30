
public class MainExecutable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = new String("Dr.Nick: \"Hello everybody!\"");
		System.out.println("firstWord: " + SentenceTransformer.firstWord(s));
		System.out.println("lastWords: " + SentenceTransformer.lastWords(s));
		System.out.println("countCharacter: " +SentenceTransformer.countCharacter(s, 'e')+" - e characters");
		System.out.println("depunctuate: " + SentenceTransformer.depunctuate(s));
		
		s = "philanthropist"; 
		String encrypted = WordTransformer.ezEncrypt(s);
		System.out.println("ezEncrpt: "+encrypted);
		System.out.println("ezDecrypt: " + WordTransformer.ezDecrypt(encrypted));
		System.out.println("lowerCaser: " + WordTransformer.lowerCaser(s));
		System.out.println("lowerCase: " + WordTransformer.lowerCase(s));
		System.out.println("upperCaser: " + WordTransformer.upperCaser(s));
		System.out.println("makeCapital: " + WordTransformer.makeCapital(s));

	}

}

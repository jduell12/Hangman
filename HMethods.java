import java.util.*;


public class HMethods {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	
	String userInputs = "";
	String strToGuess = "";
	String [] words = {"elephant", "tiger", "monkey", "baboon", "barbeque", "giraffe", "simple", "zebra", "porcupine", "aardvark" };
	boolean success = false; 
	
// 	Checks to see if character c is inside String str. A true is returned if it is inside 
	boolean isIn (char c, String str) {
		int index = str.indexOf(c);
		if (index >= 0) {
			return true;
		} else {
			return false;
		}
	}

	
// 	Prints current user inputs. Checks to see if user inputs are in String strToGuess. If the user guesses all the characters in the strToGuess then it returns a success. Otherwise it prints out the guessed letters in the word and returns a false
	boolean  printCurrStatus(String strToGuess, String userInputs) {

		System.out.println("Current status for user inputs = " + userInputs);
		

		int len = strToGuess.length();
		char output [] = new char[len];
		for (int i = 0; i < len; i++) {
			output[i] = '_';
		}
		
		for (int i = 0; i < len; i++) {
			if (isIn(strToGuess.charAt(i), userInputs)) {
				output[i] = strToGuess.charAt(i);
			} 
		}
		String guess = Arrays.toString(output);
		guess = guess.substring(1,  guess.length()-1).replace(",", "");
		System.out.println(guess);
		
		if(isIn('_', guess)) {
			success = false;
		} else {
			System.out.println("Congratulations: you guessed the word!!");
			success = true;
		}
		
		
		
		
		System.out.println();
		return success; 
	}
	
//	Gets a random word for the user to guess from the array of words
	String getNextWordToGuess() {
		final int num_words = 10;
		int num = rand.nextInt(num_words);
		strToGuess = words[num];
		return strToGuess;
	}

// Plays the hangman game
	void playGame() {
		strToGuess = getNextWordToGuess();
		userInputs = "";
		do {
			System.out.println("Enter a letter: ");
			String input = scan.next();
			input = input.trim();
			char c = input.charAt(0);
			userInputs += c;
			printCurrStatus(strToGuess, userInputs);
		} while (success == false);
		
	}
}

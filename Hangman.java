import java.util.*;

public class Hangman {

	public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	HMethods methods = new HMethods();
	String response = "";

// Calls the hangman game once and after each successful game it asks the user if they wish to continue playing. If the user enters in a y it plays a new game otherwise it exits the program
	do {
		methods.playGame();
		System.out.println("Do you want to play object orientated Hangman again? (y or n)");
		response = scan.nextLine();
	} while (response.charAt(0) == 'y');
	System.out.println("Bye");
	
	
	
	scan.close();
	}

}

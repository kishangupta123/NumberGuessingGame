import java.net.UnixDomainSocketAddress;
import java.util.Random;
import java.util.Scanner;

public class GameUtils {
	private static final Scanner scanner = new Scanner(System.in);

	// Display the rules of the game
	public static void displayRules() {
		System.out.println("I'm thinking of a number between 1 and 100.");
		System.out.println("You will be given chance based on your difficulty level");
	}

	public static int getDifficultyLevel() {
		while (true) {
			System.out.println("\n Please select the difficulty level : ");
			System.out.println("1. Easy (10 chances)");
			System.out.println("2. Medium (5 chances)");
			System.out.println("3. Hard (3 chances)");

			try {
				int choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
				case 1:
					return 10;
				case 2:
					return 5;
				case 3:
					return 3;
				default:
					System.out.println("Invaid choice. Please enter 1, 2 or 3. ");
					break;
				}
			} 
			catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid number.");
			}
		}
	}

	// Get random number 
	public static int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(100) + 1;
	}
	
	// Get User number and validate it
	public static int getUserGuess() {
		while(true) {
			try {
				System.out.print("Enter your guess :  ");
				int guess = Integer.parseInt(scanner.nextLine());
				return guess;
			}catch(NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid number. ");
			}
		}
	}
	
	// Provide feedback to the user whether the guess is too high or too low	
	public static void provideFeedback(int guess, int numberToGuess) {
		if(guess < numberToGuess) {
			System.out.println("Incorrect! The number is greater  than " + guess + ".");
		}else {
			System.out.println("Incorrect! The number is lesser than " + guess + ".");
		}
	}
	
	public static boolean askPlayAgain() {
		System.out.print("Do you want to play again ? (y/n): ");
		String response = scanner.nextLine().trim().toLowerCase();
		return response.equalsIgnoreCase("y");
	}
}

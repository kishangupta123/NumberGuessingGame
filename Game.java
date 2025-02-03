public class Game {
	public static void main(String[] args) {
		System.out.println("Welcome to the Number Guessing Game. ");
		GameUtils.displayRules();

		boolean playAgain = true;
		while (playAgain) {
			int chances = GameUtils.getDifficultyLevel();

			Player player = new Player(chances);
			int numberToGuess = GameUtils.getRandomNumber();

			long startTime = System.currentTimeMillis();
			boolean guessedCorrectly = false;

			while (player.getChances() > 0 && !guessedCorrectly) {
				System.out.println("\n You have " + player.getChances() + " chances left.");
				int guess = GameUtils.getUserGuess();
				player.incrementAttempts();

				if (guess == numberToGuess) {
					guessedCorrectly = true;
				} else {
					GameUtils.provideFeedback(guess, numberToGuess);
					player.decrementChances();
				}
			}

			long endTime = System.currentTimeMillis();
			long timeTaken = (endTime - startTime) / 1000;

			if (guessedCorrectly) {
				System.out.println("Congratulations! You guessed the correct number in " + player.getAttempts()
						+ " attempts and the total time taken is " + timeTaken + " seconds.");
			} else {
				System.out.println("Sorry, you ran out of chances. The correct number was " + numberToGuess + ".");
			}
			playAgain = GameUtils.askPlayAgain();
		}

		System.out.println("Thanks for playing! GoodBye. ");
	}
}

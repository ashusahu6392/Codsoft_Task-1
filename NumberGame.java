import java.util.Scanner;
import java.util.Random;

class NumberGuessingGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 5;

    private int score;
    private Random random;
    private Scanner scanner;

    public NumberGuessingGame() {
        random = new Random();
        scanner = new Scanner(System.in);
        score = 0;
    }

    public void startGame() {
        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain;
        do {
            playRound();
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }

    private void playRound() {
        int targetNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int attempts = 0;
        boolean hasWon = false;

        System.out.println("\n--- New Round ---");
        System.out.println("Guess the number between " + MIN_NUMBER + " and " + MAX_NUMBER);

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                score += (MAX_ATTEMPTS - attempts + 1); // Higher score for fewer attempts
                hasWon = true;
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (!hasWon) {
            System.out.println("Sorry, you've used all attempts. The correct number was " + targetNumber);
        }
    }
}

public class NumberGame {
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.startGame();
    }
}

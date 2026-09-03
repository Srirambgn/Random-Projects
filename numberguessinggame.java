import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class numberguessinggame {
    public static void main(String[] args) {
        // This program implements a number guessing game where the user tries to guess a randomly generated number between 1 and 100.
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        List<Integer> guesses = new ArrayList<>(); // List to store user's guesses
        int attempts = 0; // Counter for the number of attempts

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++; // Increment the attempt counter
            guesses.add(userGuess); // Add the guess to the list

            if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + targetNumber + " in " + attempts + " attempts.");
                break; // Exit the loop if the guess is correct
            }
        }

        System.out.println("Your guesses were: " + guesses); // Display all guesses made by the user
        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
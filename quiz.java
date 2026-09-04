import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();

        // Add questions and answers to the lists
        questions.add("What is the capital of France?");
        answers.add("Paris");
        questions.add("What is 34 + 120?");
        answers.add("154");
        questions.add("What is the largest planet in our solar system?");
        answers.add("Jupiter");
        questions.add("What is the chemical symbol for water?");
        answers.add("H2O");
        questions.add("Who wrote 'Romeo and Juliet'?");
        answers.add("Shakespeare");

        int score = 0;
        int totalQuestions = 3; // Number of questions to ask

        System.out.println("You will now take a quiz!");
        System.out.println("You will be asked " + totalQuestions + " questions.");

        for (int i = 0; i < totalQuestions; i++) {
            int index = random.nextInt(questions.size());
            String question = questions.get(index);
            String answer = answers.get(index);

            System.out.println("Question " + (i + 1) + ": " + question);
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + answer);
            }
            // Remove the asked question to avoid repetition
            questions.remove(index);
            answers.remove(index);
        }

        System.out.println("Quiz Over! Your score: " + score + "/" + totalQuestions);
        if (score == totalQuestions) {
            System.out.println("Rating: Mastermind");
        } else if (score >= totalQuestions / 2) {
            System.out.println("Rating: Good");
        } else {
            System.out.println("Rating: Get Better");
        }
        scanner.close(); // Close the scanner to prevent resource leaks
    }
}

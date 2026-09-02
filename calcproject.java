import java.util.Scanner;
// This is a simple calculator program that takes two numbers and an operator from the user and performs the corresponding calculation.
public class calcproject {
    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator Project!");
        Scanner scanner = new Scanner(System.in);
        // Prompt user for first number
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        // Prompt user for operator and second number
        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        // Prompt user for second number
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result = 0;
        boolean valid = true;
        // Perform calculation based on the operator
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    // Handle division by zero
                    System.out.println("Error: Cannot divide by zero. Please understand math.");
                    valid = false;
                }
                break;
            default:
                // Handle invalid operator
                System.out.println("Error: Invalid operator.");
                valid = false;
        }

        if (valid) {
            // Display the result of the calculation
            System.out.println("Result: " + result);
        }
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}

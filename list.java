import java.util.Scanner;
import java.util.ArrayList;

public class list{
    public static void main(String[] args){
        // This program allows the user to input a list of numbers and stores them in an ArrayList. The user can type 'done' to finish entering numbers.
        ArrayList<Integer> list = new ArrayList<>();
        // Prompt the user to enter numbers
        System.out.println("Enter numbers (type 'done' to finish):");
        // Use a try-with-resources statement to ensure the Scanner is closed automatically

        try (Scanner sc = new Scanner(System.in)) {
            // Continuously read user input until 'done' is entered
            while(true){
                String input = sc.nextLine();
                if(input.equalsIgnoreCase("done")){
                    // If the user types 'done', exit the loop
                    break;
                }
                try{
                    int number = Integer.parseInt(input);
                    // If the input is a valid number, add it to the list
                    list.add(number);
                } catch(NumberFormatException e){
                    System.out.println("Invalid input. Please enter a number or 'done'.");
                    // If the input is not a valid number, print an error message and prompt the user again
                }
            }
        }
        // Print the list of numbers entered by the user
        System.out.println("You entered: " + list);
    }
}

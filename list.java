import java.util.Scanner;
import java.util.ArrayList;

public class list{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter numbers (type 'done' to finish):");

        try (Scanner sc = new Scanner(System.in)) {
            while(true){
                String input = sc.nextLine();
                if(input.equalsIgnoreCase("done")){
                    break;
                }
                try{
                    int number = Integer.parseInt(input);
                    list.add(number);
                } catch(NumberFormatException e){
                    System.out.println("Invalid input. Please enter a number or 'done'.");
                }
            }
        }
        
        System.out.println("You entered: " + list);
    }
}

import java.util.ArrayList;

public class homework7 {
    public static void main(String[] arg) {
        // This program demonstrates the use of an ArrayList to store and manipulate a list of game elements.
        ArrayList<String> gameElements = new ArrayList<>();
        // Add elements to the ArrayList
        gameElements.add("Block");
        gameElements.add("Specimen");
        gameElements.add("Ring");
        // Remove the first element from the ArrayList
        gameElements.remove(0);
        // Get the size of the ArrayList and print it
        int count = gameElements.size();
        // Print the number of elements in the ArrayList
        System.out.println("There are " + count + " elements.");
        // Get the first two elements from the ArrayList and print them
        String element1 = gameElements.get(0);
        String element2 = gameElements.get(1);
        System.out.println("List of elements in the array: " + element1 + " " + element2);

    }
}

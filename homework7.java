import java.util.ArrayList;

public class homework7 {
    public static void main(String[] arg) {
        ArrayList<String> gameElements = new ArrayList<>();
        gameElements.add("Block");
        gameElements.add("Specimen");
        gameElements.add("Ring");
        gameElements.remove(0);
        int count = gameElements.size();
        System.out.println("There are " + count + " elements.");
        String element1 = gameElements.get(0);
        String element2 = gameElements.get(1);
        System.out.println("List of elements in the array: " + element1 + " " + element2);

    }
}
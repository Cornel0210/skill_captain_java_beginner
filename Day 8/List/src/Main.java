import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {

        while (scanner.hasNextLine()){
            printActions();
            int i = Integer.parseInt(scanner.nextLine());
            if (i == 6){
                break;
            }

            switch (i){
                case 1:
                    System.out.println("Insert the item you want to add to the list: ");
                    addItem(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Insert the item you want to remove from the list: ");
                    removeItem(scanner.nextLine());
                    break;
                case 3:
                    printGroceryList();
                    break;
                case 4:
                    System.out.println("Find item: ");
                    findItem(scanner.nextLine());
                    break;
                case 5:
                    clearList();
                    break;
                default:
                    System.out.println("Invalid action. Try again!");
            }

        }

    }

    private static void printActions(){
        System.out.println("1 - Add items to the grocery list.\n" +
                "2 - Remove items from the grocery list.\n" +
                "3 - Print the current grocery list.\n" +
                "4 - Check if a specific item is already on the grocery list.\n" +
                "5 - Clear the entire grocery list.\n" +
                "6 - quit");
    }

    private static void addItem(String item){
        groceryList.add(item);
    }

    private static void removeItem(String item){
        groceryList.remove(item);
    }

    private static void findItem(String item){
        System.out.println(groceryList.contains(item) ? "there is " + item + " on the list." : item + " is not included.");
    }

    private static void printGroceryList(){
        System.out.println("Grocery list: ");
        for (String item : groceryList){
            System.out.println(item);
        }
    }

    private static void clearList(){
        groceryList.clear();
    }
}

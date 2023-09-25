import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private final static Set<Integer> numbers = new HashSet<>();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        readNumbers();
    }

    private static void readNumbers(){
        System.out.println("Insert a series of numbers, one at a time:");
        int currentNumber;
        while (scanner.hasNextInt()){
            currentNumber = scanner.nextInt();
            if (isDuplicate(currentNumber)){
                System.out.println("The list already contains " + currentNumber);
            } else {
                addNumberToSet(currentNumber);
            }
            printNumbers();
        }
    }

    private static boolean isDuplicate(int number){
        return numbers.contains(number);
    }

    private static void addNumberToSet(int number){
        numbers.add(number);
        System.out.println(number + " has been added successfully.");
    }

    private static void printNumbers(){
        System.out.println("Current list has: ");
        numbers.forEach(number -> System.out.print(number + ", "));
        System.out.println();
    }
}

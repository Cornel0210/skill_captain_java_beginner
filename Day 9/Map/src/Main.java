import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, Integer> frequencies = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static String input;

    public static void main(String[] args) {

        getInput();
        processInput();
        printFrequencies();
    }

    private static void getInput(){
        System.out.println("Insert the paragraph:");
        input = scanner.nextLine();
    }

    private static void processInput(){
        String[] words = input.trim().split(" ");

        for (String word : words){
            word = word.replaceAll("\\W", "");
            frequencies.computeIfPresent(word, (k,v) -> ++v);
            frequencies.putIfAbsent(word, 1);
        }
    }

    private static void printFrequencies(){
        frequencies.forEach((k,v) -> System.out.println("Word \"" + k + "\" appears " + v + " time(s)."));
    }
}

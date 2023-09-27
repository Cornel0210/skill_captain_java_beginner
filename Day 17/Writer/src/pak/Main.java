package pak;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = null;
        System.out.println("Enter the sentence that you want to write in the output.txt");
        while (scanner.hasNextLine()){
            try {
                sentence = scanner.nextLine();
                break;
            } catch (NoSuchElementException | IllegalStateException e){
                e.printStackTrace();
            }
        }
        scanner.close();

        if (sentence != null){
            try (FileWriter fileWriter = new FileWriter("output.txt");
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
                bufferedWriter.write(sentence);

            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

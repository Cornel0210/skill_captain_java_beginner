package pak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        try (FileReader fr = new FileReader("input.txt");
                BufferedReader bufferedReader = new BufferedReader(fr)){

            String data;
            while ((data = bufferedReader.readLine())!= null){
                String[] words = data.trim().split(" ");
                count = getWordOccurrences(words, "Java");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Total occurrences of 'Java': " + count);
    }

    private static int getWordOccurrences(String[] words, String target){
        int count = 0;
        for (String word : words){
            word = word.trim().replaceAll("\\W", "");
            if (word.equalsIgnoreCase("java")){
                count++;
            }
        }
        return count;
    }
}

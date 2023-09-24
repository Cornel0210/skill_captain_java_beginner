import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        int i = 1;
        while (i <= 20){
            if (i % 2 == 0){
                System.out.print(i + " ");
            }
            i++;
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a number between 1 and 10:");
            i = scanner.nextInt();
            scanner.nextLine();
        } while (i <= 1 || i >= 10);
        System.out.println("You entered " + i + ".");
    }
}

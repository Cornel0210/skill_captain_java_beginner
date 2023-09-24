import java.util.Scanner;

public class AgeAndName {

    public static void main(String[] args) {
        String name;
        int age;
        Scanner scanner = new Scanner(System.in);

        age = scanner.nextInt();
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "! You are " + age + " years old.");

    }
}

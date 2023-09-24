import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int first;
        int second;
        Scanner scanner = new Scanner(System.in);

        first = scanner.nextInt();
        second = scanner.nextInt();

        if (first > second){
            System.out.println(first);
        } else {
            System.out.println(second);
        }
    }
}

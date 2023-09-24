import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nr1, nr2;
        String sign;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number:");
        nr1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter second number:");
        nr2 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter operation(+,-,*,/):");
        sign = scanner.nextLine();

        int output = 0;
        switch (sign){
            case "+":
                output = nr1 + nr2;
                break;
            case "-":
                output = nr1 - nr2;
                break;
            case "*":
                output = nr1 * nr2;
                break;
            case "/":
                output = nr1 / nr2;
                break;
            default:
                System.out.println("Invalid operator");
        }

        if ("+-/*".contains(sign)){
            System.out.printf("%d %s %d = %d", nr1, sign, nr2, output);
        }
    }
}

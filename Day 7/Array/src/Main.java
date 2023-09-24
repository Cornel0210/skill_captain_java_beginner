import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[5];
        int sum = 0;
        int average;
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 5 integer values:");
        int count = 0;
        while (count <5){
            array[count] = scanner.nextInt();
            scanner.nextLine();
            count++;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i]<minimum){
                minimum = array[i];
            }
            if (array[i]>maximum){
                maximum = array[i];
            }
            sum += array[i];
        }
        average = sum/array.length;
        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
        System.out.println("maximum = " + maximum);
        System.out.println("minimum = " + minimum);
    }
}

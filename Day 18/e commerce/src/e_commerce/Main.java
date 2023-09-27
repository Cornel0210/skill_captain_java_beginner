package e_commerce;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        playConsole(repository);

        scanner.close();
    }

    private static void playConsole(UserRepository repository){
        boolean flag = true;
        while (flag){
            printOptions();

            switch (getInt()){
                case 1:
                    repository.addUser(getNewUser());
                    break;
                case 2:
                    System.out.println("Enter the email address:");
                    String email = getString();
                    if (isValidEmail(email)){
                        User user = repository.getUser(email);
                        System.out.println(user == null ? "There is no such user" : user);
                    } else {
                        System.out.println("Invalid email address.");
                    }
                    break;
                case 3:
                    Set<User> users = repository.getAllUsers();
                    for (User user : users){
                        System.out.println(user);
                    }
                    break;
                case 4:
                    flag = false;
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("There is no such option");
            }
        }
    }

    private static void printOptions(){
        System.out.println("1 - add a new user");
        System.out.println("2 - get a user");
        System.out.println("3 - get all users");
        System.out.println("4 - quit");
    }

    private static boolean isValidEmail(String email){
        return Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
                .matcher(email)
                .matches();
    }

    private static User getNewUser(){
        System.out.println("Enter your name: ");
        String name = getString();
        System.out.println("Enter your email: ");
        String email = getString();
        while (!isValidEmail(email)){
            System.out.println("Enter a valid email (eq.: username@domain.com): ");
            email = getString();
        }
        System.out.println("Enter your password: ");
        String password = getString();
        System.out.println("Enter your address: ");
        String address = getString();
        return new User(name, email, password, address);
    }

    private static String getString(){
        String input = null;
        while (scanner.hasNextLine()){
            try {
                input = scanner.nextLine();
                break;
            } catch (NoSuchElementException | IllegalStateException e){
                e.printStackTrace();
            }
        }
        return input;
    }

    private static int getInt(){
        int input = -1;
        while (scanner.hasNextLine()){
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException | NoSuchElementException | IllegalStateException e){
                e.printStackTrace();
            }
        }
        return input;
    }
}

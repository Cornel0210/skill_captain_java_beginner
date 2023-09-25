package bank;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", "Joe", 20.2d);
        account.printClientDetails();

        account.deposit("Joe", "12345", 12.99d);
        account.printClientDetails();

        account.withdraw("Joe", "12345", 10d);
        account.printClientDetails();
    }
}

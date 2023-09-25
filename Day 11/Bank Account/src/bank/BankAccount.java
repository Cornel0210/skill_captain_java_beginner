package bank;

public class BankAccount {
    private final String accountNumber;
    private final String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(String name, String account, double amount){

        if (isSameName(name) && isSameAccount(account)){
            if (amount > 0){
                this.balance+=amount;
                System.out.println("You have been added $" + amount + " to your account.\n" +
                        "Current balance: $" + balance);
            } else {
                System.out.println("You can't use a negative value. Try again.");
            }
        } else {
            System.out.println("Please retry to enter your name and bank account.");
        }
    }

    public void withdraw(String name, String account, double amount){

        if (isSameName(name) && isSameAccount(account)){
            if (balance-amount > 0){
                this.balance-=amount;
                System.out.println("You hda withdrawn $" + amount + " from your account.\n" +
                        "Current balance: $" + balance);
            } else {
                System.out.println("You have only $" + amount);
            }
        } else {
            System.out.println("Please retry to enter your name and bank account.");
        }
    }

    public void printClientDetails(){
        System.out.printf("Name: %s\nAccount: %s\nBalance: $%.2f\n", holderName, accountNumber, balance);
        System.out.println("----------------------------------------");
    }

    private boolean isSameName(String name){
        return name.equals(holderName);
    }
    private boolean isSameAccount(String accountNumber){
        return accountNumber.equals(this.accountNumber);
    }
}

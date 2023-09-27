package product_registration;

import java.time.LocalDate;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProductRegistrationSystem {
    private final Scanner scanner;
    private final Map<String, Product> products;

    public ProductRegistrationSystem() {
        this.scanner = new Scanner(System.in);
        products = new HashMap<>();
    }

    private void registerAProduct(){
        System.out.println("Insert product's name");
        String prodName = getString();

        System.out.println("Insert product's id");
        String prodId = getString();
        while (products.containsKey(prodId)){
            System.err.println("This id is already used. Try another one!");
            prodId = getString();
        }

        System.out.println("Insert product's description");
        String prodDescription = getString();

        System.out.println("Insert product's manufacturer");
        String prodManufacturer = getString();

        System.out.println("Insert the month of production");
        int month = getInt();
        while (month < 1 || month > 12){
            System.out.println("Insert a valid month, from 1 to 12");
            month = getInt();
        }
        StringBuilder productionDate =  new StringBuilder(String.valueOf(month));

        System.out.println("Insert the year of production");
        int year = getInt();
        int currentYear = Year.now().getValue();
        while (year > currentYear || year<2000){
            System.err.println("Insert a year before the current year, but not less than 2000.");
            year = getInt();
        }
        productionDate.append(".").append(year);

        System.out.println("Insert product's warranty (period in months)");
        int prodWarranty = getInt();

        Product product = new Product(prodId, prodName, prodDescription, prodManufacturer, productionDate.toString(), prodWarranty);
        if (products.putIfAbsent(prodId, product) == null){
            System.out.println(prodName + " has been added.");
        } else {
            System.out.println("Product was already registered.");
        }
    }

    private void displayAllProducts(){
        if (products.keySet().isEmpty()){
            System.out.println("There is no product registered");
            return;
        }

        int count = 1;
        for (String id : products.keySet()){
            System.out.println(count++ + "- " + products.get(id));
        }
    }

    private void searchForAProduct(){
        System.out.println("Insert product's id");
        String id = getString();
        Product product = products.get(id);
        if (product != null){
            System.out.println(product);
        } else {
            System.out.println("There is no such product.");
        }
    }

    private void generateReport(){
        int count = products.keySet().size();
        System.out.println(count + " products registered.");
        for (Product product : products.values()){
            System.out.println(product.getProductName() + " (ID: " + product.getProductId() + ")" +
                    (isExpired(product) ? " is expired" : " is active"));
        }
    }

    private boolean isExpired(Product product){
        int currentYear = Year.now().getValue();
        int currentMonth = LocalDate.now().getMonthValue();

        String[] data = product.getProductionDate().trim().split("\\.");
        int productMonth = Integer.parseInt(data[0]);
        int productYear = Integer.parseInt(data[1]);
        if (productYear == currentYear){
            return currentMonth - productMonth > product.getWarrantyPeriod();
        } else if (currentYear-productYear == 1) {
            int months = 12-productMonth + currentMonth;
            return months > product.getWarrantyPeriod();
        } else {
            int yearsBetween = currentYear-productYear-1;
            int months = 12-productMonth + (12 * yearsBetween) + currentMonth;
            return months > product.getWarrantyPeriod();
        }
    }

    private String getString(){
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

    private int getInt(){
        int input = -1;
        while (scanner.hasNextLine()){
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException | NoSuchElementException | IllegalStateException e){
                System.err.println("Insert a whole number:");
            }
        }
        return input;
    }

    public void playConsole(){
        boolean flag = true;
        while (flag) {
            printOptions();
            switch (getInt()){
                case 1:
                    registerAProduct();
                    break;
                case 2:
                    displayAllProducts();
                    break;
                case 3:
                    searchForAProduct();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    flag = false;
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("There is no such option. Try again!");
                    break;
            }
        }
    }

    private void printOptions(){
        System.out.println("1 - register a product");
        System.out.println("2 - display all registered products");
        System.out.println("3 - search for a product by its id");
        System.out.println("4 - generate a report for all registered products");
        System.out.println("5 - quit");
    }

}



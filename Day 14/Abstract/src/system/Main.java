package system;

import java.util.*;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static Set<Vehicle> vehicleInventory = new HashSet<>();


    public static void main(String[] args) {
        Car toyota = new Car("Toyota", "Camry", 2022, 35_000d, 4, "Gasoline");
        toyota.displayDetails();

        Motorcycle harleyDavidson = new Motorcycle("Harley Davidson", "Nightster", 2023, 24_450d, false, 1200);
        harleyDavidson.displayDetails();

       chooseOption();

    }

    private static void chooseOption(){
        boolean flag = true;

        while (flag){
            System.out.println("Choose what you want to do between:");
            printOptions();
            int input = getInt();
            switch (input){
                case 1:
                    addVehicle();
                    break;
                case 2:
                    printList(vehicleInventory);
                    break;
                case 3:
                    searchForAVehicle();
                    break;
                case 4:
                    updateAVehicle();
                    break;
                case 5:
                    removeAVehicle();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }


    }

    private static void updateAVehicle(){
        System.out.println("Insert vehicle's make:");
        String make = getString();
        System.out.println("Insert vehicle's model:");
        String model = getString();
        System.out.println("Insert vehicle's year of manufacture:");
        int year = getInt();

        Vehicle vehicleToChange = null;
        for (Vehicle vehicle : vehicleInventory){
            if (vehicle.make.equalsIgnoreCase(make) &&
            vehicle.model.equalsIgnoreCase(model) &&
            vehicle.year == year){
                vehicleToChange = vehicle;
            }
        }

        if (vehicleToChange == null){
            System.out.println("There is no such an vehicle in the inventory.");
            return;
        }

        if (vehicleToChange instanceof Car){
            System.out.println("Enter new specifications:");
            vehicleInventory.remove(vehicleToChange);
            vehicleInventory.add(getCar());
        } else {
            System.out.println("Enter new specifications:");
            vehicleInventory.remove(vehicleToChange);
            vehicleInventory.add(getMotorcycle());
        }

    }

    private static void removeAVehicle(){
        System.out.println("Insert the type of the vehicle (car or motorcycle):");
        String input = getString();
        while (!input.equalsIgnoreCase("car") && !input.equalsIgnoreCase("motorcycle")){
            System.err.println("Insert car or motorcycle!");
            input = getString();
        }
        boolean wasRemoved = false;
        if (input.equalsIgnoreCase("car")){
            Car car = getCar();
            Iterator<Vehicle> iterator = vehicleInventory.iterator();
            while (iterator.hasNext()){
                if (iterator.next().equals(car)){
                    iterator.remove();
                    wasRemoved= true;
                    break;
                }
            }
        } else {
            Motorcycle moto = getMotorcycle();
            Iterator<Vehicle> iterator = vehicleInventory.iterator();
            while (iterator.hasNext()){
                if (iterator.next().equals(moto)){
                    iterator.remove();
                    wasRemoved= true;
                    break;
                }
            }
        }
        if (!wasRemoved){
            System.out.println("No item was removed.");
        } else {
            System.out.println("Car has been removed from the inventory.");
        }
    }

    private static void searchForAVehicle(){
        System.out.println("Insert filter (make, model, year, price):");
        String filter = getString();
        Set<Vehicle> foundVehicles = new HashSet<>();
        switch (filter){
            case "make":
                System.out.println("Insert the make:");
                String make = getString();
                for (Vehicle vehicle : vehicleInventory){
                    if (vehicle.make.equalsIgnoreCase(make)){
                        foundVehicles.add(vehicle);
                    }
                }
                printList(foundVehicles);
                break;
            case "model":
                System.out.println("Insert the model:");
                String model = getString();
                for (Vehicle vehicle : vehicleInventory){
                    if (vehicle.model.equalsIgnoreCase(model)){
                        foundVehicles.add(vehicle);
                    }
                }
                printList(foundVehicles);
                break;
            case "year":
                System.out.println("Insert the year:");
                int year = getInt();
                for (Vehicle vehicle : vehicleInventory){
                    if (vehicle.year == year){
                        foundVehicles.add(vehicle);
                    }
                }
                printList(foundVehicles);
                break;
            case "price":
                foundVehicles = searchInPriceRange();
                printList(foundVehicles);
                break;
            default:
                System.out.println("Invalid filter.");
                break;
        }

    }

    private static Set<Vehicle> searchInPriceRange(){
        System.out.println("Insert the min price:");
        double minPrice = getDouble();
        System.out.println("Insert the max price:");
        double maxPrice = getDouble();

        if (minPrice > maxPrice){
            System.err.println("Minimum price has to be a lower value than the maximum price.");
            return null;
        }

        Set<Vehicle> foundVehicles = new HashSet<>();
        for (Vehicle vehicle : vehicleInventory){
            if (vehicle.price >= minPrice && vehicle.price <= maxPrice){
                foundVehicles.add(vehicle);
            }
        }
        return foundVehicles;
    }

    private static void printOptions(){
        System.out.println("1 - add a vehicle to the inventory.\n" +
                "2 - display the details about all vehicles from the inventory.\n" +
                "3 - search for a vehicle.\n" +
                "4 - update details about a vehicle.\n" +
                "5 - remove a vehicle.\n" +
                "6 - quit\n");
    }

    private static void addVehicle(){
        System.out.println("Insert the type of the vehicle (car or motorcycle):");
        String input = getString();
        while (!input.equalsIgnoreCase("car") && !input.equalsIgnoreCase("motorcycle")){
            System.err.println("Insert car or motorcycle!");
            input = getString();
        }
        switch (input.trim().toLowerCase()){
            case "car":
                vehicleInventory.add(getCar());
                break;
            case "motorcycle":
                vehicleInventory.add(getMotorcycle());
                break;
        }
    }

    private static Car getCar(){
        System.out.println("Insert car's make:");
        String make = getString();
        System.out.println("Insert car's model:");
        String model = getString();
        System.out.println("Insert car's year of manufacture:");
        int year = getInt();
        System.out.println("Insert car's price:");
        double price = getDouble();
        System.out.println("Insert car's number of doors:");
        int numDoors = getInt();
        System.out.println("Insert car's fuel type:");
        String fuelType = getString();
        return new Car(make, model, year, price, numDoors, fuelType);
    }

    private static Motorcycle getMotorcycle(){
        System.out.println("Insert motorcycle's make:");
        String make = getString();
        System.out.println("Insert motorcycle's model:");
        String model = getString();
        System.out.println("Insert motorcycle's year of manufacture:");
        int year = getInt();
        System.out.println("Insert motorcycle's price:");
        double price = getDouble();
        System.out.println("Insert true if motorcycle has sidecar, false otherwise:");
        boolean hasSidecar = getBoolean();
        System.out.println("Insert motorcycle's engine capacity:");
        int engineCapacity = getInt();
        return new Motorcycle(make, model, year, price, hasSidecar, engineCapacity);
    }

    private static void printList(Set<Vehicle> list){
        if (list == null){
            System.out.println("There is no vehicle!");
        } else {
            System.out.println("Vehicle(s) found: ");
            list.forEach(Vehicle::displayDetails);
        }
    }

    private static String getString(){
        String input = null;
        while (scanner.hasNextLine()){
            try {
                input = scanner.nextLine();
                break;
            } catch (IllegalStateException | NoSuchElementException e){
                System.err.println("Insert a string value.");
            }

        }
        return input;
    }

    private static int getInt(){
        int input = -1;
        while (scanner.hasNextLine()){
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input<=0){
                    throw new NumberFormatException();
                } else {
                    break;
                }
            } catch (IllegalStateException | NoSuchElementException | NumberFormatException e){
                System.err.println("Insert a whole number.");
            }
        }
        return input;
    }

    private static double getDouble(){
        double input = -1;
        while (scanner.hasNextLine()){
            try {
                input = Double.parseDouble(scanner.nextLine());
                if (input <= 0){
                    throw new NumberFormatException();
                } else {
                    break;
                }
            } catch (IllegalStateException | NoSuchElementException | NumberFormatException e){
                System.err.println("Insert a positive real number.");
            }
        }
        return input;
    }

    private static boolean getBoolean(){
        String input = getString();
        while (!input.equalsIgnoreCase("true") && !input.equalsIgnoreCase("false")){
            System.err.println("Insert true or false!");
            input = getString();
        }
        return input.equalsIgnoreCase("true");
    }
}

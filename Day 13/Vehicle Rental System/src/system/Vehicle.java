package system;

public class Vehicle {
    private final String brand;
    private final String model;
    private final int year;
    private final double rentalPrice;

    public Vehicle(String brand, String model, int year, double rentalPrice) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }

    public void printVehicleInformation(){
        System.out.printf("Brand: %s\nModel: %s\nYear: %d\nRental price: $%.2f\n", brand, model, year, rentalPrice);
        System.out.println("------------------------------");
    }
}

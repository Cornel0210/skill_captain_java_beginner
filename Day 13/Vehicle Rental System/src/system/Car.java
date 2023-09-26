package system;

public class Car extends Vehicle{
    private final int numberOfSeats;

    public Car(String brand, String model, int year, double rentalPrice, int numberOfSeats) {
        super(brand, model, year, rentalPrice);
        this.numberOfSeats = numberOfSeats;
    }

    private int getNumberOfSeats(){
        return numberOfSeats;
    }

    @Override
    public void printVehicleInformation(){
        System.out.println("Number of seats: " + getNumberOfSeats());
        super.printVehicleInformation();
    }
}

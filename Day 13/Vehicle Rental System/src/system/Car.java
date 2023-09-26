package system;

public class Car extends Vehicle{
    private final int numberOfSeats;

    public Car(String brand, String model, int year, double rentalPrice, int numberOfSeats) {
        super(brand, model, year, rentalPrice);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats(){
        return numberOfSeats;
    }
}

package system;

public class Car extends Vehicle{
    private final int numDoors;
    private final String fuelType;

    public Car(String make, String model, int year, double price, int numDoors, String fuelType) {
        super(make, model, year, price);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    public int calculateMileage(int tankCapacity, double averageConsumption){ //I don't really understand what you want to implement in this method
        return (int)((tankCapacity * 100) / averageConsumption); //the method returns how many miles you can go with the car :-??
    }

    @Override
    void displayDetails() {
        System.out.printf("Make: %s\nModel: %s\nYear: %d\nPrice: $%.2f\nNumber of doors: %d\nFuel:%s\nMileage: %d\n",
                make, model, year, price, numDoors, fuelType, calculateMileage(40, 7.8));
        System.out.println("------------------------------");
    }
}

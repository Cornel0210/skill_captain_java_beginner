package system;

public class Motorcycle extends Vehicle{
    private final int engineCapacity;

    public Motorcycle(String brand, String model, int year, double rentalPrice, int engineCapacity) {
        super(brand, model, year, rentalPrice);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity(){
        return engineCapacity;
    }
}

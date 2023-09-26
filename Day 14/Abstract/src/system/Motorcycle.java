package system;

public class Motorcycle extends Vehicle{
    private final boolean hasSidecar;
    private final int engineCapacity;

    public Motorcycle(String make, String model, int year, double price, boolean hasSidecar, int engineCapacity) {
        super(make, model, year, price);
        this.hasSidecar = hasSidecar;
        this.engineCapacity = engineCapacity;
    }

    private int calculateSpeed(){
        return hasSidecar ?
                (engineCapacity > 1000 ? 180 : 130) :
                (engineCapacity > 1000 ? 250 : 200);
    }


    @Override
    void displayDetails() {
        System.out.printf("Make: %s\nModel: %s\nYear: %d\nPrice: $%.2f\nEngine capacity: %d\nTop Speed: %d\n",
                make, model, year, price, engineCapacity, calculateSpeed());
        System.out.println(hasSidecar ? "Motorcycle has a sidecar." : "This motorcycle hasn't a sidecar.");
        System.out.println("------------------------------");
    }
}

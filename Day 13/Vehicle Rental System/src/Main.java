import system.Car;
import system.Motorcycle;
import system.Vehicle;

public class Main {
    public static void main(String[] args) {
        Car toyota = new Car("Toyota", "Camry", 2022, 200.50d, 4);
        toyota.printVehicleInformation();

        Motorcycle harleyDavidson = new Motorcycle("Harley Davidson", "Nightster", 2023, 349.50d, 975);
        harleyDavidson.printVehicleInformation();

        Vehicle mitsubishi = new Car("Mitsubishi", "Lancer", 2008, 50.5d, 4);
        mitsubishi.printVehicleInformation();
    }
}

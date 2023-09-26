package system;

public abstract class Vehicle {
    public String make;
    public String model;
    public int year;
    public double price;

    public Vehicle(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    abstract void displayDetails();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (year != vehicle.year) return false;
        if (Double.compare(vehicle.price, price) != 0) return false;
        if (!make.equals(vehicle.make)) return false;
        return model.equals(vehicle.model);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = make.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + year;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

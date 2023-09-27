package product_registration;

public class Product {
    private final String productId;
    private final String productName;
    private final String description;
    private final String manufacturer;
    private final int warrantyPeriod;
    private final String productionDate;

    public Product(String productId, String productName, String description, String manufacturer, String productionDate, int warrantyPeriod) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
        this.productionDate = productionDate;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\n" +
                "\tId: %s\n" +
                "\tManufacturer: %s\n" +
                "\tDescription: %s\n" +
                "\tWarranty: %s months\n" +
                "\tProduction Date: %s\n", productName, productId, manufacturer, description, warrantyPeriod, productionDate);
    }
}

/*
Title: Product Class
Name: Karanvir Kooner
Date: 2024-07-26
Purpose: To get and set variables
*/

public class Product {
    // Class fields
    private String sku;
    private String productName;
    private double unitCost;
    private double salePrice;
    private int quantityInStore;
    private int quantityRequired;
    private String specialInstructions;

    // Default constructor
    public Product() {
        this.sku = "DefaultSKU";
        this.productName = "Default Product";
        this.unitCost = 0.0;
        this.salePrice = 0.0;
        this.quantityInStore = 0;
        this.quantityRequired = 0;
        this.specialInstructions = "None";
    }
    // Parameterized constructor
    public Product(String sku, String productName, double unitCost, double salePrice, int quantityInStore, int quantityRequired, String specialInstructions) {
        this.sku = sku;
        this.productName = productName;
        this.unitCost = unitCost;
        this.salePrice = salePrice;
        this.quantityInStore = quantityInStore;
        this.quantityRequired = quantityRequired;
        this.specialInstructions = specialInstructions;
    }
    // Get SKU
    public String getSku() {
        return sku;
    }
    // Set SKU
    public final void setSku(String sku) {
        if (sku != null && sku.matches("\\d{8,}")) {
            this.sku = sku;
        } else { // Throw exception
            throw new IllegalArgumentException("SKU has to be 8+ digits");
        }
    }
    // Get Product Name
    public String getProductName() {
        return productName;
    }
    // Set Product Name
    public final void setProductName(String productName) {
        if (productName != null && productName.isEmpty()) {
            this.productName = productName;
        } else { // Throw exception
            throw new IllegalArgumentException("productName cannot be blank");
        }
    }
    // Get Unit Cost
    public double getUnitCost() {
        return unitCost;
    }
    // Set Unit Cost
    public final void setUnitCost(double unitCost) {
        if (unitCost >= 0) {
            this.unitCost = unitCost;
        } else { // Throw exception
            throw new IllegalArgumentException("Unit cost must be 0 or greater");
        }
    }
    // Get Sale Price
    public double getSalePrice() {
        return salePrice;
    }
    // Set Sale Price
    public final void setSalePrice(double salePrice) {
        if (salePrice >= 0) {
            this.salePrice = salePrice;
        } else { // Throw exception
            throw new IllegalArgumentException("Sale price must be 0 or greater");
        }
    }
    // Get Quantity In Store
    public int getQuantityInStore() {
        return quantityInStore;
    }
    // Set Quantity In Store
    public final void setQuantityInStore(int quantityInStore) {
        if (quantityInStore >= 0) {
            this.quantityInStore = quantityInStore;
        } else { // Throw exception
            throw new IllegalArgumentException("Quantity in store must be 0 or greater");
        }
    }
    // Get Quantity Required
    public int getQuantityRequired() {
        return quantityRequired;
    }
    // Set Quantity Required
    public final void setQuantityRequired(int quantityRequired) {
        if (quantityRequired >= 0) {
            this.quantityRequired = quantityRequired;
        } else { // Throw exception
            throw new IllegalArgumentException("Quantity required must be 0 or greater");
        }
    }
    // Get Special Instructions
    public String getSpecialInstructions() {
        return specialInstructions;
    }
    // Set Special Instructions
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }
    // Display function
    public String toString() {
        // Returns formatted display
        return String.format("SKU: %s\nProduct Name: %s\nUnit Cost: $%.2f\nSale Price: $%.2f\nQuantity on hand: %d\nQuantity Needed: %d\nSpecial Instructions: %s",
                sku, productName, unitCost, salePrice, quantityInStore, quantityRequired, specialInstructions);
    }
}
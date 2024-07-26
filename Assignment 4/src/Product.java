/*
Title: Product Class
Name: Karanvir Kooner
Date: 2024-07-26
Purpose:
*/

public class Product {
    private String SKU;
    private String productName;
    private double unitCost;
    private double salePrice;
    private int quantityInStore;
    private int quantityRequired;
    private String specialInstructions;

    // Default constructor
    public Product() {
        this.SKU = "DefaultSKU";
        this.productName = "Default Product";
        this.unitCost = 0.0;
        this.salePrice = 0.0;
        this.quantityInStore = 0;
        this.quantityRequired = 0;
        this.specialInstructions = "None";
    }
    // Parameterized constructor
    public Product(String SKU, String productName, double unitCost, double salePrice, int quantityInStore, int quantityRequired, String specialInstructions) {
        this.SKU = SKU;
        this.productName = productName;
        this.unitCost = unitCost;
        this.salePrice = salePrice;
        this.quantityInStore = quantityInStore;
        this.quantityRequired = quantityRequired;
        this.specialInstructions = specialInstructions;
    }


}
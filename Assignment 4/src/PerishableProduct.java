/*
Title: Perishable Product Class
Name: Karanvir Kooner
Date: 2024-07-26
Purpose: To get and set expiry dates
*/

import java.time.LocalDate;

public class PerishableProduct extends Product {
    // Additional Data Member
    private LocalDate expiryDate;
    // Default Constructor
    public PerishableProduct() {
        super();
        this.expiryDate = LocalDate.now();
    }
    // Parameterized Constructor
    public PerishableProduct(String sku, String productName, double unitCost, double salePrice, int quantityInStore, int quantityRequired, String specialInstructions, LocalDate expiryDate) {
        super(sku, productName, unitCost, salePrice, quantityInStore, quantityRequired, specialInstructions);
        setExpiryDate(expiryDate);
    }
    // Get Expiry Date
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    // Set Expiry Date
    public final void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    // Overrides toString method to include the expiry date
    @Override
    public String toString() {
        return super.toString() + String.format("\nExpiry Date: %s", expiryDate);
    }
}

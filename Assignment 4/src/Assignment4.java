/*
Title: Main Class
Name: Karanvir Kooner
Date: 2024-07-26
Purpose: To simulate the retail store
*/

// Imports
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Assignment4 {
    // Creates a List to store the products
    private static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userOption = 0;
        // Main loop for the menu interface
        do {
            displayMenu();
            try {
                userOption = input.nextInt();
                input.nextLine();
                // Switch cases to respond to the users option
                switch (userOption) {
                    // Case to create a product
                    case 1:
                        createProduct(input);
                        break;
                    // Case to create a perishable product
                    case 2:
                        createPerishableProduct(input);
                        break;
                    // Case to edit a product
                    case 3:
                        editProduct(input);
                        break;
                    // Case to delete a product
                    case 4:
                        deleteProduct(input);
                        break;
                    // Case to display a product
                    case 5:
                        displayProduct(input);
                        break;
                    // Case to display all products
                    case 6:
                        displayAllProducts();
                        break;
                    // Case to exit the program
                    case 7:
                        System.out.println("Bye...");
                        break;
                    default:
                        System.out.println("Invalid! Try Again!");
                }
            } catch (InputMismatchException e) { // Catches wrong input
                System.out.println("Invalid input! Enter another number!");
                input.nextLine();
            }
        } while (userOption != 7); // exits loop if option equals 7
        // Closes scanner
        input.close();
    }
    // Displays the menu
    private static void displayMenu() {
        System.out.println("\n****MENU****");
        System.out.println("1) Create Product");
        System.out.println("2) Create Perishable Product");
        System.out.println("3) Edit Product by SKU");
        System.out.println("4) Delete Product by SKU");
        System.out.println("5) Display Product by SKU");
        System.out.println("6) Display all Products");
        System.out.println("7) Exit");
        System.out.print("Pick a Option: ");
    }
    // Function to create products
    private static void createProduct(Scanner input) {
        // Try catch statement to handle exceptions
        try {
            // Asks for SKU value
            System.out.print("Enter SKU: ");
            String sku = input.nextLine();
            // Asks for Product Name
            System.out.print("Enter Product Name: ");
            String productName = input.nextLine();
            // Asks for Unit Cost
            System.out.print("Enter Unit Cost: ");
            double unitCost = input.nextDouble();
            // Asks for Sale Price
            System.out.print("Enter Sale Price: ");
            double salePrice = input.nextDouble();
            // Asks for quantity in store
            System.out.print("Enter Quantity on hand: ");
            int quantityInStore = input.nextInt();
            // Asks for quantity in need
            System.out.print("Enter Quantity Needed: ");
            int quantityRequired = input.nextInt();
            // Clears scanner
            input.nextLine();
            // Asks for Special Instructions
            System.out.print("Enter Special Instructions: ");
            String specialInstructions = input.nextLine();
            // Adds products to list
            Product product = new Product(sku, productName, unitCost, salePrice, quantityInStore, quantityRequired, specialInstructions);
            productList.add(product);
            System.out.println("Product has been created!");
        } catch (InputMismatchException e) { // Catch exception in wrong type of value
            System.out.println("Invalid Input! Enter the correct type of value!");
            input.nextLine();
        } catch (IllegalArgumentException e) { // Catch exception if value less than 0
            System.out.println(e.getMessage());
        }
    }

    private static void createPerishableProduct(Scanner input) {
        // Try catch statement to handle exceptions
        try {
            // Asks for SKU Value
            System.out.print("Enter SKU: ");
            String sku = input.nextLine();
            // Asks for Product Name
            System.out.print("Enter Product Name: ");
            String productName = input.nextLine();
            // Asks for Unit Cost
            System.out.print("Enter Unit Cost: ");
            double unitCost = input.nextDouble();
            // Asks for Sale Price
            System.out.print("Enter Sale Price: ");
            double salePrice = input.nextDouble();
            // Asks for Quantity on Hand
            System.out.print("Enter Quantity on hand: ");
            int quantityInStore = input.nextInt();
            // Asks for Quantity Needed
            System.out.print("Enter Quantity Needed: ");
            int quantityRequired = input.nextInt();
            input.nextLine(); // Clears Scanner
            // Asks for Special Instructions
            System.out.print("Enter Special Instructions: ");
            String specialInstructions = input.nextLine();
            // Asks for Expiry Date
            System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
            LocalDate expiryDate = LocalDate.parse(input.nextLine());

            PerishableProduct perishableProduct = new PerishableProduct(sku, productName, unitCost, salePrice, quantityInStore, quantityRequired, specialInstructions, expiryDate);
            productList.add(perishableProduct);
            System.out.println("Perishable Product has been created!");
        } catch (InputMismatchException e) { // Catch exception if wrong type of value
            System.out.println("Invalid Input! Enter the correct type of value!");
            input.nextLine();
        } catch (IllegalArgumentException e) { // Catch exception if under 0
            System.out.println(e.getMessage());
        } catch (DateTimeParseException e) { // Catch exception if date formatted wrong
            System.out.println("Invalid Date! Enter the date again (YYYY-MM-DD)!");
        }
    }

    private static void editProduct(Scanner input) {
        // Try catch statement to handle exceptions
        try {
            System.out.print("Enter the SKU of the product you want to edit: ");
            String sku = input.nextLine();
            // Finds product
            Product product = findProductBySku(sku);
            // If Statement to edit products
            if (product != null) {
                System.out.print("Editing Product: " + product);
                System.out.print("\nEnter a new Product Name: ");
                product.setProductName(input.nextLine());
                System.out.print("Enter a new Unit Cost: ");
                product.setUnitCost(input.nextDouble());
                System.out.print("Enter a new Sale Price: ");
                product.setSalePrice(input.nextDouble());
                System.out.print("Enter a new Quantity on hand: ");
                product.setQuantityInStore(input.nextInt());
                System.out.print("Enter a new Quantity Needed: ");
                product.setQuantityRequired(input.nextInt());
                input.nextLine();
                System.out.print("Enter a new set of Special Instructions: ");
                product.setSpecialInstructions(input.nextLine());
                // If statement to change expiry date
                if (product instanceof PerishableProduct) {
                    System.out.print("Enter a new Expiry Date (YYYY-MM-DD): ");
                    LocalDate expiryDate = LocalDate.parse(input.nextLine());
                    ((PerishableProduct) product).setExpiryDate(expiryDate);
                }

                System.out.println("Product Has Been Successfully Edited!");
            } else { // If product isnt found
                System.out.print("Product Could Not Be Found!");
            }
        } catch (InputMismatchException e) { // Catch exception if wrong value type
            System.out.println("Invalid Input! Enter the correct type of value!");
            input.nextLine();
        } catch (IllegalArgumentException e) { // Catch exception if under 0
            System.out.println(e.getMessage());
        } catch (DateTimeParseException e) { // Catch exception if wrongly formatted date
            System.out.println("Invalid Date! Enter the date again (YYYY-MM-DD)!");
        }
    }

    private static void deleteProduct(Scanner input) {
        System.out.print("Enter SKU of the product you would like to delete: ");
        String sku = input.nextLine();
        // Finds product
        Product product = findProductBySku(sku);
        // If Statement to remove the product
        if (product != null) {
            productList.remove(product);
            System.out.println("The Product has been deleted");
        } else { // If product is not found
            System.out.println("Product Could Not Be Found!");
        }
    }

    private static void displayProduct(Scanner input) {
        System.out.print("Enter SKU of the product you would like to display: ");
        String sku = input.nextLine();
        // Finds product
        Product product = findProductBySku(sku);
        // Displays product
        if (product != null) {
            System.out.println(product);
        } else { // If product can not be found
            System.out.println("Product Could Not Be Found!");
        }
    }

    private static void displayAllProducts() {
        // If product list is empty
        if (productList.isEmpty()) {
            System.out.println("There are no products to display!");
        } else { // else displays all products saved
            for (Product product : productList) {
                System.out.println(product);
                System.out.println();
            }
        }
    }
    // To find products
    private static Product findProductBySku(String sku) {
        for (Product product : productList) {
            if (product.getSku().equals(sku)) {
                return product;
            }
        }
        return null;
    }
}

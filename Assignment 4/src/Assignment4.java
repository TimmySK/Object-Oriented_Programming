/*
Title: Main Class
Name: Karanvir Kooner
Date: 2024-07-26
Purpose: To simulate the retail store
*/

// Imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment4 {

    private static List<Product> productList = new ArrayList<>();

    public static void Main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userOption;

        do {
            displayMenu();
            userOption = input.nextInt();
            input.nextLine();

            switch (userOption) {
                case 1:
                    createProduct(input);
                    break;
                case 2:
                    createPerishableProduct(input);
                    break;
                case 3:
                    editProduct(input);
                    break;
                case 4:
                    deleteProduct(input);
                    break;
                case 5:
                    displayProduct(input);
                    break;
                case 6:
                    displayAllProducts();
                    break;
                case 7:
                    System.out.println("Bye...");
                    break;
                default:
                    System.out.println("Invalid! Try Again!");
            }
        } while (userOption != 7);

        input.close();
    }
}

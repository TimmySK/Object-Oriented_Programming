/*
Title: Sieve of Eratosthenes
Name: Karanvir Kooner
Date: 2024-06-14
Purpose: To create a program that will output
the primes numbers according to the upper bound
*/

// importing scanner library
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        // setting up scanner
        Scanner input = new Scanner(System.in);
        // initializing upper bound
        int upperBound = 0;
        // Asks user for upperbound value
        System.out.print("Enter an upper bound (2-1000): ");
        // if statement to verify if the users input is an integer
        if (input.hasNext()){
            // saves users input
            upperBound = input.nextInt();
            // if statement to verify that users input is 2-1000
            if (upperBound >=2 && upperBound <= 1000) {
                // creates a boolean array called prime
                boolean[] prime = new boolean[upperBound + 1];
                // for loop to set all numbers from 2 to upperbound as true
                for (int i = 2; i<= upperBound; i++){
                    // sets numbers as true
                    prime[i] = true;
                }
                // for loop for the sqaure of p as long as it's under the upperbound value
                for (int p = 2; p * p <= upperBound; p++){
                    // if statement to check if p is marked as prime
                    if (prime[p]){
                        // for loop to mark all multiples as false/not prime
                        for (int i = p * p; i <= upperBound; i += p){
                            // sets non-prime numbers as false
                            prime[i] = false;
                        }
                    }
                }
            } else { // Error message for number not being 2-1000
                System.out.println("Error! Number must be 2-1000!");
            }
        } else { // Error message for input not being an integer
            System.out.println("Error! Must be integer!");
        }

    } // end
} // end
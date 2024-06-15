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
        // sets validInput for the while loop to false
        boolean validInput = false;
        // while statement for validation and output
        while (!validInput) {
            // Asks user for upperbound value
            System.out.print("Enter an upper bound (2-1000): ");
            // scans input into a string
            String number = input.next();
            // try statement to validate input as an integer and between 2-1000
            try {
                // parses user input into an integer
                upperBound = Integer.parseInt(number);
                // if statement to check if upper bound if between 2-1000
                if (upperBound >= 2 && upperBound <= 1000) {
                    validInput = true;
                } else { // else statement to send user a error if not 2-1000
                    System.out.println("ERROR! NUMBER MUST BE 2-1000");
                }
            } catch (NumberFormatException e) { // Catch statement to send user an error
                // prints error message
                System.out.println("ERROR! INVALID INTEGER");
            }
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
            // prints header for output
            System.out.println("These are the prime numbers within the range of " + upperBound + ":");
            // for loop to continue printing results till upperbound is meet
            for (int i = 2; i<= upperBound; i++) {
                // if statement to print all true values
                if (prime[i]){
                    // prints prime numbers
                    System.out.print(i + " ");
                }
            }
        }
    } // end
} // end
/*
Title: Random number guesser
Name: Karanvir Kooner
Date: 2024-05-24
Purpose: To familiarize myself with importing libraries and using them, as well as making while loops
*/

//importing random library
import java.util.Random;
//importing scanner library
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Setting up scanner
        Scanner sc = new Scanner(System.in);
        //Setting up random
        Random rand = new Random();
        //Generating a random number
        int randomNum = rand.nextInt(10);
        //Creating attempts tally
        int attempts = 0;
        //Setting win to false
        boolean win = false;
        //Creating while loop for guessing game
        while (win == false) {
            //Getting input from user
            System.out.println("Guess the number: ");
            //Storing input
            int guess = sc.nextInt();
            //Adding attempts per input
            attempts++;
            //If statement for users correct guess
            if (guess == randomNum) {
                //Sets win to true
                win = true;
            }
            //Else if statement for users guess being too low
            else if (guess < randomNum) {
                //Tells user their guess was too low
                System.out.println("Your guess is too low!");
            }
            //Else if statement for users guess being too high
            else if (guess > randomNum) {
                //Tells user their guess was too high
                System.out.println("Your guess is too high!");
            }
        }
        //Prints users results
        System.out.println("YOU WON!");
        System.out.println("-----Results-----");
        System.out.println("The number was " + randomNum);
        System.out.println("It took you " + attempts + " attempts");
    }
}
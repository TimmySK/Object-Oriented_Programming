/*
Title: Scoring for Bowling
Name: Karanvir Kooner
Date: 2024-07-04
Purpose: To create a scoring program
for bowling
*/

// importing scanner library
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        // Setting up Scanner
        Scanner input = new Scanner(System.in);
        // Asking user for playerName
        System.out.print("What is your name?: ");
        // Collect playerName
        String playerName = input.nextLine();
        // Testing getRoll func
        int score = getRoll(playerName);
        System.out.println("---" + playerName + "---\nScore: " + score);

    } // end

    public static int getRoll(String playerName) {
        // Setting up Scanner
        Scanner input = new Scanner(System.in);
        // Setting boolean validInput to false
        boolean validInput = false;
        // Initializing score as 0
        int score = 0;

        // While loop for validation
        while (!validInput) {
            // Asks user for players score
            System.out.print("How much did " + playerName + " score?: ");
            // If statement for validating a integer input
            if (input.hasNextInt()) {
                // Stores the players score in the variable if check passed
                score = input.nextInt();
                // If statement to make sure users input is within range
                if (score >=0 && score <= 10) {
                    // Breaks while loop if valid
                    validInput = true;
                } else { // error message for not being in range
                    System.out.println("Invalid input! Must be 0-10.");
                }
            } else { // error message for not being integer
                System.out.println("Invalid input! Please try again.");
                // Clears the valid input
                input.next();
            }
        }
        // Closes input scanner
        input.close();
        // Returns score
        return score;
    }

    public static int getTurnScores() {

    }

    public static int[] getGameScores() {

    }
} // end
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
        System.out.print("Enter player 1s name: ");
        // Collect player1Name
        String player1Name = input.nextLine();
        // Asking user for playerName
        System.out.print("Enter player 2s name: ");
        // Collect player2Name
        String player2Name = input.nextLine();
        // Testing getTurnScores func
        int scorePlayer1 = getTurnScores(player1Name);
        System.out.println("---" + player1Name + "---\nScore: " + scorePlayer1);

        int scorePlayer2 = getTurnScores(player2Name);
        System.out.println("---" + player2Name + "---\nScore: " + scorePlayer2);

    } // end

    public static int getRoll(String playerName, int frame, int roll) {
        // Setting up Scanner
        Scanner input = new Scanner(System.in);
        // Setting boolean validInput to false
        boolean validInput = false;
        // Initializing score as 0
        int score = 0;

        // While loop for validation
        while (!validInput) {
            // Asks user for players score
            System.out.print(playerName + "s score in Frame " + frame + ", Roll " + roll + ": ");
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
        // Returns score
        return score;
    }

    public static int getTurnScores(String playerName) {
        // initialize totalScore as 0
        int totalScore = 0;
        // For loop to iterate through the frames
        for (int frame = 1; frame <= 10; frame++) {
            // prints a header for the frame
            System.out.println("---Frame " + frame + "---");
            // score1 stores the valid score input in the getRoll function
            int score1 = getRoll(playerName, frame, 1);
            // score1 gets added to the players totalScore
            totalScore += score1;
            // Checks if the player hit a strike
            if (score1 == 10) {
                // Displays strike message
                System.out.println("STRIKE🎳");
                // score2 stores the valid score input in the getRoll function
                int score2 = getRoll(playerName, frame, 2);
                // score2 gets added to the players totalScore
                totalScore += score2;
                // If statement for double strike
                if (score2 == 10) {
                    // Displays double strike message
                    System.out.println("🎳Double Strike🎳");
                    // score3 stores the valid score input in the getRoll function
                    int score3 = getRoll(playerName, frame, 3);
                    // score3 gets added to the players totalScore
                    totalScore += score3;
                    // If statement for three strikes
                    if (score3 == 10){
                        // Displays turkey message
                        System.out.println("TURKEY🦃");
                    }
                }
            } else { // if not a strike continues like normal
                int score2 = getRoll(playerName, frame, 2);
                // score2 gets added to totalScore
                totalScore += score2;
                // If statement in case of spare
                if (score1 + score2 == 10){
                    // Displays spare message
                    System.out.println("Spare!!!");
                    // Allows for an extra roll
                    totalScore += getRoll(playerName, frame, 3);
                }
            }
        }
        // Returns totalScore
        return totalScore;
    }


} // end
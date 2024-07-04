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
        // Calculates scores for Player 1
        int[] player1Scores = getGameScores(player1Name);
        // Calculates scores for Player 2
        int[] player2Scores = getGameScores(player2Name);
        // Making the table
        System.out.println("\nResults:");
        System.out.print("Frame: ");
        // For loop prints 1-10
        for (int frame = 1; frame <=10; frame++) {
            System.out.print(frame + " ");
        }
        // For loop prints the players scores each frame
        System.out.print("\n" + player1Name + ": ");
        for (int score : player1Scores) {
            System.out.print(score + " ");
        }
        // For loop prints the player scores each frame
        System.out.print("\n" + player2Name + ": ");
        for (int score : player2Scores) {
            System.out.print(score + " ");
        }
        // Initializes player1TotalScore to 0
        int player1TotalScore = 0;
        // Initializes player2TotalScore to 0
        int player2TotalScore = 0;
        // For loop gets the total score
        for (int score : player1Scores) {
            player1TotalScore += score;
        }
        // For loop gets the total score
        for (int score : player2Scores) {
            player2TotalScore += score;
        }
        // Displays total scores
        System.out.println("\n\nTotal Scores:");
        System.out.println(player1Name + ": " + player1TotalScore);
        System.out.println(player2Name + ": " + player2TotalScore);
        // Winner/tie displays
        if (player1TotalScore > player2TotalScore) {
            System.out.println("\nWinner: " + player1Name);
        } else if (player2TotalScore > player1TotalScore) {
            System.out.println("\nWinner: " + player2Name);
        } else {
            System.out.println("\nTie!");
        }
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
            System.out.print("Roll " + roll + ": ");
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

    public static int getTurnScores(String playerName, int frame) {
        // initializing totalScore as 0
        int totalScore = 0;
        // Display header for the frames
        System.out.println("---" + playerName + " Frame " + frame + "---");
        // score1 stores valid score from getRoll function
        int score1 = getRoll(playerName, frame, 1);
        // score1 is added to totalScore
        totalScore += score1;
        // If statement in case of a strike
        if (score1 == 10) {
            // Displays strike message
            System.out.println("Strike🎳");
            // score2 stores valid score from getRoll function
            int score2 = getRoll(playerName, frame, 2);
            // score2 is added to totalScore
            totalScore += score2;
            // If statement in case of double strike
            if (score2 == 10) {
                // Displays strike message
                System.out.println("🎳Double Strike🎳");
                // score3 stores a valid score from getRoll function
                int score3 = getRoll(playerName, frame, 3);
                // score3 is added to totalScore
                totalScore += score3;
                // If statement in case of three strikes resulting in turkey
                if (score3 == 10) {
                    // Displays turkey message
                    System.out.println("Turkey🦃");
                }
            }
        } else { // Else statement to continue on if no strike
            // score2 store valid score from getRoll function
            int score2 = getRoll(playerName, frame, 2);
            // score2 is added to totalScore
            totalScore += score2;
            // If statement in case of a spare
            if (score1 + score2 == 10) {
                // Displays spare message
                System.out.println("Spare!");
                // third roll gets added to totalScore
                totalScore += getRoll(playerName, frame, 3);
            }
        }
        // Returns totalScore
        return totalScore;
    }

    public static int[] getGameScores(String playerName) {
        // Makes an array called frameScores with a range of 10
        int [] frameScores = new int[10];
        // For loops to iterate through the array
        for (int frame = 1; frame <=10; frame++) {
            // Stores total score of the frame in the array
            frameScores[frame - 1] = getTurnScores(playerName, frame);
        }
        // Return frameScores
        return frameScores;
    }
} // end
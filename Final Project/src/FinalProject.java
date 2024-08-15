import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalProject extends JFrame {
    // Text fields for player names
    private JTextField player1Field, player2Field;
    // 2D array of text fields for entering scores
    private JTextField[][] scoreFields;
    // Label to display the result
    private JLabel resultLabel;
    // Instance of the BowlingGame class to manage game logic
    private BowlingGame game;

    public FinalProject() {
        // Set up the main frame
        setTitle("Bowling Score Calculator");
        setSize(800, 400); // Size of the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for entering player names
        JPanel playerPanel = new JPanel(new GridLayout(2, 2));
        playerPanel.add(new JLabel("Player 1:"));
        player1Field = new JTextField(); // Text field for Player 1 name
        playerPanel.add(player1Field);

        playerPanel.add(new JLabel("Player 2:"));
        player2Field = new JTextField(); // Text field for Player 2 name
        playerPanel.add(player2Field);
        add(playerPanel, BorderLayout.NORTH); // Add playerPanel to the top of the frame

        // Panel for entering scores
        JPanel scorePanel = new JPanel(new GridLayout(2, 11)); // 2 rows (one for each player) and 11 columns (10 frames + extra)
        scoreFields = new JTextField[2][21]; // 2 players, 21 fields (including extra rolls)
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 21; j++) {
                scoreFields[i][j] = new JTextField(); // Create a text field for each score entry
                scorePanel.add(scoreFields[i][j]); // Add text field to scorePanel
            }
        }
        add(scorePanel, BorderLayout.CENTER); // Add scorePanel to the center of the frame

        // Panel for buttons and result display
        JPanel buttonPanel = new JPanel(new BorderLayout());

        // Calculate Scores button
        JButton calculateButton = new JButton("Calculate Scores");
        buttonPanel.add(calculateButton, BorderLayout.NORTH); // Add button to the top of buttonPanel

        // Result label to display the game outcome
        resultLabel = new JLabel("Result: ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center-align the text
        buttonPanel.add(resultLabel, BorderLayout.SOUTH); // Add result label to the bottom of buttonPanel

        add(buttonPanel, BorderLayout.SOUTH); // Add buttonPanel to the bottom of the frame

        // Action listener for the Calculate Scores button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get player names from text fields
                String player1Name = player1Field.getText();
                String player2Name = player2Field.getText();
                game = new BowlingGame(player1Name, player2Name); // Initialize the game with player names

                // Loop through frames to get scores for each frame
                for (int frame = 0; frame < 10; frame++) {
                    int roll1 = parseInput(scoreFields[0][frame].getText()); // Get roll 1 for Player 1
                    int roll2 = frame < 9 ? parseInput(scoreFields[0][frame + 10].getText()) : 0; // Get roll 2 for Player 1
                    game.addRoll(0, frame, roll1, roll2); // Add rolls to the game for Player 1

                    roll1 = parseInput(scoreFields[1][frame].getText()); // Get roll 1 for Player 2
                    roll2 = frame < 9 ? parseInput(scoreFields[1][frame + 10].getText()) : 0; // Get roll 2 for Player 2
                    game.addRoll(1, frame, roll1, roll2); // Add rolls to the game for Player 2
                }

                // Handle extra rolls in the 10th frame
                if (game.isExtraRollAllowed(0, 9)) {
                    int roll1 = parseInput(scoreFields[0][20].getText()); // Get extra roll for Player 1
                    game.addExtraRoll(0, roll1); // Add extra roll to the game for Player 1
                }

                if (game.isExtraRollAllowed(1, 9)) {
                    int roll1 = parseInput(scoreFields[1][20].getText()); // Get extra roll for Player 2
                    game.addExtraRoll(1, roll1); // Add extra roll to the game for Player 2
                }

                game.calculateFinalScores(); // Calculate final scores for both players
                resultLabel.setText(game.getWinner()); // Display the winner
            }
        });

        setVisible(true); // Make the frame visible
    }

    // Helper method to parse input from text fields
    private int parseInput(String input) {
        try {
            return Integer.parseInt(input); // Convert input to integer
        } catch (NumberFormatException e) {
            return 0; // Default to 0 if input is invalid
        }
    }

    public static void main(String[] args) {
        new FinalProject(); // Create and display the GUI
    }
}

// Class representing a player in the game
class Player {
    private String name;
    private int[] rolls = new int[21]; // Array to store rolls (10 frames + extra rolls)
    private int currentRoll = 0; // Index for the next roll

    public Player(String name) {
        this.name = name;
    }

    // Add a roll to the player's score
    public void addRoll(int pins) {
        rolls[currentRoll++] = pins;
    }

    // Calculate the player's total score
    public int getScore() {
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) { // Strike
                score += 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
                rollIndex++;
            } else if (isSpare(rollIndex)) { // Spare
                score += 10 + rolls[rollIndex + 2];
                rollIndex += 2;
            } else { // Open frame
                score += rolls[rollIndex] + rolls[rollIndex + 1];
                rollIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10; // Check if the roll is a strike
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10; // Check if the roll is a spare
    }

    public String getName() {
        return name;
    }

    public int getCurrentRoll() {
        return currentRoll;
    }

    public int getRoll(int rollIndex) {
        return rolls[rollIndex];
    }
}

// Class to manage the bowling game
class BowlingGame {
    private Player[] players = new Player[2]; // Two players in the game

    public BowlingGame(String player1Name, String player2Name) {
        players[0] = new Player(player1Name);
        players[1] = new Player(player2Name);
    }

    // Add rolls for a given player and frame
    public void addRoll(int playerIndex, int frame, int roll1, int roll2) {
        players[playerIndex].addRoll(roll1);
        if (roll1 != 10 || frame == 9) { // No second roll if it's a strike (except in the 10th frame)
            players[playerIndex].addRoll(roll2);
        }
    }

    // Add an extra roll for a player if needed
    public void addExtraRoll(int playerIndex, int roll) {
        players[playerIndex].addRoll(roll);
    }

    // Check if an extra roll is allowed in the 10th frame
    public boolean isExtraRollAllowed(int playerIndex, int frame) {
        if (frame < 9) return false;
        Player player = players[playerIndex];
        return player.getCurrentRoll() == 18 && (player.getRoll(18) == 10 || player.getRoll(18) + player.getRoll(19) == 10);
    }

    // Calculate final scores for the game
    public void calculateFinalScores() {
        // Calculation done within Player class
    }

    // Determine the winner of the game
    public String getWinner() {
        int p1Total = players[0].getScore();
        int p2Total = players[1].getScore();

        if (p1Total > p2Total) {
            return players[0].getName() + " wins with " + p1Total + " points!";
        } else if (p2Total > p1Total) {
            return players[1].getName() + " wins with " + p2Total + " points!";
        } else {
            return "It's a tie!";
        }
    }
}

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * author : - rohit
 */
package group_4_project;

import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 */
public class Game {
    private String playerName;
    private int playerScore;
    private int dealerScore;
    private GroupOfCards deck;

    public Game(String playerName) {
        this.playerName = playerName;
        this.playerScore = 0;
        this.dealerScore = 0;
        this.deck = new GroupOfCards(); // Aggregation
    }

    // Start the game
    public void start() {
        System.out.println("Welcome to the game, " + playerName + "!");
        playGame();
    }

    /**
     * Handles the game logic with four rounds.
     * Calculates and compares scores at the end.
     */
    private void playGame() {
        Scanner scanner = new Scanner(System.in);
        int roundsPlayed = 0;

        while (roundsPlayed < 4) { // Play four rounds
            System.out.println("\nRound " + (roundsPlayed + 1));

            // Player's Turn
            Card playerCard = deck.draw();
            playerScore += playerCard.getValue();
            System.out.println("You drew: " + playerCard);
            System.out.println("Your total score: " + playerScore);

            // Dealer's Turn
            Card dealerCard = deck.draw();
            dealerScore += dealerCard.getValue();
            System.out.println("Dealer drew: " + dealerCard);
            System.out.println("Dealer's total score: " + dealerScore);

            roundsPlayed++;
        }

        // Final Scores
        System.out.println("\nGame Over! Final Scores:");
        System.out.println(playerName + ": " + playerScore);
        System.out.println("Dealer: " + dealerScore);

        // Determine Winner
        if (playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie!");
        }
    }

    // Encapsulation: Add getter methods
    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getDealerScore() {
        return dealerScore;
    }

    public GroupOfCards getDeck() {
        return deck;
    }
}
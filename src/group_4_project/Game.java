package group_4_project;

import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 */
public class Game {
    private Player player;
    private Player dealer;
    private GroupOfCards deck;

    public Game(String playerName) {
        this.player = new Player(playerName);
        this.dealer = new Player("Dealer");
        this.deck = new GroupOfCards(); // Aggregation
    }

    // Start the game
    public void start() {
        System.out.println("Welcome to the game, " + player.getName() + "!");
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
            player.drawCard(playerCard);
            System.out.println(player.getName() + " drew: " + playerCard);
            System.out.println(player);

            // Dealer's Turn
            Card dealerCard = deck.draw();
            dealer.drawCard(dealerCard);
            System.out.println(dealer.getName() + " drew: " + dealerCard);
            System.out.println(dealer);

            roundsPlayed++;
        }

        // Final Scores
        System.out.println("\nGame Over! Final Scores:");
        System.out.println(player);
        System.out.println(dealer);

        // Determine Winner
        if (player.getScore() > dealer.getScore()) {
            System.out.println(player.getName() + " wins!");
        } else if (player.getScore() < dealer.getScore()) {
            System.out.println(dealer.getName() + " wins.");
        } else {
            System.out.println("It's a tie!");
        }
    }
}

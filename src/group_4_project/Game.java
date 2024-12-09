package group_4_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Game Class:
 * - **Single Responsibility Principle (SRP)**:
 *   - The class is solely responsible for handling the game mechanics, such as rounds, score tracking, and result determination.
 * - **Observer Pattern**:
 *   - Implements a notification system to inform observers of score changes.
 *   - This decouples score updates from their effects, enhancing modularity.
 * - **Composition**:
 *   - Uses a `GroupOfCards` object to handle the deck, demonstrating "has-a" relationship.
 * - **High Cohesion**:
 *   - All methods contribute directly to the functionality of managing the game.
 * - **Low Coupling**:
 *   - Delegates responsibilities to other classes like `GroupOfCards` and `ScoreObserver`, ensuring minimal dependencies.
 */
public class Game {
    private final String playerName;
    private final GroupOfCards deck; // Game "has a" GroupOfCards
    private final List<ScoreObserver> observers; // Observers for score changes
    private int playerScore; // Player's current score
    private int dealerScore; // Dealer's current score

    /**
     * Constructor:
     * - Initializes the game with the player's name.
     * - Creates a new deck and observer list.
     * 
     * @param playerName Name of the player.
     */
    public Game(String playerName) {
        this.playerName = playerName;
        this.deck = new GroupOfCards(); // Composition
        this.observers = new ArrayList<>();
        this.playerScore = 0;
        this.dealerScore = 0;
    }

    /**
     * Adds a score observer to the list.
     * - Allows external classes to observe score changes.
     * 
     * @param observer The observer to be added.
     */
    public void addObserver(ScoreObserver observer) {
        observers.add(observer);
    }

    /**
     * Notifies all registered observers of a score change.
     * - Implements the Observer Pattern.
     * 
     * @param name The name of the player whose score changed.
     * @param score The updated score.
     */
    private void notifyObservers(String name, int score) {
        for (ScoreObserver observer : observers) {
            observer.onScoreChange(name, score); // Decoupled notification
        }
    }

    /**
     * Starts the game by greeting the player and initiating gameplay.
     */
    public void start() {
        System.out.println("Welcome to the game, " + playerName + "!");
        playGame();
    }

    /**
     * Manages the gameplay logic, including drawing cards and calculating scores.
     * - Follows High Cohesion: Manages rounds and score updates.
     */
    private void playGame() {
        Scanner scanner = new Scanner(System.in);
        int roundsPlayed = 0;

        // Loop for a predefined number of rounds (4)
        while (roundsPlayed < 4) {
            System.out.println("\nRound " + (roundsPlayed + 1));

            // Player's Turn
            Card playerCard = deck.draw(); // Draw a card for the player
            playerScore += playerCard.getValue(); // Update score
            notifyObservers(playerName, playerScore); // Notify observers
            System.out.println("You drew: " + playerCard);
            System.out.println("Your total score: " + playerScore);

            // Dealer's Turn
            Card dealerCard = deck.draw(); // Draw a card for the dealer
            dealerScore += dealerCard.getValue(); // Update dealer's score
            System.out.println("Dealer drew: " + dealerCard);
            System.out.println("Dealer's total score: " + dealerScore);

            roundsPlayed++; // Increment rounds
        }

        // Display final results
        displayResults();
    }

    /**
     * Displays the final scores and announces the winner.
     */
    private void displayResults() {
        System.out.println("\nGame Over! Final Scores:");
        System.out.println(playerName + ": " + playerScore);
        System.out.println("Dealer: " + dealerScore);

        // Determine the winner
        if (playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie!");
        }
    }
}

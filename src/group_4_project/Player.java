package group_4_project;

import java.util.ArrayList;
import java.util.List;

/**
 * Player Class:
 * - **Design Principle: Single Responsibility Principle (SRP)**
 *   - This class focuses solely on managing player-related data and behaviors, such as their name, score, hand of cards, and related operations.
 * - **Design Principle: Encapsulation**
 *   - The player's name, score, and hand are private fields, with public getter methods and controlled access via specific methods.
 * - **Design Principle: Information Hiding**
 *   - Internal details, such as how the score or hand is managed, are hidden from other classes, ensuring a clear interface.
 * - **Design Principle: Cohesion**
 *   - All methods in this class are directly related to managing a player's state or behavior, resulting in high cohesion.
 */
public class Player {
    private String name; // Encapsulation: Private field for player's name
    private int score; // Encapsulation: Private field for player's score
    private List<Card> hand; // Encapsulation: Private field for player's hand of cards

    /**
     * Constructor for the Player class.
     * 
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name; // Assigning the player's name
        this.score = 0; // Initializing score to zero
        this.hand = new ArrayList<>(); // Initializing an empty hand
    }

    /**
     * Gets the player's name.
     * 
     * @return The player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's current score.
     * 
     * @return The player's score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Adds a card to the player's hand and updates the score accordingly.
     * 
     * @param card The card to be added.
     */
    public void drawCard(Card card) {
        hand.add(card); // Adding card to the player's hand
        addScore(card.getValue()); // Updating the player's score based on card value
    }

    /**
     * Updates the player's score by adding the given value.
     * 
     * @param value The value to add to the player's score.
     */
    public void addScore(int value) {
        score += value; // Incrementing the player's score
    }

    /**
     * Resets the player's score and clears their hand.
     */
    public void resetScore() {
        score = 0; // Resetting the score to zero
        hand.clear(); // Clearing the player's hand
    }

    /**
     * Provides a string representation of the player's current state.
     * 
     * @return A string displaying the player's name, score, and hand.
     */
    @Override
    public String toString() {
        return name + "'s score: " + score + ", Cards: " + hand;
    }
}

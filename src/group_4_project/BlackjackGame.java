/*
 * BlackjackGame Class:
 * - Inherits from the Game class to promote **Inheritance** for code reuse.
 * - Adheres to the **Open-Closed Principle**, allowing extension of the Game class without modification.
 */
package group_4_project;

/**
 * A specialized version of the Game class for Blackjack.
 */
public class BlackjackGame extends Game {

    /**
     * Constructor:
     * Delegates initialization to the superclass Game.
     *
     * @param playerName The name of the player.
     */
    public BlackjackGame(String playerName) {
        super(playerName); // Call the superclass constructor
    }
}

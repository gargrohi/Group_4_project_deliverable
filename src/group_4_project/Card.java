package group_4_project;

/**
 * Card Class:
 * - **Single Responsibility Principle (SRP)**:
 *   - This class is solely responsible for managing the properties and behaviors of a card.
 *   - It doesn't manage any game state or logic beyond the card itself, which keeps it focused and simple.
 * - **Encapsulation**:
 *   - Card details (such as suit, rank, and value) are kept private and can only be accessed via getters. 
 *   - This protects the internal state of the card and ensures that it is not directly modified.
 */
public class Card {
    private final int suit; // 0: Hearts, 1: Diamonds, 2: Clubs, 3: Spades
    private final int rank; // 1-13, where 1 is Ace and 13 is King
    private final int value; // Value used for game scoring, face cards (Jack, Queen, King) are worth 10

    /**
     * Constructor:
     * Creates a Card object with the given suit and rank.
     * The value of the card is calculated based on game rules: 
     * face cards (Jack, Queen, King) are all worth 10, while others take their rank value.
     * 
     * @param suit Suit of the card (0: Hearts, 1: Diamonds, 2: Clubs, 3: Spades).
     * @param rank Rank of the card (1-13).
     */
    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = Math.min(rank, 10); // Face cards (11, 12, 13) are assigned a value of 10
    }

    /**
     * Gets the value of the card, used for scoring.
     * 
     * @return The value of the card (face cards are treated as 10).
     */
    public int getValue() {
        return value;
    }

    /**
     * Provides a string representation of the card in a user-friendly format.
     * Displays the rank (Ace, 2-10, Jack, Queen, King) and the suit (Hearts, Diamonds, Clubs, Spades).
     * 
     * @return A string description of the card, such as "Ace of Hearts".
     */
    @Override
    public String toString() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        return ranks[rank - 1] + " of " + suits[suit];
    }
}

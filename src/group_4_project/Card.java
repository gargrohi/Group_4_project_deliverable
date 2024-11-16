/**
 * SYST 17796 Project Base code.
 * Modify and extend to implement their game.
 */
package group_4_project;

/**
 * A class to be used as the base Card class for the project. 
 * Must be general enough to be instantiated for any Cardgame. 
 *
 */
public class Card {
    private int suit; // 0: Hearts, 1: Diamonds, 2: Clubs, 3: Spades
    private int rank; // 1-13
    private int value;

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = (rank > 10) ? 10 : rank; // Face cards have a value of 10
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        return ranks[rank - 1] + " of " + suits[suit];
    }
}

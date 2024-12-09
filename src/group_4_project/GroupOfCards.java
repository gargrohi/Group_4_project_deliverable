/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Author: Rohit
 */
package group_4_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * GroupOfCards Class:
 * - **Design Pattern: Factory Pattern**
 *   - The `CardFactory` is used to create instances of `Card` objects. 
 *     This encapsulates the card creation process and adheres to the 
 *     Factory Pattern, ensuring that the logic for creating cards is centralized.
 * - **Design Principle: Single Responsibility Principle (SRP)**
 *   - This class is responsible only for managing a collection of cards (deck) 
 *     and providing functionality to initialize, shuffle, and draw cards.
 *   - It does not handle game logic or card-specific behavior, which keeps its responsibilities focused.
 * - **Design Principle: Encapsulation**
 *   - The `cards` list is private, ensuring that direct access is restricted.
 *     All modifications to the deck are done through controlled methods 
 *     (`initializeDeck` and `draw`), maintaining the integrity of the data.
 * - **Design Principle: Open-Closed Principle**
 *   - The class is open for extension (e.g., adding new types of decks) 
 *     but closed for modification as the core functionality is modular and reusable.
 */
public class GroupOfCards {
    private final List<Card> cards; // Encapsulation: Deck of cards managed internally

    /**
     * Constructor:
     * Initializes an empty deck and populates it using `initializeDeck`.
     */
    public GroupOfCards() {
        this.cards = new ArrayList<>();
        initializeDeck(); // Initializes and shuffles the deck
    }

    /**
     * Initializes the deck with 52 cards and shuffles them.
     * - Factory Pattern: Uses the `CardFactory` to create card instances.
     */
    private void initializeDeck() {
        for (int suit = 0; suit < 4; suit++) { // 0: Hearts, 1: Diamonds, 2: Clubs, 3: Spades
            for (int rank = 1; rank <= 13; rank++) { // 1-13: Ace to King
                cards.add(CardFactory.createCard(suit, rank)); // Factory Pattern in action
            }
        }
        Collections.shuffle(cards); // Randomizes card order
    }

    /**
     * Draws a card from the deck.
     * - Ensures the deck is not empty before attempting to draw a card.
     * 
     * @return The top card of the deck.
     * @throws IllegalStateException if the deck is empty.
     */
    public Card draw() {
        if (cards.isEmpty()) { // Encapsulation: Direct access to cards is restricted
            throw new IllegalStateException("The deck is empty!");
        }
        return cards.remove(0); // Removes and returns the top card
    }
}

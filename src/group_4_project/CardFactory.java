package group_4_project;

/**
 * CardFactory Class:
 * - **Factory Method Pattern**:
 *   - Centralizes the creation of `Card` objects, abstracting the complexity of initialization from client code.
 *   - Clients can request cards without needing to know the specifics of how the objects are created.
 * - **Single Responsibility Principle (SRP)**:
 *   - The sole purpose of this class is to create `Card` objects. It does not manage or alter any other game logic or state.
 * - **Encapsulation**:
 *   - Hides the internal details of `Card` object creation, ensuring that clients interact only through this factory method. 
 *   - Clients cannot access or alter the internal initialization details, thus protecting the integrity of the `Card` object.
 */
public class CardFactory {
    /**
     * Creates a card with the specified suit and rank.
     * - This method abstracts the card creation process, centralizing it in one place.
     * - It allows the flexibility to change the card creation logic in the future without affecting client code.
     * 
     * @param suit The suit of the card (0: Hearts, 1: Diamonds, 2: Clubs, 3: Spades).
     * @param rank The rank of the card (1-13, where 1 is Ace and 13 is King).
     * @return A Card object with the specified attributes (suit and rank).
     */
    public static Card createCard(int suit, int rank) {
        // Factory Method: Abstracts the complexity of creating a Card object.
        return new Card(suit, rank); // Card creation is now centralized in this method.
    }
}

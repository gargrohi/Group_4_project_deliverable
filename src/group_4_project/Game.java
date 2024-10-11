/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package group_4_project;

import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 */
public class Game { // Defines the Game class, which models the overall game logic.
    private String playerName;
    private int playerScore;
    private int dealerScore;
    private GroupOfCards deck;

    public Game(String playerName) {
        this.playerName = playerName;
        this.playerScore = 0;
        this.dealerScore = 0;
        this.deck = new GroupOfCards(); // Initialize the deck
    }
//it is the method to start the game
    public void start() {
        System.out.println("Welcome to Blackjack, " + playerName + "!");
        playGame();
    }

    private void playGame() {
        // Draw two cards for the player from the deck  and it will claculate the both player card score and print in the output box
        Card playerCard1 = deck.draw();
        Card playerCard2 = deck.draw();
        playerScore = playerCard1.getValue() + playerCard2.getValue();
        System.out.println("Your cards: " + playerCard1 + ", " + playerCard2);
        System.out.println("Your score: " + playerScore);

        // Draw two cards for the dealer from the deck  and it will claculate the both delaer card score and print in the output box
        Card dealerCard1 = deck.draw();
        Card dealerCard2 = deck.draw();
        dealerScore = dealerCard1.getValue() + dealerCard2.getValue();
        System.out.println("Dealer's cards: " + dealerCard1 + ", " + dealerCard2);
        System.out.println("Dealer's score: " + dealerScore);

        // Player's turn
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to hit (h) or stand (s)? ");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("h")) {
                Card newCard = deck.draw();
                playerScore += newCard.getValue();
                System.out.println("You drew: " + newCard);
                System.out.println("Your new score: " + playerScore);

                if (playerScore > 21) {
                    System.out.println("You bust! Dealer wins.");
                    return;
                }
            } else if (action.equalsIgnoreCase("s")) {
                break;
            } else {
                System.out.println("Invalid input, please enter 'h' or 's'.");
            }
        }

        // Dealer's turn
        while (dealerScore < 17) {
            Card newCard = deck.draw();
            dealerScore += newCard.getValue();
            System.out.println("Dealer drew: " + newCard);
            System.out.println("Dealer's new score: " + dealerScore);
        }

        // Determine the winner
        if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

}
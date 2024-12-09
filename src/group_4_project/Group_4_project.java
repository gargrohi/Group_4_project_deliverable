/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package group_4_project;

import java.util.Scanner;

/**
 * Group_4_project Class:
 * - **Design Principle: Single Responsibility Principle (SRP)**
 *   - This class acts as the entry point for the application. Its sole responsibility 
 *     is to initialize the game by accepting player input and starting the game process.
 * - **Design Principle: Encapsulation**
 *   - The game logic and functionality are encapsulated within the `Game` class. 
 *     This class delegates game-related tasks to `Game` while focusing only on setting up the player.
 * - **Design Principle: Separation of Concerns**
 *   - This class handles user interaction (input) and delegates the core game mechanics to the `Game` class.
 * - **Design Principle: Dependency Injection**
 *   - The player's name is passed to the `Game` class via its constructor, 
 *     which promotes reusability and flexibility by decoupling dependencies.
 */
public class Group_4_project {

    /**
     * The main method serves as the entry point for the application.
     * It collects the player's name and starts the game.
     * 
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Encapsulation: Scanner instance for user input

        // Prompting the player for their name
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine(); // Collecting player input

        // Initializing the game with the player's name
        Game game = new Game(playerName); // Dependency Injection: Passing playerName to Game class
        game.start(); // Starting the game
    }
}

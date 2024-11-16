/**
 * SYST 17796 Project Base code.
 * modify and extend to implement their game.
 * author : - rohit
 */
package group_4_project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 */
public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int value) {
        score += value;
    }

    public void resetScore() {
        score = 0;
    }
}


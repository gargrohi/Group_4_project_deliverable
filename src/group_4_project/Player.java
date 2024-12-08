package group_4_project;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 */
public class Player {
    private String name;
    private int score;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void drawCard(Card card) {
        hand.add(card);
        addScore(card.getValue());
    }

    public void addScore(int value) {
        score += value;
    }

    public void resetScore() {
        score = 0;
        hand.clear();
    }

    @Override
    public String toString() {
        return name + "'s score: " + score + ", Cards: " + hand;
    }
}

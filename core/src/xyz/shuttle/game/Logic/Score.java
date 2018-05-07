package xyz.shuttle.game.Logic;

/**
 * @author Shuttle on 6/04/18.
 */
public class Score {
    private int score;

    public void decrease(int power) {
        score -= power;
        if (score < 0) {
            score = 0;
        }
    }

    public void increment() {
        ++score;
    }

    public void initScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }
}

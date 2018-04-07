package xyz.shuttle.game.Logic;

/**
 * @author Shuttle on 6/04/18.
 */

public class Score {
    private int score;

    public int getScore() {
        return score;
    }

    public void nextScore(){
        ++score;
    }

    public int decreaseAndGet(int power){
        score -= power;
        if (score < 0 ){
            score = 0;
        }
        return  score;
    }

    public void initScore(){
        score = 0;
    }
}

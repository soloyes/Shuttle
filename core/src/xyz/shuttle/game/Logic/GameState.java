package xyz.shuttle.game.Logic;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Shuttle on 6/04/18.
 */

public class GameState {
    private Score score;
    private Lives lives;
    private State state;

    private StringBuilder sbScore;
    private StringBuilder sbGameOver;

    private Vector2 zeroVector = new Vector2(0.0f, 0.0f);

    public Lives getLives() { return lives; }

    public void setGameOver() {
        this.state = State.GAMEOVER;
    }

    public boolean isPlaying(){
        return state.equals(State.PLAY);
    }

    public StringBuilder getSbScore() { return sbScore; }

    public Score getScore() { return score; }

    public StringBuilder getSbGameOver() { return sbGameOver; }

    public void statePlayAgain(){
        state = State.PLAY;
    }

    public void initScore(){
        score.initScore();
    }

    public void initLives(){
        lives.initLives();
    }

    public Vector2 getZeroVector() { return zeroVector; }

    public GameState(TextureAtlas atlas) {
        score = new Score();
        lives = new Lives(atlas);

        sbScore = new StringBuilder();
        sbGameOver = new StringBuilder("GameOver");

        state = State.PLAY;
    }

    private enum State{
        PLAY, GAMEOVER;
    }
}

package xyz.shuttle.game.Logic;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.ScreenManager;

/**
 * @author Shuttle on 6/04/18.
 */
public class GameState extends Actor {
    private Viewport viewport = ScreenManager.getInstance().getViewport();
    private Score score;
    private Lives lives;
    private State state;
    private BitmapFont font32;
    private BitmapFont font96;
    private StringBuilder sbScore;
    private StringBuilder sbGameOver;

    public GameState() {
        score = new Score();
        lives = new Lives();
        font32 = Assets.getInstance().getAssetManager().get("zorque32.ttf", BitmapFont.class);
        font96 = Assets.getInstance().getAssetManager().get("zorque96.ttf", BitmapFont.class);

        sbScore = new StringBuilder();
        sbGameOver = new StringBuilder("GameOver");

        state = State.PLAY;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sbScore.setLength(0);
        getFont32().draw(
                batch,
                getSbScore().append("Score: ").append(score.getScore()),
                0,
                viewport.getWorldHeight());
        getLives().draw(batch);
    }

    public BitmapFont getFont32() {
        return font32;
    }

    public BitmapFont getFont96() {
        return font96;
    }

    public StringBuilder getSbScore() {
        return sbScore;
    }

    public Lives getLives() {
        return lives;
    }

    public void setGameOver() {
        state = State.GAMEOVER;
    }

    public void setPlayAgain() {
        state = State.PLAY;
    }

    public StringBuilder getSbGameOver() {
        return sbGameOver;
    }

    public Score getScore() {
        return score;
    }

    public boolean isPlaying() {
        return state.equals(State.PLAY);
    }

    private enum State {
        PLAY, GAMEOVER
    }
}

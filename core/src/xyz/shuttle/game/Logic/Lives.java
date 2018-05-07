package xyz.shuttle.game.Logic;

import com.badlogic.gdx.graphics.g2d.Batch;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.players.OutsideRect;

/**
 * @author Shuttle on 6/04/18.
 */
public class Lives extends OutsideRect {
    private final int LIVES = 1;
    private int lives;

    public Lives() {
        super(Assets.getInstance().getAtlas().findRegion("rocket"), 1, 12, 12);
        setHeightProportion(viewport.getWorldHeight() * 0.05f);
        initLives();
    }

    public void initLives() {
        lives = LIVES;
    }

    @Override
    public void draw(Batch batch) {
        for (int i = 0; i < lives; i++) {
            this.pos.x = worldBounds.getLeft() + halfWidth * (i + 1);
            this.pos.y = worldBounds.getTop() - halfHeight - 32f;
            setFrame(11);
            super.draw(batch);
        }
    }

    public void decrement() {
        this.lives--;
    }

    public boolean hasLives() {
        return lives > 0;
    }
}
package xyz.shuttle.game.Logic;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import xyz.shuttle.game.tools.Sprite;

/**
 * @author Shuttle on 6/04/18.
 */

public class Lives extends Sprite {
    private final int INIT_LIVES = 3;
    private int lives;

    public Lives(TextureAtlas atlas) {
        super(atlas.findRegion("rocket"), 1, 12, 12);
        setSize(20f,20f);
        initLives();
    }

    public void initLives(){
        lives = INIT_LIVES;
    }

    public int decreaseAndGet() {
        return --lives;
    }

    public boolean hasLives(){
        return lives > 0;
    }

//    @Override
//    public void draw(SpriteBatch batch) {
//        for (int i = 0; i < lives; i++) {
//            this.pos.x = worldBounds.getLeft() + halfWidth * (i + 1);
//            this.pos.y = worldBounds.getTop() - halfHeight - 0.02f;
//            frame = 11;
//            super.draw(batch);
//        }
//    }
}
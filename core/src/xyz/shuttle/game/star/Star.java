package xyz.shuttle.game.star;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import xyz.shuttle.game.tools.Rnd;

public class Star extends VectorSprite {
    private Vector2 velocity;

    Star(TextureRegion region, float vx, float vy, float height) {
        super(region);
        setScale(height);
        setVector2Position(
                Rnd.nextInt(Gdx.graphics.getWidth()),
                Rnd.nextInt(Gdx.graphics.getHeight())
        );
        velocity = new Vector2(vx, vy);
    }

    public void update(float delta) {
        setVector2Position(getVector2Position().mulAdd(velocity, delta));
        checkAndHandleBounds();
    }

    private void checkAndHandleBounds() {
        if (getX() + getWidth() < 0) {
            setVector2Position(Gdx.graphics.getWidth(), getY());
        }
        if (getX() > Gdx.graphics.getWidth()) {
            setVector2Position(-getWidth(), getY());
        }
        if (getY() > Gdx.graphics.getHeight()) {
            setVector2Position(getX(), -getHeight());
        }
        if (getY() + getHeight() < 0) {
            setVector2Position(getX(), Gdx.graphics.getHeight());
        }
    }
}

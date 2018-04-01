package xyz.shuttle.game.star;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import xyz.shuttle.game.ScreenManager;
import xyz.shuttle.game.tools.Rnd;

public class Star extends VectorSprite {
    private Vector2 velocity;
    private Viewport viewport = ScreenManager.getInstance().getViewport();

    Star(TextureRegion region, float vx, float vy, float height) {
        super(region);
        setScale(height);
        setVector2Position(
                Rnd.nextFloat(0f, viewport.getWorldWidth()),
                Rnd.nextFloat(0f, viewport.getWorldHeight())
        );
        velocity = new Vector2(vx, vy);
    }

    public void update(float delta) {
        setVector2Position(getVector2Position().mulAdd(velocity, delta));
        checkAndHandleBounds();
    }

    private void checkAndHandleBounds() {
        if (getX() + getWidth() < 0) {
            setVector2Position(viewport.getWorldWidth(), getY());
        }
        if (getX() > viewport.getWorldWidth()) {
            setVector2Position(-getWidth(), getY());
        }
        if (getY() > viewport.getWorldHeight()) {
            setVector2Position(getX(), -getHeight());
        }
        if (getY() + getHeight() < 0) {
            setVector2Position(getX(), viewport.getWorldHeight());
        }
    }
}

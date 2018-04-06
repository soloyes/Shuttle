package xyz.shuttle.game.space.star;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.ScreenManager;
import xyz.shuttle.game.tools.Rnd;
import xyz.shuttle.game.tools.Sprite;

/**
 * @author Shuttle on 6/04/18.
 */
public class Star extends Sprite {
    public Viewport viewport = ScreenManager.getInstance().getViewport();
    private Vector2 velocity;

    Star(float vx, float vy, float a) {
        super(Assets.getInstance().getAtlas().findRegion("star"));
        pos.set(
                Rnd.nextFloat(0f, viewport.getWorldWidth()),
                Rnd.nextFloat(0f, viewport.getWorldHeight())
        );
        setSize(a, a);
        velocity = new Vector2(vx, vy);
    }

    public void update(float delta) {
        pos.mulAdd(velocity, delta);
        checkAndHandleBounds();
    }

    private void checkAndHandleBounds() {
        if (getRight() < 0) setLeft(viewport.getWorldWidth());
        if (getLeft() > viewport.getWorldWidth()) setRight(0);
        if (getBottom() > viewport.getWorldHeight()) setTop(0);
        if (getTop() < 0) setBottom(viewport.getWorldHeight());
    }
}

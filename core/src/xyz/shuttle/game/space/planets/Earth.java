package xyz.shuttle.game.space.planets;

import com.badlogic.gdx.utils.viewport.Viewport;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.ScreenManager;
import xyz.shuttle.game.tools.Sprite;

/**
 * @author Shuttle on 05/04/18.
 *         Class for store and manipulate with Earth.
 *         The background is solud color + starts, which generate by StarsEmitter.
 */
public class Earth extends Sprite {
    private final float ROTATION = -10f;
    private Viewport viewport = ScreenManager.getInstance().getViewport();
    private float r;
    private boolean scaleOut;

    public Earth() {
        super(
                Assets.getInstance().getAtlas().findRegion("planet"),
                6,
                6,
                32
        );
        pos.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2);
        setSize(256, 256);
        scaleOut = false;
    }

    public void act(float delta) {
        nextAngle(ROTATION * delta);

        //rotation speed:
        r += 10 * delta;
        if (r >= 1) {
            nextFrame();
            r = 0;
        }

        //scale in, scale out:
        if (scaleOut) {
            nextScale(-0.01f * delta);
            if (getScale() <= 0.8) {
                scaleOut = false;
            }
        } else {
            nextScale(0.01f * delta);
            if (getScale() >= 1.5) scaleOut = true;
        }
    }
}

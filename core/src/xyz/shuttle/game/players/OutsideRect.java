package xyz.shuttle.game.players;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import xyz.shuttle.game.Logic.Score;
import xyz.shuttle.game.ScreenManager;
import xyz.shuttle.game.tools.Rect;
import xyz.shuttle.game.tools.Rnd;
import xyz.shuttle.game.tools.Sprite;

/**
 * @author Shuttle on 7/04/18.
 *         Class for store parking rectangle (calculate interactions with others and location on map)
 *         Also should as Base class for every player or bot.
 *         We need for outsideRect because all items usually rotate, but it is easier to operate with static rectangles.
 */
public abstract class OutsideRect extends Sprite {
    protected int rotation;
    protected Viewport viewport = ScreenManager.getInstance().getViewport();
    protected Rect worldBounds = new Rect(
            viewport.getWorldWidth() / 2,
            viewport.getWorldHeight() / 2,
            viewport.getWorldWidth() / 2,
            viewport.getWorldHeight() / 2);
    protected Rect outsideRect = new Rect();
    protected Vector2 norDirection = new Vector2();
    //For calculate, to prevent much objects generation
    protected Vector2 tmp1 = new Vector2();
    protected Vector2 tmp2 = new Vector2();
    protected Vector2 tmp3 = new Vector2();
    //
    protected Sound itemSound;
    private boolean loud;
    private Vector2 newItem = new Vector2();
    private int i = 0;

    protected OutsideRect(TextureRegion region) {
        super(region);
    }

    protected OutsideRect(TextureRegion region, int i, int j, int frames) {
        super(region, i, j, frames);
    }

    protected void initOutsideRect(float width, float height, float times) {
        //Side size equals base sprite diagonale size. It is square.
        outsideRect.setWidth((float)
                Math.sqrt(Math.pow(width, 2) +
                        Math.pow(height, 2)));
        outsideRect.setHeight(outsideRect.getWidth());
    }

    protected void newItem(OutsideRect base) {
        outsideRect.pos.set(generate(Side.randomSide()));
        base.pos.set(outsideRect.pos);

        tmp2.set(Rnd.nextFloat(viewport.getWorldWidth() / 4, 3 * viewport.getWorldWidth() / 4),
                Rnd.nextFloat(viewport.getWorldHeight() / 4, 3 * viewport.getWorldHeight() / 4));
        tmp1.set(base.pos);
        tmp2.sub(tmp1);
        norDirection.set(tmp2.nor());

        base.setAngle(base.getAngle() + 360 / (Rnd.nextInt(6) + 1));
        rotation = Rnd.nextInt(3) - 1;

        if (isLoud()) {
            base.itemSound.play();
        }
    }

    private Vector2 generate(Side side) {
        float x = 0;
        float y = 0;
        switch (side) {
            case NORTH:
                x = Rnd.nextFloat(0, viewport.getWorldWidth());
                y = viewport.getWorldHeight() + outsideRect.getHalfHeight();
                break;
            case SOUTH:
                x = Rnd.nextFloat(0, viewport.getWorldWidth());
                y = -outsideRect.getHalfHeight();
                break;
            case WEST:
                y = Rnd.nextFloat(0, viewport.getWorldHeight());
                x = -outsideRect.getHalfWidth();
                break;
            case EAST:
                y = Rnd.nextFloat(0, viewport.getWorldHeight());
                x = viewport.getWorldWidth() + outsideRect.getHalfWidth();
        }
        return newItem.set(x, y);
    }

    protected boolean isLoud() {
        return loud;
    }

    protected void setLoud(boolean loud) {
        this.loud = loud;
    }

    protected void setPosOutsideRect(Sprite base) {
        outsideRect.pos.set(base.pos);
    }

    private enum Side {
        EAST, WEST, SOUTH, NORTH;

        public static Side randomSide() {
            return Side.values()[Rnd.nextInt(Side.values().length)];
        }
    }
}

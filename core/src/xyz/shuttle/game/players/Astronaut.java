package xyz.shuttle.game.players;

import xyz.shuttle.game.Assets;

/**
 * @author Shuttle on 7/04/18
 */
public class Astronaut extends OutsideRect {
    private final float VELOCITY = 200f;

    public Astronaut() {
        super(Assets.getInstance().getAtlas().findRegion("astronaut"));
        itemSound = Assets.getInstance().getAssetManager().get("music/rogerroll.ogg");
        setLoud(true);
        newItem(this);
        setHeightProportion(viewport.getWorldHeight() * 0.1f);
        initOutsideRect(this.getWidth(), this.getHeight(), 2f);
    }

    public void update(float delta) {
        pos.mulAdd(norDirection, delta * VELOCITY);
        setPosOutsideRect(this);
        nextAngle(0.5f * rotation);
        checkAndHandleBounds();
    }

    private void checkAndHandleBounds() {
        if (outsideRect.isOutside(worldBounds)) {
            newItem(this);
        }
    }
}

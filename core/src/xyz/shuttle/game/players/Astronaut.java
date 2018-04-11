package xyz.shuttle.game.players;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.Logic.GameState;

/**
 * @author Shuttle on 7/04/18
 */
public class Astronaut extends OutsideRect {
    private final float VELOCITY = 200f;
    private Alien alien;
    private GameState gameState;

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
        } else checkCollisions();
    }

    //Метод здесь, потому что если вынести его в Alien, то при генерации нового астронавта сразу
    //же сработает checkAndHandleBounds, и будет множественный звук появления астронавта.
    private void checkCollisions() {
        if (alien.isHungry()) {
            if (this.isMe(alien.pos)) {
                itemSound.stop();
                newItem(this);
                gameState.getScore().decrease(alien.getPower());
            }
        }
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
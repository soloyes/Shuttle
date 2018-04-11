package xyz.shuttle.game.players;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.Logic.GameState;
import xyz.shuttle.game.tools.Rnd;

/**
 * @author Shuttle on 11/04/18.
 *         Class for store and manipulate with Alien
 */
public class Alien extends OutsideRect {
    private final float VELOCITY = 500f;
    private final int power = 2;
    private boolean hungry;
    private Astronaut astronaut;
    private Player player;
    private GameState gameState;

    public Alien() {
        super(Assets.getInstance().getAtlas().findRegion("aliens"), 1, 3, 3);
        itemSound = Assets.getInstance().getAssetManager().get("music/alien.ogg");
        newItem(this);
        setHeightProportion(viewport.getWorldHeight() * 0.1f);
        initOutsideRect(this.getWidth(), this.getHeight(), 2f);
        setHungry(true);
        setLoud(true);
    }

    public void update(float delta) {
        //
        if (isHungry()) {
            tmp1.set(pos);
            if (tmp1.sub(player.pos).len() < 300f) {
                tmp1.set(player.pos);
                tmp1.sub(pos);
                norDirection.set(tmp1.nor());
            }
            tmp2.set(pos);
            if (tmp2.sub(astronaut.pos).len() < 500f) {
                tmp2.set(astronaut.pos);
                tmp2.sub(pos);
                norDirection.set(tmp2.nor());
            }
        }
        //
        pos.mulAdd(norDirection, delta * VELOCITY);
        setAngle(5f * rotation);
        setPosOutsideRect(this);
        checkAndHandleBounds();
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    private void checkAndHandleBounds() {
        if (outsideRect.isOutside(worldBounds)) {
            setHungry(true);
            setFrame(Rnd.nextInt(3));
            newItem(this);
        }
    }

    public int getPower() {
        return power;
    }

    public void setAstronaut(Astronaut astronaut) {
        this.astronaut = astronaut;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
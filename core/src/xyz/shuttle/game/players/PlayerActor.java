package xyz.shuttle.game.players;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author Shuttle on 5/04/18.
 */

//todo: Сделать интерфейс для всех акторов. Классы идентичны.

public class PlayerActor extends Actor {
    private Player player;

    public PlayerActor() {
        this.player = new Player();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        player.draw(batch);
    }

    @Override
    public void act(float delta) {
        player.update(delta);
    }

    public Player getPlayer() {
        return player;
    }
}

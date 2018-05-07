package xyz.shuttle.game.players;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author Shuttle on 11/04/18.
 *         Class for store and manipulate with Alien
 */
//todo: Сделать интерфейс для всех акторов. Классы идентичны.

public class AlienActor extends Actor {
    private Alien alien;

    public AlienActor() {
        this.alien = new Alien();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        alien.draw(batch);
    }

    @Override
    public void act(float delta) {
        alien.update(delta);
    }

    public Alien getAlien() {
        return alien;
    }
}
package xyz.shuttle.game.players;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author Shuttle on 5/04/18.
 */
//todo: Сделать интерфейс для всех акторов. Классы идентичны.

public class AstronautActor extends Actor {
    private Astronaut astronaut;

    public AstronautActor() {
        this.astronaut = new Astronaut();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        astronaut.draw(batch);
    }

    @Override
    public void act(float delta) {
        astronaut.update(delta);
    }

    public Astronaut getAstronaut() {
        return astronaut;
    }
}
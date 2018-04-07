package xyz.shuttle.game.space.planets;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author Shuttle on 4/6/18.
 */
public class EarthActor extends Actor {
    private Earth earth;

    public EarthActor() {
        this.earth = new Earth();
    }

    @Override
    public void act(float delta) {
        earth.update(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        earth.draw(batch);
    }
}

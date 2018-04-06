package xyz.shuttle.game.space.star;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import xyz.shuttle.game.tools.Rnd;

/**
 * @author Shuttle on 3/24/18.
 *         Class for store and manipulate with Star
 */
public class StarsEmitter extends Actor {
    private final int STARS = 100;
    private Star[] stars = new Star[STARS];

    public StarsEmitter() {
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(
                    Rnd.nextFloat(-50f, 100f),
                    Rnd.nextFloat(10f, 60f),
                    Rnd.nextFloat(5f, 25f));
        }
    }

//        public void setVAngle(float angle) {
//        for (int i = 0; i < stars.length; i++) {
//            stars[i].setV(stars[i].getV().setAngle(angle - 180));
//        }
//    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (int i = 0; i < stars.length; i++) {
            stars[i].draw(batch);
        }
    }

    @Override
    public void act(float delta) {
        for (int i = 0; i < stars.length; i++) {
            stars[i].update(delta);
        }
    }
}
package xyz.shuttle.game.star;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.tools.Rnd;

/**
 * Created by sol on 2/6/18.
 * Class for store and manipulate with Star
 */
public class StarsEmitter extends Actor {
    private final int STARS = 80;
    private Star[] stars = new Star[STARS];

    public StarsEmitter() {
        System.out.println(Gdx.graphics.getWidth() + " " + Gdx.graphics.getHeight());
        TextureRegion region = Assets.getInstance().getAtlas().findRegion("star");
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(
                    region,
                    Rnd.nextFloat(-50f, 200f),
                    Rnd.nextFloat(10f, 20f),
                    Rnd.nextFloat(0.2f, 0.7f));
            //stars[i] = new Star(region, -50, 200, 0.5f);
        }
    }

    //    public void setVAngle(float angle) {
//        for (int i = 0; i < stars.length; i++) {
//            stars[i].setV(stars[i].getV().setAngle(angle - 180));
//        }
//    }
//
    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (int i = 0; i < stars.length; i++) {
            stars[i].draw(batch, parentAlpha);
        }
    }

    @Override
    public void act(float delta) {
        for (int i = 0; i < stars.length; i++) {
            stars[i].update(delta);
        }
    }
}
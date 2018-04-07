package xyz.shuttle.game.players;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.ScreenManager;
import xyz.shuttle.game.space.star.StarsEmitter;

/**
 * @author Shuttle on 6/04/18.
 */
public class Player extends InsightRect {
    private final float VELOCITY = 600f;
    private Vector2 target;
    private Vector2 destanation;
    private Vector2 norDestanation;
    private Viewport viewport = ScreenManager.getInstance().getViewport();
    //private Astronaut astronaut;
    //private Alien alien;
    //private Lives lives;
    private StarsEmitter stars;

    public Player() {
        super(Assets.getInstance().getAtlas().findRegion("rocket"), 1, 12, 12);
        target = new Vector2(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2);
        norDestanation = new Vector2();
        destanation = new Vector2();
        setHeightProportion(viewport.getWorldHeight() * 0.15f);
        pos.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() + this.getHeight());
        setAngle(180);

        initInsightRect(this.getWidth(), this.getHeight(), 2f);
    }

    //public void setAstronaut(Astronaut astronaut) {
//        this.astronaut = astronaut;
//    }

//    public void setAlien(Alien alien) {
//        this.alien = alien;
//    }

    public void update(float delta) {
        tmp2.set(target);
        destanation = tmp2.sub(pos);
        tmp3.set(destanation);
        norDestanation = tmp3.nor();
        tmp3.set(norDestanation);

        //Calculate player target
        if (!this.isMe(target)) {
            tmp2.set(target);
            destanation = tmp2.sub(pos);
            tmp3.set(destanation);
            norDestanation = tmp3.nor();
            tmp3.set(norDestanation);
            //Parking
            if (destanation.len() > delta) {
                pos.mulAdd(tmp3, VELOCITY * delta);
                nextFrame();
            } else {
                pos.set(target);
            }
            //
        } else {
            setFrame(0);
        }
////        //
        setPosInsightRect(this);
//        checkCollisions();
    }

    private void checkCollisions() {
        //        //With astronaut
//        if (this.isMe(astronaut.pos)) {
//            astronaut.itemSound.stop();
//            astronaut.newItem(astronaut);
//            score.increaseAndGet();
//        }
//        //With alien
//        if (alien.isHungry()) {
//            if (this.isMe(alien.pos)) {
//                alien.setHungry(false);
//                pos.set(0.0f, 0.5f);
//                setAngle(180);
//                setTarget(new Vector2(0.0f, 0.0f));
//                lives.decreaseAndGet();
//            }
//        }
    }

    public void setStars(StarsEmitter stars) {
        this.stars = stars;
    }

    //public void setLives(Lives lives) {
    //    this.lives = lives;
    //}

    public void setTarget(Vector2 target) {
        this.target = target;
        checkAndHandleBounds();
        tmp1.set(target);
        setAngle(tmp1.sub(pos).angle() - 90);
        tmp1.set(target);
        stars.setVAngle(tmp1.sub(pos).angle());
    }

    private void checkAndHandleBounds() {
        if (viewport.getWorldWidth() - target.x < parkingRect.getHalfWidth())
            target.x = viewport.getWorldWidth() - parkingRect.getHalfWidth() / 2;
        if (target.y < parkingRect.getHalfHeight())
            target.y = parkingRect.getHalfHeight() / 2;
        if (target.x < parkingRect.getHalfWidth())
            target.x = parkingRect.getHalfWidth() / 2;
        if (viewport.getWorldHeight() - target.y < parkingRect.getHalfWidth())
            target.y = viewport.getWorldHeight() - parkingRect.getHalfWidth() / 2;
    }
}

package xyz.shuttle.game.star;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Star extends Sprite{

    private Vector2 velocity;
    private Vector2 position;

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    Star(TextureRegion region, float vx, float vy, float height) {
        super(region);
        velocity.set(vx, -vy);
        //setHeightProportion(Rnd.nextFloat(height, height*2));
    }

//    public void update(float delta) {
//        pos.mulAdd(velocity, delta);
//        checkAndHandleBounds();
//    }

//    private void checkAndHandleBounds() {
//        if (this.getRight() < worldBounds.getLeft()) setLeft(worldBounds.getRight());
//        if (this.getLeft() > worldBounds.getRight()) setRight(worldBounds.getLeft());
//        if (this.getTop() < worldBounds.getBottom()) setBottom(worldBounds.getTop());
//        if (this.getBottom() > worldBounds.getTop()) setTop(worldBounds.getBottom());
//    }
//
//    @Override
//    public void resize(Rect worldBounds) {
//        this.worldBounds = worldBounds;
//        float posX = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
//        float posY = Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
//        pos.set(posX, posY);
//    }
}
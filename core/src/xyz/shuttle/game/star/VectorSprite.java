package xyz.shuttle.game.star;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Shuttle on 3/31/18.
 */
public class VectorSprite extends Sprite {
    protected Vector2 vector2Position;

    protected VectorSprite(TextureRegion region) {
        super(region);
        vector2Position = new Vector2();
    }

    protected void setVector2Position(float x, float y) {
        this.vector2Position.x = x;
        this.vector2Position.y = y;
        super.setX(x);
        super.setY(y);
    }

    protected Vector2 getVector2Position() {
        return vector2Position;
    }

    protected void setVector2Position(Vector2 vector2) {
        this.vector2Position = vector2;
        super.setX(vector2.x);
        super.setY(vector2.y);
    }
}

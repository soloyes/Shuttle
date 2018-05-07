package xyz.shuttle.game.tools;

import com.badlogic.gdx.math.Vector2;

/**
 * @author Shuttle on 3/31/18.
 */
public class Rect {
    public final Vector2 pos = new Vector2(); // Center position
    protected float halfWidth;
    protected float halfHeight;

    public Rect() {
    }

    public Rect(Rect from) {
        this(from.pos.x, from.pos.y, from.getHalfWidth(), from.getHalfHeight());
    }

    public Rect(float x, float y, float halfWidth, float halfHeight) {
        pos.set(x, y);
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
    }

    public float getHalfWidth() {
        return halfWidth;
    }

    public float getHalfHeight() {
        return halfHeight;
    }

    public boolean isMe(Vector2 touch) {
        return touch.x >= getLeft() &&
                touch.x <= getRight() &&
                touch.y >= getBottom() &&
                touch.y <= getTop();
    }

    public float getLeft() {
        return pos.x - halfWidth;
    }

    public float getRight() {
        return pos.x + halfWidth;
    }

    public float getBottom() {
        return pos.y - halfHeight;
    }

    public float getTop() {
        return pos.y + halfHeight;
    }

    public void setTop(float top) {
        pos.y = top - halfHeight;
    }

    public void setBottom(float bottom) {
        pos.y = bottom + halfHeight;
    }

    public void setRight(float right) {
        pos.x = right - halfWidth;
    }

    public void setLeft(float left) {
        pos.x = left + halfWidth;
    }

    public boolean isOutside(Rect other) {
        return getLeft() > other.getRight() ||
                getRight() < other.getLeft() ||
                getBottom() > other.getTop() ||
                getTop() < other.getBottom();
    }

    public void set(Rect from) {
        pos.set(from.pos);
        halfWidth = from.halfWidth;
        halfHeight = from.halfHeight;
    }

    public void set(Rect from, float i) {
        pos.set(from.pos);
        halfWidth = i * from.halfWidth;
        halfHeight = i * from.halfHeight;
    }

    public void setSize(float width, float height) {
        this.halfWidth = width / 2f;
        this.halfHeight = height / 2f;
    }

    public float getHeight() {
        return halfHeight * 2f;
    }

    public void setHeight(float height) {
        this.halfHeight = height / 2f;
    }

    public float getWidth() {
        return halfWidth * 2f;
    }

    public void setWidth(float width) {
        this.halfWidth = width / 2f;
    }
}
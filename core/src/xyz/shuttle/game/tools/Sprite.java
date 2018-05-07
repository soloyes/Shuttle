package xyz.shuttle.game.tools;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Shuttle on 6/04/18.
 */
public class Sprite extends Rect {
    private TextureRegion[] regions;
    private float angle;
    private float scale = 1f;
    private int frame;

    public Sprite(TextureRegion region) {
        if (region == null) {
            throw new NullPointerException("Texture is null");
        }
        regions = new TextureRegion[1];
        regions[0] = region;
    }

    public Sprite(TextureRegion region, int i, int j, int frames) {
        if (region == null) {
            throw new NullPointerException("Texture is null");
        }
        regions = Regions.split(region, i, j, frames);
    }

    public void draw(Batch batch) {
        batch.draw(
                regions[frame], // Current region
                getLeft(), getBottom(), // Draw point
                halfWidth, halfHeight, // Rotation point
                getWidth(), getHeight(), // Width, Height
                scale, scale, // ScaleX, ScaleY
                angle // Rotation angle
        );
    }

    public void nextAngle(float angle) {
        this.angle += angle;
        this.angle = this.angle % 360;
    }

    public void nextFrame() {
        frame++;
        frame = frame % regions.length;
    }

    public void nextScale(float scale) {
        this.scale += scale;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    protected void setHeightProportion(float height) {
        setHeight(height);
        float aspect = regions[frame].getRegionWidth() / (float) regions[frame].getRegionHeight();
        setWidth(height * aspect);
    }
}
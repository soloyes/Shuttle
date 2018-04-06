package xyz.shuttle.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.ScreenManager;

/**
 * Created by FlameXander on 12.03.2018.
 */
public class GameScreen_Vanilla implements Screen {
    private SpriteBatch batch;
    private Player player;
    private Camera camera;
    private TextureRegion texture;
    public GameScreen_Vanilla(SpriteBatch batch, Camera camera) {
        this.batch = batch;
        this.camera = camera;
    }

    @Override
    public void show() {
        player = new Player();
        texture = Assets.getInstance().getAtlas().findRegion("element");
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0.4f, 0.4f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.position.set(player.position.x, player.position.y, 0);
        if (camera.position.x < 640) {
            camera.position.x = 640;
        }
        if (camera.position.x > 2560 - 640) {
            camera.position.x = 2560 - 640;
        }
        if (camera.position.y < 360) {
            camera.position.y = 360;
        }
        if (camera.position.y > 1440 - 360) {
            camera.position.y = 1440 - 360;
        }
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player.render(batch);
        batch.draw(texture, 1080 - 60, 720 - 60);
        batch.draw(texture, 1480 - 60, 720 - 60);
        batch.draw(texture, 1280 - 60, 520 - 60);
        batch.draw(texture, 1280 - 60, 920 - 60);
        for (int i = 0; i <= 2560; i += 120) {
            batch.draw(texture, i - 60, 0 - 60);
            batch.draw(texture, i - 60, 1440 - 60);
        }
        for (int i = 0; i <= 1440; i += 120) {
            batch.draw(texture, 0 - 60, i - 60);
            batch.draw(texture, 2560 - 60, i - 60);
        }
        batch.end();
    }

    public void update(float dt) {
        player.update(dt);
    }

    @Override
    public void resize(int width, int height) {
        ScreenManager.getInstance().onResize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    private class Player {
        private TextureRegion texture;
        private Vector2 position;
        private Vector2 pointer;
        private Vector2 velocity;
        private float angle;

        public Player() {
            texture = Assets.getInstance().getAtlas().findRegion("hero");
            position = new Vector2(1280, 720);
            pointer = new Vector2(0, 0);
            velocity = new Vector2(0, 0);
        }

        public void render(SpriteBatch batch) {
            batch.draw(texture, position.x - 60, position.y - 60, 60, 60, 120, 120, 1, 1, angle);
        }

        public void update(float dt) {
            if (Gdx.input.isTouched()) {
                pointer.set(Gdx.input.getX(), Gdx.input.getY());
                ScreenManager.getInstance().getViewport().unproject(pointer);
                float angleTo = (float) Math.toDegrees(Math.atan2(-position.y + pointer.y, -position.x + pointer.x));
                if (angle < angleTo) {
                    if (Math.abs(angleTo - angle) < 180.0f) {
                        angle += 180.0f * dt;
                    } else {
                        angle -= 180.0f * dt;
                    }
                }
                if (angle > angleTo) {
                    if (Math.abs(angleTo - angle) < 180.0f) {
                        angle -= 180.0f * dt;
                    } else {
                        angle += 180.0f * dt;
                    }
                }
                if (angle > 180) {
                    angle -= 360;
                }
                if (angle < -180) {
                    angle += 360;
                }
                velocity.x += (float) Math.cos(Math.toRadians(angle)) * 500.0f * dt;
                velocity.y += (float) Math.sin(Math.toRadians(angle)) * 500.0f * dt;
            }
            velocity.scl(0.995f);
            if (position.x < 0 + 60) {
                position.x = 0 + 60;
                velocity.x *= -1;
            }
            if (position.x > 2560 - 60) {
                position.x = 2560 - 60;
                velocity.x *= -1;
            }
            if (position.y < 0 + 60) {
                position.y = 0 + 60;
                velocity.y *= -1;
            }
            if (position.y > 1440 - 60) {
                position.y = 1440 - 60;
                velocity.y *= -1;
            }
            position.mulAdd(velocity, dt);
        }
    }
}

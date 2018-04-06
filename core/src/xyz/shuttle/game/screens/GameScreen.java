package xyz.shuttle.game.screens;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.ScreenManager;
import xyz.shuttle.game.space.planets.EarthActor;
import xyz.shuttle.game.space.star.StarsEmitter;

/**
 * @author Shuttle on 4/6/18.
 */
public class GameScreen extends BaseScreen {
    public GameScreen(SpriteBatch batch) {
        super(batch);
    }

    @Override
    public void show() {
        super.show();
        Assets.getInstance()
                .getAssetManager()
                .get("music/game.ogg", Music.class)
                .play();
        Assets.getInstance()
                .getAssetManager()
                .get("music/game.ogg", Music.class)
                .setLooping(true);
    }

    @Override
    void createGUI() {
        stage.addActor(new StarsEmitter());
        stage.addActor(new EarthActor());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        ScreenManager.getInstance().onResize(width, height);
    }
}

package xyz.shuttle.game.screens;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.buttons.MenuBar;
import xyz.shuttle.game.star.StarsEmitter;

/**
 * @author Shuttle on 3/24/18.
 */
public class MenuScreen extends BaseScreen {

    public MenuScreen(SpriteBatch batch) {
        super(batch);
    }

    @Override
    public void show() {
        super.show();
        Assets.getInstance()
                .getAssetManager()
                .get("music/menu.ogg", Music.class)
                .play();
        Assets.getInstance()
                .getAssetManager()
                .get("music/menu.ogg", Music.class)
                .setLooping(true);
    }

    @Override
    public void createGUI() {
        stage.addActor(new StarsEmitter());
        stage.addActor(new MenuBar());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }
}
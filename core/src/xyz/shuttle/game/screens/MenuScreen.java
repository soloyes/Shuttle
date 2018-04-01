package xyz.shuttle.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import xyz.shuttle.game.ScreenManager;
import xyz.shuttle.game.buttons.MenuBar;
import xyz.shuttle.game.star.StarsEmitter;

/**
 * @author Shuttle on 3/24/18.
 */
public class MenuScreen implements Screen {
    private Stage stage;
    private Music music;

    public MenuScreen(SpriteBatch batch) {
        stage = new Stage(ScreenManager.getInstance().getViewport(), batch);
    }

    @Override
    public void show() {
        createGUI();
        Gdx.input.setInputProcessor(stage);
        music = Gdx.audio.newMusic(Gdx.files.internal("music/menu.ogg"));
        music.play();
        music.setLooping(true);
    }

    private void createGUI() {
        stage.addActor(new StarsEmitter());
        stage.addActor(new MenuBar());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
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
        music.dispose();
    }
}
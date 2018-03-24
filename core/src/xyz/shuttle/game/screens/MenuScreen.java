package xyz.shuttle.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import xyz.shuttle.game.ScreenManager;
import xyz.shuttle.game.buttons.MenuBar;

/**
 * @author Shuttle on 3/24/18.
 */
public class MenuScreen implements Screen {
    private Stage stage;

    public MenuScreen(SpriteBatch batch) {
        stage = new Stage(ScreenManager.getInstance().getViewport(), batch);
    }

    @Override
    public void show() {
        createGUI();
        Gdx.input.setInputProcessor(stage);
    }

    private void createGUI() {
        stage.addActor(new MenuBar());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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

    }
}
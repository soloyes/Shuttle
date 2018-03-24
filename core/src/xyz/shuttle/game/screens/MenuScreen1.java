package xyz.shuttle.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.ScreenManager;
import xyz.shuttle.game.buttons.ImageButtonBuilder;
import xyz.shuttle.game.buttons.MenuBar;

/**
 * @author Shuttle on 3/24/18.
 */
public class MenuScreen1 implements Screen {
    private SpriteBatch batch;
    private Stage stage;
    private Button buttonExit;
    private Button buttonPlay;
    private Skin skin;

    public MenuScreen1(SpriteBatch batch) {
        this.batch = batch;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
    }

    private void createGUI() {
        //stage.addActor(new MenuBar());
        this.skin = new Skin(Assets.getInstance().getAtlas());
        ImageButtonBuilder buttonBuilder = new ImageButtonBuilder(skin);
        buttonPlay = buttonBuilder.getButton("play", 0f, 0f);
        buttonExit = buttonBuilder.getButton("exit", Gdx.graphics.getWidth() * 0.8f, 0f);
        stage.addActor(buttonPlay);
        stage.addActor(buttonExit);
        buttonExit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("BLA");
            }
        });

    }

    @Override
    public void show() {
        createGUI();
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
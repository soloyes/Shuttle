package xyz.shuttle.game.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.ScreenManager;

/**
 * @author Shuttle on 3/24/18.
 */
public class MenuBar extends Group {
    private Button buttonExit;
    private Button buttonPlay;

    public MenuBar() {
        Skin skin = new Skin(Assets.getInstance().getAtlas());
        ImageButtonBuilder buttonBuilder = new ImageButtonBuilder(skin);
        buttonPlay = buttonBuilder.getButton("play", 0f, 0f);
        buttonExit = buttonBuilder.getButton("exit", Gdx.graphics.getWidth() * 0.8f, 0f);

        buttonExit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        buttonPlay.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                ScreenManager.getInstance().switchScreen(ScreenManager.ScreenType.GAME);
            }
        });

        this.addActor(buttonExit);
        this.addActor(buttonPlay);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        buttonPlay.draw(batch, parentAlpha);
        buttonExit.draw(batch, parentAlpha);
    }

}
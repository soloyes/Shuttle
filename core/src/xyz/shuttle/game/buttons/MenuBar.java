package xyz.shuttle.game.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import xyz.shuttle.game.Assets;

/**
 * @author Shuttle on 3/24/18.
 */
public class MenuBar extends Group {
    private Button buttonExit;
    private Button buttonPlay;
    private Skin skin;

    public MenuBar() {
        this.skin = new Skin(Assets.getInstance().getAtlas());
        ImageButtonBuilder buttonBuilder = new ImageButtonBuilder(skin);
        buttonPlay = buttonBuilder.getButton("play", 0f, 0f);
        buttonExit = buttonBuilder.getButton("exit", Gdx.graphics.getWidth() * 0.8f, 0f);

        this.addActor(buttonExit);
        buttonExit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("BLA");
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        buttonPlay.draw(batch, parentAlpha);
        buttonExit.draw(batch, parentAlpha);
        System.out.println(buttonExit.getParent());
    }

}

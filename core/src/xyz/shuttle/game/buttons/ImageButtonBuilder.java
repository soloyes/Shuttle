package xyz.shuttle.game.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * @author Shuttle on 3/24/18.
 */
public class ImageButtonBuilder {
    private final float SIZE = 0.3f;
    private ImageButton myButton;
    private ImageButton.ImageButtonStyle myButtonStyle;
    private Skin skin;

    public ImageButtonBuilder(Skin skin) {
        this.skin = skin;
    }

    public Button getButton(String name, float x, float y) {
        myButtonStyle = new ImageButton.ImageButtonStyle();
        myButtonStyle.imageUp = skin.getDrawable(name);
        myButton = new ImageButton(myButtonStyle);
        myButton.setPosition(x, y);
        myButton.setSize(Gdx.graphics.getWidth() * SIZE, Gdx.graphics.getWidth() * SIZE);
        myButton.setTransform(true);

        final ImageButton btn = myButton;
        myButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                btn.setScale(0.95f);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                btn.setScale(1f);
            }
        });
        return myButton;
    }
}
package xyz.shuttle.game.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ImageButtonBuilder extends Button {
    private final float size = 0.2f;
    private ImageButton button;
    private ImageButton.ImageButtonStyle buttonStyle;
    private Skin skin;

    public ImageButtonBuilder(Skin skin) {
        this.skin = skin;
    }

    public Button getButton(String name, float x, float y) {
        buttonStyle = new ImageButton.ImageButtonStyle();
        buttonStyle.imageUp = skin.getDrawable(name);
        button = new ImageButton(buttonStyle);
        button.setPosition(x, y);
        button.setSize(Gdx.graphics.getWidth() * size, Gdx.graphics.getWidth() * size);
        return button;
    }
}
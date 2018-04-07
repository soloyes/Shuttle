package xyz.shuttle.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

/**
 * Created by FlameXander on 12.03.2018.
 */
public class Assets {
    private static final Assets ourInstance = new Assets();
    private AssetManager assetManager;
    private TextureAtlas textureAtlas;

    private Assets() {
        assetManager = new AssetManager();
    }

    public void clear() {
        assetManager.clear();
    }

    public void createStandardFont(int size) {
        FileHandleResolver resolver = new InternalFileHandleResolver();
        assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        assetManager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
        FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        fontParameter.fontFileName = "fonts/zorque.ttf";
        fontParameter.fontParameters.size = size;
        fontParameter.fontParameters.color = Color.WHITE;
        fontParameter.fontParameters.borderWidth = 1;
        fontParameter.fontParameters.borderColor = Color.BLACK;
        fontParameter.fontParameters.shadowOffsetX = 1;
        fontParameter.fontParameters.shadowOffsetY = 1;
        fontParameter.fontParameters.shadowColor = Color.BLACK;
        assetManager.load("zorque" + size + ".ttf", BitmapFont.class, fontParameter);
    }

    public void loadAssets(ScreenManager.ScreenType type) {
        switch (type) {
            case MENU:
                assetManager.load("textures/mainAtlas.atlas", TextureAtlas.class);
                assetManager.load("music/menu.ogg", Music.class);
                break;
            case GAME:
                assetManager.load("textures/mainAtlas.atlas", TextureAtlas.class);
                assetManager.load("music/game.ogg", Music.class);
                assetManager.load("music/menu.ogg", Music.class);
                assetManager.load("music/problem.ogg", Sound.class);
                assetManager.load("music/rogerroll.ogg", Sound.class);
                createStandardFont(32);
                break;
        }
    }

    public void makeLinks() {
        textureAtlas = assetManager.get("textures/mainAtlas.atlas", TextureAtlas.class);
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public TextureAtlas getAtlas() {
        return textureAtlas;
    }

    public static Assets getInstance() {
        return ourInstance;
    }
}

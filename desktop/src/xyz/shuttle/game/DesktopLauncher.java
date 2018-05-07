package xyz.shuttle.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1080;
        config.height = 1920;
        //config.fullscreen = true;
        config.vSyncEnabled = true;
        config.foregroundFPS = 60;
        //config.foregroundFPS = 5;
        new LwjglApplication(new CoreGame(), config);
    }
}
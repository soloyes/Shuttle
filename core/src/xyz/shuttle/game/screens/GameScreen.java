package xyz.shuttle.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.ScreenManager;
import xyz.shuttle.game.players.PlayerActor;
import xyz.shuttle.game.space.planets.EarthActor;
import xyz.shuttle.game.space.star.StarsEmitter;

/**
 * @author Shuttle on 4/6/18.
 */
public class GameScreen extends BaseScreen {
    private Vector2 worldHit = new Vector2();
    private Vector2 windowHit = new Vector2();
    private PlayerActor playerActor;
    private StarsEmitter starsEmitter;

    public GameScreen(SpriteBatch batch) {
        super(batch);
    }

    @Override
    public void show() {
        super.show();
        Assets.getInstance()
                .getAssetManager()
                .get("music/game.ogg", Music.class)
                .play();
        Assets.getInstance()
                .getAssetManager()
                .get("music/game.ogg", Music.class)
                .setLooping(true);
    }

    @Override
    void createGUI() {
        starsEmitter = new StarsEmitter();
        playerActor = new PlayerActor();
        playerActor.getPlayer().setStars(starsEmitter);

        stage.addActor(starsEmitter);
        stage.addActor(new EarthActor());
        stage.addActor(playerActor);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        stage.act(delta);

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        ScreenManager.getInstance().onResize(width, height);
    }

    private void update() {
        if (Gdx.input.isTouched())
            playerActor.setWorldHit(stage.screenToStageCoordinates(
                    new Vector2(
                            Gdx.input.getX(),
                            Gdx.input.getY())));
    }
}

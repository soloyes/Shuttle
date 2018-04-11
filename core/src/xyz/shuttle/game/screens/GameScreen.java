package xyz.shuttle.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import xyz.shuttle.game.Assets;
import xyz.shuttle.game.Logic.GameState;
import xyz.shuttle.game.ScreenManager;
import xyz.shuttle.game.players.Alien;
import xyz.shuttle.game.players.AlienActor;
import xyz.shuttle.game.players.AstronautActor;
import xyz.shuttle.game.players.PlayerActor;
import xyz.shuttle.game.space.planets.EarthActor;
import xyz.shuttle.game.space.star.StarsEmitter;

/**
 * @author Shuttle on 4/6/18.
 */
public class GameScreen extends BaseScreen {
    private EarthActor earthActor;
    private PlayerActor playerActor;
    private StarsEmitter starsEmitter;
    private AstronautActor astronautActor;
    private AlienActor alienActor;
    private Vector2 screenHit = new Vector2();
    private GameState gameState;

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
        earthActor = new EarthActor();
        starsEmitter = new StarsEmitter();
        playerActor = new PlayerActor();
        astronautActor = new AstronautActor();
        alienActor = new AlienActor();
        gameState = new GameState();

        playerActor.getPlayer().setStars(starsEmitter);
        playerActor.getPlayer().setGameState(gameState);
        playerActor.getPlayer().setAstronaut(astronautActor.getAstronaut());
        playerActor.getPlayer().setGameState(gameState);
        playerActor.getPlayer().setAlien(alienActor.getAlien());

        alienActor.getAlien().setPlayer(playerActor.getPlayer());
        alienActor.getAlien().setAstronaut(astronautActor.getAstronaut());
        alienActor.getAlien().setGameState(gameState);

        astronautActor.getAstronaut().setAlien(alienActor.getAlien());
        astronautActor.getAstronaut().setGameState(gameState);

        stage.addActor(starsEmitter);
        stage.addActor(earthActor);
        stage.addActor(astronautActor);
        stage.addActor(alienActor);
        stage.addActor(playerActor);
        stage.addActor(gameState);
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
        //todo: Дописать управление, чтобы на два пальца реагировало адекватно.
        if (Gdx.input.isTouched()) {
            screenHit.set(Gdx.input.getX(), Gdx.input.getY());
            playerActor.getPlayer().setTarget(stage.screenToStageCoordinates(screenHit));
        }
    }
}

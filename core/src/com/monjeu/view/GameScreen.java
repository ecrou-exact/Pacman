package com.monjeu.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.monjeu.model.World;
import com.monjeu.controller.WorldRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {
    private World world;
    private WorldRenderer renderer;
    private OrthographicCamera camera;
    private MainGame mainGame;
    private SpriteBatch batch;
    private Viewport viewport;

    private static final float WORLD_WIDTH = 1000; // Largeur du monde
    private static final float WORLD_HEIGHT = 1200; // Hauteur du monde

    public GameScreen(MainGame game) {
        this.mainGame = game;
        world = new World();

        // Initialisation de la caméra
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        
        // Centrer la caméra sur le plateau
        camera.position.set(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, 0);
        camera.update();

        this.batch = new SpriteBatch();
        renderer = new WorldRenderer(world, camera, game);
    }

    @Override
    public void render(float delta) {
        // Effacer l'écran
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Mise à jour de la caméra
        camera.update();
        batch.setProjectionMatrix(camera.combined); // Projection correcte du batch

        // Dessiner avec le batch
        batch.begin();
        batch.end();

        // Rendu du monde
        renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, 0); // Recentrage après resize
    }

    @Override
    public void dispose() {
        renderer.dispose();
        batch.dispose();
    }

    public void gameOver() {
        mainGame.setScreen(new GameOverScreen(mainGame));
    }

    @Override public void show() {}
    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}
}

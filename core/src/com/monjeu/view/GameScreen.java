package com.monjeu.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.monjeu.model.World;
import com.monjeu.controller.WorldRenderer;

public class GameScreen implements Screen {
    private World world;
    private WorldRenderer renderer;
    private OrthographicCamera camera;
    private MainGame mainGame; // Référence à l'instance de MainGame
    private SpriteBatch batch;

    public GameScreen(MainGame game) {
        this.mainGame = game; // Assigner l'instance de MainGame
        world = new World();
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 900, 700);
        this.batch = new SpriteBatch();
        
        renderer = new WorldRenderer(world, camera, game);
    }

    @Override
    public void render(float delta) {
    	Gdx.gl.glClearColor(0, 0, 0, 1); 
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        
        camera.update();
        
        
    
		batch.begin();
        batch.end();
        
        
        renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void show() {}

    @Override
    public void hide() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {
        renderer.dispose();
    }

    // Exemple de méthode pour changer d'écran
    public void gameOver() {
        mainGame.setScreen(new GameOverScreen(mainGame)); // Utilisation de l'instance pour changer d'écran
    }
}

package com.monjeu.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameWonScreen implements Screen{

	   private SpriteBatch batch;
	    private BitmapFont font;
	    private MainGame mainGame; // Référence à l'instance de MainGame

	    public GameWonScreen(MainGame game) {
	        this.mainGame = game; // Assigner l'instance de MainGame
	        batch = new SpriteBatch();
	        font = new BitmapFont();
	    }

	    @Override
	    public void show() {}

	    @Override
	    public void render(float delta) {
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        batch.begin();
	        
	        font.setColor(Color.GREEN);
	        font.draw(batch, "You WINNNNNNN!", 400, 350);
	        font.setColor(Color.WHITE);
	        font.draw(batch, "Press ENTER to Restart", 400, 300);
	        font.draw(batch, "Press ESC to Quit", 400, 250);

	        batch.end();

	        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
	            mainGame.setScreen(new GameScreen(mainGame)); // Utilisation de l'instance pour changer d'écran
	        }
	        
	        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
	            Gdx.app.exit(); // Quitter l'application
	        }
	    }

	    @Override
	    public void resize(int width, int height) {}

	    @Override
	    public void hide() {}

	    @Override
	    public void pause() {}

	    @Override
	    public void resume() {}

	    @Override
	    public void dispose() {
	        batch.dispose();
	        font.dispose();
	    }
}

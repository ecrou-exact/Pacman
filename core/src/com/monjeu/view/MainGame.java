package com.monjeu.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new MenuScreen(this)); // Passer l'instance de MainGame
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
    public void gameWon() {
        this.setScreen(new GameWonScreen(this)); // Passer l'instance de MainGame
    }


    // Méthode pour changer l'écran en GameOver
    public void gameOver() {
        this.setScreen(new GameOverScreen(this)); // Passer l'instance de MainGame
    }

    // Méthode pour changer l'écran en Menu
    public void goToMenu() {
        this.setScreen(new MenuScreen(this)); // Passer l'instance de MainGame
    }
}

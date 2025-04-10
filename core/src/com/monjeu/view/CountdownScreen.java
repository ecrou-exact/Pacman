package com.monjeu.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

public class CountdownScreen implements Screen {
    private MainGame mainGame;
    private SpriteBatch batch;
    private BitmapFont font;
    /* private int countdown = 3; // Commence à 3 */
    private boolean showGO = true;

    public CountdownScreen(MainGame game) {
        this.mainGame = game;
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(3f); // Texte plus grand

        // Décompte : met à jour `countdown` chaque seconde
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                /* countdown--;
                if (countdown < 0) {
                    mainGame.startGame(); // Démarrer le jeu après le décompte
                } */
            	showGO = false;
            	mainGame.startGame();
            }
        }, /* 1f, 1f, 3 */ 1f); // Délai initial 1s, répétition 1s, exécute 3 fois
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (!showGO) return; //Ne rien afficher
        
        batch.begin();
        String text = "GO!";
        /* String text = (countdown > 0) ? String.valueOf(countdown) : "GO!";*/
        GlyphLayout layout = new GlyphLayout(font, text);
        float x = (Gdx.graphics.getWidth() - layout.width) / 2;
        float y = Gdx.graphics.getHeight() / 2;

        font.draw(batch, layout, x, y);
        batch.end();
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
        batch.dispose();
        font.dispose();
    }
}

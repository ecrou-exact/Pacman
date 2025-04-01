package com.monjeu.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.Texture;

public class MenuScreen implements Screen {
    private SpriteBatch batch;
    private BitmapFont font;
    private BitmapFont titleFont;
    private MainGame mainGame;
    private Music menuMusic;
    private boolean musicEnabled = true;
    private Texture settingsButton;
    private float settingsX, settingsY, settingsWidth, settingsHeight;

    // Déclaration des textures
    private Texture settingsButtonOn;
    private Texture settingsButtonOff;

    public MenuScreen(MainGame game) {
        this.mainGame = game;
        batch = new SpriteBatch();

        // Chargement des polices
        font = new BitmapFont();
        font.setColor(Color.WHITE);

        titleFont = new BitmapFont();
        titleFont.setColor(Color.YELLOW);
        titleFont.getData().setScale(3f);

        // Charger et jouer la musique du menu
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("musiques/MenuPacman.mp3"));
        menuMusic.setLooping(true);
        menuMusic.setVolume(0.5f);
        menuMusic.play();

        // Chargement du bouton paramètres
        settingsWidth = 64;
        settingsHeight = 64;
        settingsX = (Gdx.graphics.getWidth() - settingsWidth) / 2; // Centré horizontalement
        settingsY = 20; // Positionné en bas (vous pouvez ajuster cette valeur si nécessaire)

        // Chargement des textures et initialisation
        settingsButtonOn = new Texture("textures/Pacman/droite/pacmanRight-2.png");
        settingsButtonOff = new Texture("textures/Pacman/droite/pacman-3.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // Centrer le titre "PACMAN"
        GlyphLayout titleLayout = new GlyphLayout(titleFont, "PACMAN");
        float titleX = (Gdx.graphics.getWidth() - titleLayout.width) / 2;
        titleFont.draw(batch, titleLayout, titleX, Gdx.graphics.getHeight() - 100);

        // Centrer "Press ENTER to Start"
        GlyphLayout startLayout = new GlyphLayout(font, "Press ENTER to Start");
        float startX = (Gdx.graphics.getWidth() - startLayout.width) / 2;
        font.draw(batch, startLayout, startX, Gdx.graphics.getHeight() / 2);

        // Centrer "Press ESC to Quit"
        GlyphLayout quitLayout = new GlyphLayout(font, "Press ESC to Quit");
        float quitX = (Gdx.graphics.getWidth() - quitLayout.width) / 2;
        font.draw(batch, quitLayout, quitX, Gdx.graphics.getHeight() / 2 - 50);

        // Affichage du texte "Allumer / Couper le son" au-dessus du bouton
        String soundStatus = musicEnabled ? "Couper le son" : "Allumer le son";
        GlyphLayout soundLayout = new GlyphLayout(font, soundStatus);
        float soundX = (Gdx.graphics.getWidth() - soundLayout.width) / 2;
        font.draw(batch, soundLayout, soundX, settingsY + settingsHeight + 20);

        // Affichage du bouton avec la bonne texture
        Texture currentTexture = musicEnabled ? settingsButtonOn : settingsButtonOff;
        batch.draw(currentTexture, settingsX, settingsY, settingsWidth, settingsHeight);

        batch.end();

        // Gestion des entrées clavier
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            startGameWithCountdown();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        // Gestion du clic sur le bouton paramètres
        if (Gdx.input.justTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();
            if (touchX >= settingsX && touchX <= settingsX + settingsWidth &&
                touchY >= settingsY && touchY <= settingsY + settingsHeight) {
                toggleMusic();
            }
        }
    }

    private void startGameWithCountdown() {
        if (menuMusic != null) {
            menuMusic.stop();
        }
        mainGame.setScreen(new CountdownScreen(mainGame));
    }

    private void toggleMusic() {
        musicEnabled = !musicEnabled;
        mainGame.setMusicEnabled(musicEnabled); // Met à jour l'état du son dans MainGame
        if (musicEnabled) {
            menuMusic.play();
        } else {
            menuMusic.pause();
        }
    }


    @Override
    public void resize(int width, int height) {}

    @Override
    public void show() {}

    @Override
    public void hide() {
        if (menuMusic != null) {
            menuMusic.stop();
        }
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        titleFont.dispose();
        menuMusic.dispose();
        settingsButtonOn.dispose();
        settingsButtonOff.dispose();
    }
}

package com.monjeu.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends Game {
    public SpriteBatch batch;
    private Music backgroundMusic;
    private boolean musicEnabled = true; // Etat de la musique, par défaut activée

    public boolean isMusicEnabled() {
        return musicEnabled;
    }

    public void setMusicEnabled(boolean musicEnabled) {
        this.musicEnabled = musicEnabled;
        if (musicEnabled) {
            // Si la musique est réactivée, jouer la musique en cours
            if (backgroundMusic != null) {
                backgroundMusic.play();
            }
        } else {
            // Si la musique est désactivée, l'arrêter
            stopMusic();
        }
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new MenuScreen(this)); // Affichage du menu sans musique
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        if (backgroundMusic != null) {
            backgroundMusic.dispose();
        }
    }
    

    public void startGame() {
        if (musicEnabled) {
            changeMusic("musiques/ArcadePacman.mp3"); // Démarrer la musique si activée
        }
        this.setScreen(new GameScreen(this)); // Lancer le jeu
    }

    public void gameWon() {
        if (musicEnabled) {
            changeMusic("musiques/VictoryPacman.mp3"); // Musique de victoire si activée
        }
        this.setScreen(new GameWonScreen(this));
    }

    public void gameOver() {
        if (musicEnabled) {
            changeMusic("musiques/GameOverPacman.mp3"); // Musique de game over si activée
        }
        this.setScreen(new GameOverScreen(this));
    }

    public void goToMenu() {
        stopMusic(); // Arrêter la musique en revenant au menu
        this.setScreen(new MenuScreen(this));
    }

    private void changeMusic(String musicFile) {
        stopMusic(); // Arrêter la musique précédente si nécessaire
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal(musicFile));
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(0.5f);
        if (musicEnabled) {
            backgroundMusic.play(); // Jouer la musique seulement si elle est activée
        }
    }

    private void stopMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
            backgroundMusic.dispose();
            backgroundMusic = null;
        }
    }
}

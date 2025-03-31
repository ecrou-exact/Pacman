package com.monjeu.model;

/**
 * Classe contenant des constantes globales pour le jeu.
 * Cette classe ne peut pas �tre instanci�e.
 */
public final class GameConstants {

    /**
     * Constructeur priv� pour emp�cher l'instanciation de la classe.
     */
    private GameConstants() {}

    /**
     * Largeur de l'�cran en pixels.
     */
    public static final int SCREEN_WIDTH = 800;

    /**
     * Hauteur de l'�cran en pixels.
     */
    public static final int SCREEN_HEIGHT = 600;

    /**
     * Taille d'une tuile en pixels.
     */
    public static final int PACMAN_SIZE = 32;

    /**
     * Vitesse du joueur en unit�s par seconde.
     */
    public static final float PLAYER_SPEED = 200.0f;

    /**
     * Titre du jeu affich� dans la fen�tre.
     */
    public static final String GAME_TITLE = "Pacman";
}


package com.monjeu.model;

/**
 * Classe contenant des constantes globales pour le jeu.
 * Cette classe ne peut pas être instanciée.
 */
public final class GameConstants {

    /**
     * Constructeur privé pour empêcher l'instanciation de la classe.
     */
    private GameConstants() {}

    /**
     * Largeur de l'écran en pixels.
     */
    public static final int SCREEN_WIDTH = 800;

    /**
     * Hauteur de l'écran en pixels.
     */
    public static final int SCREEN_HEIGHT = 600;

    /**
     * Taille d'une tuile en pixels.
     */
    public static final int PACMAN_SIZE = 32;

    /**
     * Vitesse du joueur en unités par seconde.
     */
    public static final float PLAYER_SPEED = 200.0f;

    /**
     * Titre du jeu affiché dans la fenêtre.
     */
    public static final String GAME_TITLE = "Pacman";
}


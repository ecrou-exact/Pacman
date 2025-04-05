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
    public static final float SCREEN_WIDTH = 800;
    /**
     * Hauteur de l'écran en pixels.
     */
    public static final float SCREEN_HEIGHT = 600;
    
    /**
     * Taille de Pacman en pixels.
     */
    public static final float PACMAN_SIZE = 32;
    
    /**
     * Taille des Pacgom en pixels.
     */
    public static final float PACGOM_SIZE = 32;
    
    /**
     * Taille des Ghost en pixels.
     */
    public static final float GHOST_SIZE = 32;
    
    /**
     * Taille d'un Mur en pixels.
     */
    public static final float WALL_SIZE = 32;
    
    /**
     * Vitesse de pacman en unités par seconde.
     */
    public static final float PACMAN_SPEED = 2;		// La vitesse ne marche plus, pacman est bloqué à une vitesse

    /**
     * Titre du jeu affiché dans la fenêtre.
     */
    public static final String GAME_TITLE = "Pacman";
}


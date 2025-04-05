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
    public static final float SCREEN_WIDTH = 800;
    /**
     * Hauteur de l'�cran en pixels.
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
     * Vitesse de pacman en unit�s par seconde.
     */
    public static final float PACMAN_SPEED = 2;		// La vitesse ne marche plus, pacman est bloqu� � une vitesse

    /**
     * Titre du jeu affich� dans la fen�tre.
     */
    public static final String GAME_TITLE = "Pacman";
}


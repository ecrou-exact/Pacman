package com.monjeu.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.monjeu.model.GameConstants;
import com.monjeu.model.GameElement;
import com.monjeu.model.Pacman;
import com.monjeu.model.Wall;
import com.monjeu.model.World;
/**
 * Contr�leur pour Pacman, g�rant les entr�es utilisateur et le d�placement du personnage.
 */
public class PacmanControleur {
    private Pacman pacman;
    private World world;
    private String desiredDirection;

    /**
     * Constructeur du contr�leur de Pacman.
     * 
     * @param pacman Le personnage Pacman � contr�ler.
     * @param world Le monde contenant les �l�ments du jeu.
     */
    public PacmanControleur(Pacman pacman, World world) {
        this.pacman = pacman;
        this.world = world;
        this.desiredDirection = pacman.getDirection();
    }

    /**
     * Met � jour l'�tat de Pacman, g�rant les entr�es utilisateur et le d�placement.
     * 
     * @param delta Le temps �coul� depuis la derni�re mise � jour.
     */
    public void update(float delta) {
        pacman.update(delta);
        handleInput();
        movePacman(delta);
    }

    /**
     * G�re les entr�es utilisateur pour d�finir la direction souhait�e.
     */
    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            desiredDirection = "gauche";
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            desiredDirection = "droite";
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            desiredDirection = "haut";
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            desiredDirection = "bas";
        }
    }

    /**
     * D�place Pacman dans la direction souhait�e si possible.
     * 
     * @param delta Le temps �coul� depuis la derni�re mise � jour.
     */
    private void movePacman(float delta) {
    	// x:0 y:12  -> x:26 y:12
   
    	
        float nextX = pacman.getX();
        float nextY = pacman.getY();
        float speed = GameConstants.PACMAN_SPEED * delta;

        // V�rifie si Pacman peut se d�placer dans la direction souhait�e
        if (canMoveTo(nextX + getDeltaX(desiredDirection, speed), nextY + getDeltaY(desiredDirection, speed))) {
            pacman.setDirection(desiredDirection);
        }

        // Essaye d'avancer dans la direction actuelle
        nextX += getDeltaX(pacman.getDirection(), speed);
        nextY += getDeltaY(pacman.getDirection(), speed);

        if (canMoveTo(nextX, nextY)) {
            pacman.setX((int) nextX);
            pacman.setY((int) nextY);
        }
    }
    
   

    /**
     * Calcule la variation de position sur l'axe X en fonction de la direction.
     * 
     * @param direction La direction du mouvement.
     * @param speed La vitesse de d�placement.
     * @return La variation de position sur l'axe X.
     */
    private float getDeltaX(String direction, float speed) {
        switch (direction) {
            case "gauche": return -speed;
            case "droite": return speed;
            default: return 0;
        }
    }

    /**
     * Calcule la variation de position sur l'axe Y en fonction de la direction.
     * 
     * @param direction La direction du mouvement.
     * @param speed La vitesse de d�placement.
     * @return La variation de position sur l'axe Y.
     */
    private float getDeltaY(String direction, float speed) {
        switch (direction) {
            case "haut": return speed;
            case "bas": return -speed;
            default: return 0;
        }
    }

    /**
     * V�rifie si Pacman peut se d�placer � une position donn�e sans collision.
     * 
     * @param x La position X cible.
     * @param y La position Y cible.
     * @return true si le d�placement est possible, false sinon.
     */
    private boolean canMoveTo(float x, float y) {
        Rectangle testHitBox = new Rectangle(x, y, pacman.getWidth(), pacman.getHeight());
        for (GameElement element : world.getGameElements()) {
            if (element instanceof Wall && testHitBox.overlaps(((Wall) element).getHitBox())) {
                return false;
            }
        }
        return true;
    }
}

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
 * Contrôleur pour Pacman, gérant les entrées utilisateur et le déplacement du personnage.
 */
public class PacmanControleur {
    private Pacman pacman;
    private World world;
    private String desiredDirection;

    /**
     * Constructeur du contrôleur de Pacman.
     * 
     * @param pacman Le personnage Pacman à contrôler.
     * @param world Le monde contenant les éléments du jeu.
     */
    public PacmanControleur(Pacman pacman, World world) {
        this.pacman = pacman;
        this.world = world;
        this.desiredDirection = pacman.getDirection();
    }

    /**
     * Met à jour l'état de Pacman, gérant les entrées utilisateur et le déplacement.
     * 
     * @param delta Le temps écoulé depuis la dernière mise à jour.
     */
    public void update(float delta) {
        pacman.update(delta);
        handleInput();
        movePacman(delta);
    }

    /**
     * Gère les entrées utilisateur pour définir la direction souhaitée.
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
     * Déplace Pacman dans la direction souhaitée si possible.
     * 
     * @param delta Le temps écoulé depuis la dernière mise à jour.
     */
    private void movePacman(float delta) {
    	// x:0 y:12  -> x:26 y:12
   
    	
        float nextX = pacman.getX();
        float nextY = pacman.getY();
        float speed = GameConstants.PACMAN_SPEED * delta;

        // Vérifie si Pacman peut se déplacer dans la direction souhaitée
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
     * @param speed La vitesse de déplacement.
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
     * @param speed La vitesse de déplacement.
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
     * Vérifie si Pacman peut se déplacer à une position donnée sans collision.
     * 
     * @param x La position X cible.
     * @param y La position Y cible.
     * @return true si le déplacement est possible, false sinon.
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

/*___________________________________Bibliothèque_______________________________________*/
package com.monjeu.model;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*______________________________________________________________________________________*/

/**
 * Classe abstraite représentant un élément du jeu.
 * Un GameElement possède une position (x, y), une largeur et une hauteur.
 * Les classes dérivées doivent implémenter les méthodes update et render.
 */
public abstract class GameElement {
    protected int x, y;
    protected int width, height;

    /**
     * Constructeur de GameElement.
     * 
     * @param x      Position en x de l'élément.
     * @param y      Position en y de l'élément.
     * @param width  Largeur de l'élément.
     * @param height Hauteur de l'élément.
     */
    public GameElement(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Obtient la position en x de l'élément.
     * 
     * @return La coordonnée x.
     */
    public int getX() {
        return x;
    }

    /**
     * Définit la position en x de l'élément.
     * 
     * @param x Nouvelle coordonnée x.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Obtient la position en y de l'élément.
     * 
     * @return La coordonnée y.
     */
    public int getY() {
        return y;
    }

    /**
     * Définit la position en y de l'élément.
     * 
     * @param y Nouvelle coordonnée y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Obtient la largeur de l'élément.
     * 
     * @return La largeur.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Obtient la hauteur de l'élément.
     * 
     * @return La hauteur.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Met à jour l'état de l'élément.
     * Cette méthode doit être implémentée par les classes dérivées.
     * 
     * @param delta Temps écoulé depuis la dernière mise à jour.
     */
    public abstract void update(float delta);

    /**
     * Affiche l'élément à l'écran.
     * Cette méthode doit être implémentée par les classes dérivées.
     * 
     * @param batch Le SpriteBatch utilisé pour dessiner l'élément.
     */
    public abstract void render(SpriteBatch batch);
}

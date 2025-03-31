/*___________________________________Biblioth�que_______________________________________*/
package com.monjeu.model;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*______________________________________________________________________________________*/

/**
 * Classe abstraite repr�sentant un �l�ment du jeu.
 * Un GameElement poss�de une position (x, y), une largeur et une hauteur.
 * Les classes d�riv�es doivent impl�menter les m�thodes update et render.
 */
public abstract class GameElement {
    protected int x, y;
    protected int width, height;

    /**
     * Constructeur de GameElement.
     * 
     * @param x      Position en x de l'�l�ment.
     * @param y      Position en y de l'�l�ment.
     * @param width  Largeur de l'�l�ment.
     * @param height Hauteur de l'�l�ment.
     */
    public GameElement(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Obtient la position en x de l'�l�ment.
     * 
     * @return La coordonn�e x.
     */
    public int getX() {
        return x;
    }

    /**
     * D�finit la position en x de l'�l�ment.
     * 
     * @param x Nouvelle coordonn�e x.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Obtient la position en y de l'�l�ment.
     * 
     * @return La coordonn�e y.
     */
    public int getY() {
        return y;
    }

    /**
     * D�finit la position en y de l'�l�ment.
     * 
     * @param y Nouvelle coordonn�e y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Obtient la largeur de l'�l�ment.
     * 
     * @return La largeur.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Obtient la hauteur de l'�l�ment.
     * 
     * @return La hauteur.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Met � jour l'�tat de l'�l�ment.
     * Cette m�thode doit �tre impl�ment�e par les classes d�riv�es.
     * 
     * @param delta Temps �coul� depuis la derni�re mise � jour.
     */
    public abstract void update(float delta);

    /**
     * Affiche l'�l�ment � l'�cran.
     * Cette m�thode doit �tre impl�ment�e par les classes d�riv�es.
     * 
     * @param batch Le SpriteBatch utilis� pour dessiner l'�l�ment.
     */
    public abstract void render(SpriteBatch batch);
}

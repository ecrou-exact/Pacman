/*___________________________________Biblioth�que_______________________________________*/
package com.monjeu.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.monjeu.view.TextureFactory;
/*______________________________________________________________________________________*/

/**
 * Classe repr�sentant le personnage Pacman dans le jeu.
 * Pacman est un �l�ment du jeu qui peut se d�placer dans quatre directions
 * et poss�de des animations correspondant � chaque direction.
 */
public class Pacman extends GameElement {
    private String direction;
    private Rectangle hitBoxPacman;
    private float stateTime;
    private boolean isMoving;
    
    private Animation<TextureRegion> pacmanDroiteAnimation;
    private Animation<TextureRegion> pacmanGaucheAnimation;
    private Animation<TextureRegion> pacmanHautAnimation;
    private Animation<TextureRegion> pacmanBasAnimation;

    /**
     * Constructeur de la classe Pacman.
     * @param x Coordonn�e X initiale de Pacman.
     * @param y Coordonn�e Y initiale de Pacman.
     * @param direction Direction initiale de Pacman.
     */
    public Pacman(float x, float y, String direction) {
        super(x, y, GameConstants.PACMAN_SIZE, GameConstants.PACMAN_SIZE);
        hitBoxPacman = new Rectangle(x, y, GameConstants.PACMAN_SIZE, GameConstants.PACMAN_SIZE);
        this.direction = direction;
        this.isMoving = true;
        this.stateTime = 0f;
        this.pacmanDroiteAnimation = TextureFactory.getInstance().getPacmanDroiteAnimation();
        this.pacmanGaucheAnimation = TextureFactory.getInstance().getPacmanGaucheAnimation();
        this.pacmanHautAnimation = TextureFactory.getInstance().getPacmanHautAnimation();
        this.pacmanBasAnimation = TextureFactory.getInstance().getPacmanBasAnimation();
    }

    /**
     * D�finit si Pacman est en mouvement.
     * @param moving true si Pacman est en mouvement, false sinon.
     */
    public void setMoving(boolean moving) {
        this.isMoving = moving;
    }
    public boolean getMoving() {
    	return this.isMoving;
    }

    /**
     * Retourne la direction actuelle de Pacman.
     * @return La direction sous forme de cha�ne de caract�res.
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Modifie la direction de Pacman.
     * @param direction Nouvelle direction.
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Retourne la hitbox de Pacman.
     * @return L'objet Rectangle repr�sentant la hitbox.
     */
    public Rectangle getHitBoxPacman() {
        return hitBoxPacman;
    }

    /**
     * Modifie la hitbox de Pacman.
     * @param hitBoxPacman Nouvelle hitbox.
     */
    public void setHitBoxPacman(Rectangle hitBoxPacman) {
        this.hitBoxPacman = hitBoxPacman;
    }

    /**
     * Met � jour l'�tat de Pacman (temps d'animation et position de la hitbox).
     * @param delta Temps �coul� depuis la derni�re mise � jour.
     */
    @Override
    public void update(float delta) {
        stateTime += delta * 0.4f;
        hitBoxPacman.setPosition(getX(), getY());
    }

    /**
     * 
     * Dessine Pacman � l'�cran en fonction de sa direction et de son �tat de mouvement.
     * @param batch SpriteBatch utilis� pour dessiner Pacman.
     */
    @Override
    public void render(SpriteBatch batch) {
        TextureRegion frame = null;
        
        switch (direction) {
            case "gauche":
                frame = isMoving ? pacmanGaucheAnimation.getKeyFrame(stateTime, true) 
                                 : pacmanGaucheAnimation.getKeyFrames()[getFrameIndex(pacmanGaucheAnimation)];
                break;
            case "droite":
                frame = isMoving ? pacmanDroiteAnimation.getKeyFrame(stateTime, true) 
                                 : pacmanDroiteAnimation.getKeyFrames()[getFrameIndex(pacmanDroiteAnimation)];
                break;
            case "haut":
                frame = isMoving ? pacmanHautAnimation.getKeyFrame(stateTime, true) 
                                 : pacmanHautAnimation.getKeyFrames()[getFrameIndex(pacmanHautAnimation)];
                break;
            case "bas":
                frame = isMoving ? pacmanBasAnimation.getKeyFrame(stateTime, true) 
                                 : pacmanBasAnimation.getKeyFrames()[getFrameIndex(pacmanBasAnimation)];
                break;
        }
        
        if (frame != null) {
            batch.draw(frame, getX(), getY(), (width-1), (height-1));
        }
    }
    
    /**
     * Retourne l'index de l'image � afficher lorsque Pacman est immobile.
     * @param animation L'animation correspondant � la direction de Pacman.
     * @return L'index de l'image � afficher.
     */
    private int getFrameIndex(Animation<TextureRegion> animation) {
        return (int) ((stateTime / animation.getFrameDuration()) % animation.getKeyFrames().length);
    }
}

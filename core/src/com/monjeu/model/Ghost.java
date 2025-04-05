package com.monjeu.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.monjeu.view.TextureFactory;

public class Ghost extends GameElement{
	private String direction;
    private Rectangle hitBoxGhost;
    private String couleur;
    private boolean isEatAble = false;
    private float stateTime;
    private boolean isMoving;
    
    private float initX;
    private float initY;

	public Ghost(float x, float y, String direction, String color) {
		 super(x, y, GameConstants.GHOST_SIZE, GameConstants.GHOST_SIZE);
	        hitBoxGhost = new Rectangle(x, y, GameConstants.GHOST_SIZE, GameConstants.GHOST_SIZE);
	        this.direction = direction;
	        this.couleur = color;
	        this.isMoving = true;
	        this.stateTime = 0f;
	}
	/**
     * Définit si Ghost est en mouvement.
     * @param moving true si Ghost est en mouvement, false sinon.
     */
    public void setMoving(boolean moving) {
        this.isMoving = moving;
    }
    public boolean getMoving() {
    	return this.isMoving;
    }
    /**
     * Retourne la direction actuelle de Ghost.
     * @return La direction sous forme de chaîne de caractères.
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Modifie la direction de Ghost.
     * @param direction Nouvelle direction.
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Retourne la hitbox de Ghost.
     * @return L'objet Rectangle représentant la hitbox.
     */
    public Rectangle getHitBoxPacman() {
        return hitBoxGhost;
    }

    /**
     * Modifie la hitbox de Ghost.
     * @param hitBoxPacman Nouvelle hitbox.
     */
    public void setHitBoxPacman(Rectangle hitBoxGhost) {
        this.hitBoxGhost = hitBoxGhost;
    }
    

    public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		couleur = couleur;
	}
	public boolean getIsEatAble() {
		return isEatAble;
	}
	public void setEatAble(boolean isEatAble) {
		this.isEatAble = isEatAble;
	}
	/**
     * Met à jour l'état de Ghost (temps d'animation et position de la hitbox).
     * @param delta Temps écoulé depuis la dernière mise à jour.
     */
    @Override
    public void update(float delta) {
        stateTime += delta * 0.4f;
        hitBoxGhost.setPosition(getX(), getY());
    }


	@Override
	public void render(SpriteBatch batch) {
		if(this.getIsEatAble() == true) {
			batch.draw(TextureFactory.getInstance().getFantomeEatAble(), getX(), getY(), width, height);
		}else {
			if(this.getCouleur().equals("rouge")) {
				batch.draw(TextureFactory.getInstance().getFantome1(), getX(), getY(), width, height);
			}
			if(this.getCouleur().equals("rose")) {
				batch.draw(TextureFactory.getInstance().getFantome2(), getX(), getY(), width, height);
			}
			if(this.getCouleur().equals("bleu")) {
				batch.draw(TextureFactory.getInstance().getFantome3(), getX(), getY(), width, height);
			}
			if(this.getCouleur().equals("jaune")) {
				batch.draw(TextureFactory.getInstance().getFantome4(), getX(), getY(), width, height);
			}
		}
		
		
		

	}

}

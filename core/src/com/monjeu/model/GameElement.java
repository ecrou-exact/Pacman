package com.monjeu.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class GameElement {
	protected int x, y;
	protected int width, height;

	 public GameElement(int x, int y, int width, int height) {
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.height = height;
	    }
	 
	 
	 public boolean collidesWith(GameElement element) {
		    return x < element.getX() + element.getWidth() &&
		           x + width > element.getX() &&
		           y < element.getY() + element.getHeight() &&
		           y + height > element.getY();
		}
	 
	 public abstract Rectangle getHitBox();
	 public int getX() {
	        return x;
	    }

	    public void setX(int x) {
	        this.x = x;
	    }

	    public int getY() {
	        return y;
	    }

	    public void setY(int y) {
	        this.y = y;
	    }

	    public int getWidth() {
	        return width;
	    }

	    public int getHeight() {
	        return height;
	    }

	    public Rectangle getBounds() {
	        return new Rectangle(x, y, width, height);
	    }

	
	// M�thode pour mettre � jour l'�tat de l'objet (par exemple, mouvement, animation, etc.)
    public abstract void update(float delta);

    // M�thode pour afficher l'objet (ne sera pas utilis� ici mais peut �tre surcharg� dans des sous-classes)
    public abstract void render(SpriteBatch batch);
}

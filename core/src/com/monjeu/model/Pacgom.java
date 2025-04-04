package com.monjeu.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.monjeu.view.TextureFactory;

public class Pacgom extends GameElement {
	private Rectangle hitBoxMur;
	private boolean active = true;
	
	public Pacgom(float x, float y) {
        super(x, y, GameConstants.PACGOM_SIZE,GameConstants.PACGOM_SIZE);
        hitBoxMur =  new Rectangle(x, y, GameConstants.PACGOM_SIZE, GameConstants.PACGOM_SIZE);
	}
	
    public Rectangle getHitBox() {
    	return hitBoxMur;
    }
	
    @Override
    public void update(float delta) {
    }

    @Override
	public void render(SpriteBatch batch) {
		batch.draw(TextureFactory.getInstance().getBoule(),this.getX(), this.getY(), GameConstants.PACGOM_SIZE + 4, GameConstants.PACGOM_SIZE + 4);
    }
    
    public boolean getActive() {
		return active;
	}
    
    public void setActive(boolean a) {
		active = a;
	}
}

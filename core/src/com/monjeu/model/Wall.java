package com.monjeu.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.monjeu.view.TextureFactory;

public class Wall extends GameElement {
	private Rectangle hitBoxMur;

	public Wall(float x, float y) {
        super(x, y , GameConstants.WALL_SIZE,GameConstants.WALL_SIZE);
        hitBoxMur =  new Rectangle(x, y, GameConstants.WALL_SIZE, GameConstants.WALL_SIZE);
    }
	
	public Rectangle getHitBox() {
		return hitBoxMur;
	}

	@Override
	public void update(float delta) {
		hitBoxMur.setPosition(getX(), getY());
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(TextureFactory.getInstance().getBloc(),this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	}

}

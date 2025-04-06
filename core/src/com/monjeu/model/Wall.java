package com.monjeu.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.monjeu.view.TextureFactory;

public class Wall extends GameElement {
	private int type;
	private Rectangle hitBoxMur;

	public Wall(float x, float y, int type) {
        super(x, y , GameConstants.WALL_SIZE,GameConstants.WALL_SIZE);
        this.type = type;
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
			switch (this.type) {
			case 0:
	            batch.draw(TextureFactory.getInstance().getBloc0(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
			case 1:
	            batch.draw(TextureFactory.getInstance().getBloc1(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 2:
	            batch.draw(TextureFactory.getInstance().getBloc2(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 3:
	            batch.draw(TextureFactory.getInstance().getBloc3(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 4:
	            batch.draw(TextureFactory.getInstance().getBloc4(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 5:
	            batch.draw(TextureFactory.getInstance().getBloc5(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 6:
	            batch.draw(TextureFactory.getInstance().getBloc6(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 7:
	            batch.draw(TextureFactory.getInstance().getBloc7(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 8:
	            batch.draw(TextureFactory.getInstance().getBloc8(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 9:
	            batch.draw(TextureFactory.getInstance().getBloc9(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 10:
	            batch.draw(TextureFactory.getInstance().getBloc10(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 11:
	            batch.draw(TextureFactory.getInstance().getBloc11(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 12:
	            batch.draw(TextureFactory.getInstance().getBloc12(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 13:
	            batch.draw(TextureFactory.getInstance().getBloc13(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        case 14:
	            batch.draw(TextureFactory.getInstance().getBloc14(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	        default:
	            batch.draw(TextureFactory.getInstance().getBloc14(), this.getX(), this.getY(), GameConstants.WALL_SIZE + 4, GameConstants.WALL_SIZE + 4);
	            break;
	    }
		
	}

}

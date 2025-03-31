package com.monjeu.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.monjeu.view.TextureFactory;

public class Pacman extends GameElement{
	private String direction;
	private Rectangle hitBoxPacman;
	
	
	private float stateTime;
	private boolean isMoving;
	
	private Animation<TextureRegion> pacmanDroiteAnimation;
    private Animation<TextureRegion> pacmanGaucheAnimation;
    private Animation<TextureRegion> pacmanHautAnimation;
    private Animation<TextureRegion> pacmanBasAnimation;

	public Pacman(int x, int y, String direction) {
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
	 public void setMoving(boolean moving) {
	        if (this.isMoving != moving && moving) {
	        }
	        this.isMoving = moving;
	    }

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Rectangle getHitBoxPacman() {
		return hitBoxPacman;
	}

	public void setHitBoxPacman(Rectangle hitBoxPacman) {
		this.hitBoxPacman = hitBoxPacman;
	}

	@Override
	public void update(float delta) {
		stateTime += delta * 0.4f;
	     hitBoxPacman.setPosition(getX(), getY());	
	}

	@Override
	public void render(SpriteBatch batch) {
		if (direction.equals("gauche")) {
		    TextureRegion frame;
		    if (isMoving) {
		        frame = pacmanGaucheAnimation.getKeyFrame(stateTime, true);
		    } else {
		        int frameIndex = (int) ((stateTime / pacmanGaucheAnimation.getFrameDuration()) 
		                                % pacmanGaucheAnimation.getKeyFrames().length);
		        frame = pacmanGaucheAnimation.getKeyFrames()[frameIndex];
		    }
		    batch.draw(frame, getX(), getY(), width, height);
		} else if (direction.equals("droite")) {
		    TextureRegion frame;
		    if (isMoving) {
		        frame = pacmanDroiteAnimation.getKeyFrame(stateTime, true);
		    } else {
		        int frameIndex = (int) ((stateTime / pacmanDroiteAnimation.getFrameDuration()) 
		                                % pacmanDroiteAnimation.getKeyFrames().length);
		        frame = pacmanDroiteAnimation.getKeyFrames()[frameIndex];
		    }
		    batch.draw(frame, getX(), getY(), width, height);
		} else if (direction.equals("haut")) {
		    TextureRegion frame;
		    if (isMoving) {
		        frame = pacmanHautAnimation.getKeyFrame(stateTime, true);
		    } else {
		        int frameIndex = (int) ((stateTime / pacmanHautAnimation.getFrameDuration()) 
		                                % pacmanHautAnimation.getKeyFrames().length);
		        frame = pacmanHautAnimation.getKeyFrames()[frameIndex];
		    }
		    batch.draw(frame, getX(), getY(), width, height);
		} if (direction.equals("bas")) {
		    TextureRegion frame;
		    if (isMoving) {
		        frame = pacmanBasAnimation.getKeyFrame(stateTime, true);
		    } else {
		        int frameIndex = (int) ((stateTime / pacmanBasAnimation.getFrameDuration()) 
		                                % pacmanBasAnimation.getKeyFrames().length);
		        frame = pacmanBasAnimation.getKeyFrames()[frameIndex];
		    }
		    batch.draw(frame, getX(), getY(), width, height);
		}

		
	}

}

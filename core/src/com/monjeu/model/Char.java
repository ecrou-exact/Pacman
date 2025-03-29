package com.monjeu.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Char extends GameElement {
	private int speed;
	private String direction;
	
	// New fields for shooting delays
    private float initialShootDelay;
    private float burstShootDelay;

	public Char(int x, int y, int speed, String direction, float initialShootDelay, float burstShootDelay) {
		 super(x, y , 32,32);
		 this.direction = direction;
		 this.speed = speed;
		 this.initialShootDelay = initialShootDelay;
	     this.burstShootDelay = burstShootDelay;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public float getInitialShootDelay() {
        return initialShootDelay;
    }

    public void setInitialShootDelay(float initialShootDelay) {
        this.initialShootDelay = initialShootDelay;
    }

    public float getBurstShootDelay() {
        return burstShootDelay;
    }

    public void setBurstShootDelay(float burstShootDelay) {
        this.burstShootDelay = burstShootDelay;
    }
    

	@Override
	public Rectangle getHitBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

	public float getSpeed() {
		return this.speed;
	}

}

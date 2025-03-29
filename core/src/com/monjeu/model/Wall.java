package com.monjeu.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.monjeu.view.TextureFactory;

public class Wall extends GameElement {
	private Rectangle hitBoxWall;
	private String direction;
	private int speed;
	private int active;
	private int initX;
	private int initY;
    public Wall(int x, int y, String dir, int speed) {
        super(x, y , 32,32);
        this.direction = dir;
        this.speed = speed;
        hitBoxWall =  new Rectangle(x, y, 32, 32);
        active = 1;
        initX = x;
        initY = y;
    }
    
    public void reset() {
    	x = initX;
    	y = initY;
    }
    
    public int getActive() {
		return active;
	}



	public void setActive(int active) {
		this.active = active;
	}



	public void setHitBoxLettre(Rectangle r) {
    	hitBoxWall = r;
    }
    
    
    public String getDirection() {
		return direction;
	}






	public void setDirection(String direction) {
		this.direction = direction;
	}






	public int getSpeed() {
		return speed;
	}






	public void setSpeed(int speed) {
		this.speed = speed;
	}






	@Override
    public Rectangle getHitBox() {
		return hitBoxWall;
	}
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}



	
}

package com.monjeu.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class Bullet extends GameElement {
	int speed;
	int delai;
	public Circle hitBox;

	public Bullet(int x, int y, int speed, int delai) {
		super(x, y , 32,32);
		 this.delai = delai;
		 this.speed = speed;
		 hitBox = new Circle(x,y,16);
	}
	
	
	public void setHitBoxBalle(Circle newHitBox) {
		this.hitBox = newHitBox;
	}

	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getDelai() {
		return delai;
	}


	public void setDelai(int delai) {
		this.delai = delai;
	}


	@Override
	public Rectangle getHitBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(float delta) {
	
		
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

}

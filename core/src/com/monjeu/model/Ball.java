package com.monjeu.model;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Ball extends GameElement {
	private int speed ; 
	private Circle hitBoxBall;
	
	
	private float speedX;
	private float speedY;
	private boolean directionSet = false;

	
    public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public Ball(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		this.speed = speed;
		hitBoxBall = new Circle(x,y,16);
	}

    public boolean isDirectionSet() {
        return directionSet;
    }
    public void setDirectionSet(boolean directionSet) {
        this.directionSet = directionSet;
    }


    /*@Override
    public void create() {
        batch = new SpriteBatch();
        ballTexture = new Texture("ball.png"); // Image de la balle (20x20 px)

        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();

        // Position initiale au centre
        x = screenWidth / 2f - ballSize / 2f;
        y = screenHeight / 2f - ballSize / 2f;

        // Direction aléatoire
        float angle = MathUtils.random(0f, 360f);
        vx = MathUtils.cosDeg(angle) * speed;
        vy = MathUtils.sinDeg(angle) * speed;
    }*/

    public void render() {
       
    }

    public void update(float deltaTime) {
        /*// Met à jour la position
        x += vx * deltaTime;
        y += vy * deltaTime;

        // Gestion des rebonds
        if (x <= 0 || x + ballSize >= screenWidth) {
            vx = -vx; // Inverse la vitesse horizontale
        }
        if (y <= 0 || y + ballSize >= screenHeight) {
            vy = -vy; // Inverse la vitesse verticale
        }*/
    }

  
    public void dispose() {
        
    }

    public int getSpeed() {
    	return speed;
    }

	@Override
	public Rectangle getHitBox() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}



	public void setHitBoxBall(Circle newHitBox) {
		this.hitBoxBall = newHitBox;
		
	}
}

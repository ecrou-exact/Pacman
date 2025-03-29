package com.monjeu.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.monjeu.model.Bullet;
import com.monjeu.model.Char;
import com.monjeu.model.Explosion;
import com.monjeu.model.Wall;
import com.monjeu.model.World;

public class CharController {

	 private World world;
	 private Array<Wall> mesLettres;
	 private Char monChar;
	 
	 private Explosion playerExplosion = null;
	
	 
	 private float shootTimer;
	 private boolean spacePreviouslyPressed;
	 
	
	 
	 
	public CharController(Array<Wall> mesLettres, Char monChar ,World world) {
		 this.world = world;
		 this.monChar = monChar;
		 this.mesLettres = mesLettres;
		 
		 this.shootTimer = monChar.getInitialShootDelay();
	     this.spacePreviouslyPressed = false;
	}
	public boolean peutALlerGauche(int x) {
		if(x < 1) {
			return false;
		}else {
			return true;
		}
	}
	public boolean peutALlerDroite(int x) {
		if(x > 850) {
			return false;
		}else {
			return true;
		}
	}
	
	
	
	
	
	
	
	 public void update(float delta) {
		 
		 
		   
	
		
		    if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ) {
		        if (peutALlerGauche(monChar.getX() - 1)) {
		            monChar.setX((int) (monChar.getX() - monChar.getSpeed() * delta));
		           
		            if (!monChar.getDirection().equals("left")) {
		            	monChar.setDirection("left");
		            }
		            
		        }
		    }
		    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
		        if (peutALlerDroite(monChar.getX() + 1)) {
		        	monChar.setX((int) (monChar.getX() + monChar.getSpeed() * delta));
		            if (!monChar.getDirection().equals("right")) {
		            	monChar.setDirection("right");
		            }
		            
		        }
		    }
		    
		    if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
	          
		    	if (!spacePreviouslyPressed) {
	                // First press: shoot immediately
	                shootProjectile();
	                // Set timer to burst delay from the player's configuration
	                shootTimer = monChar.getBurstShootDelay();
	                spacePreviouslyPressed = true;
	            } else {
	                shootTimer -= delta;
	                if (shootTimer <= 0) {
	                    shootProjectile();
	                    shootTimer = monChar.getBurstShootDelay();
	                }
	            }
	        } else {
	            spacePreviouslyPressed = false;
	            shootTimer = monChar.getInitialShootDelay();
	        }
		    
		    
		    
		    for (Bullet element : world.getMesBalles()) {
		    	
				  element.setY((int) (element.getY() + element.getSpeed()* delta));
				  if(element.getY() > 650) {
			    		world.retirerBalle(element);
			    }
				  
				// update de la hitbox
			        Circle newHitBox = new Circle(element.getX(), element.getY(),16);
			        element.setHitBoxBalle(newHitBox); 
			        
			        touche(element);
			        
			        
			        
			 
			        
			  }
		    
		    
		    
	 }
	 
	  private void shootProjectile() {
	        
	        // Create the projectile at the center of the player
		  
	        Bullet projectile = new Bullet(
	        		monChar.getX() + monChar.getWidth() / 2,
	            monChar.getY() + monChar.getHeight() / 2,
	            200,3
	        );
	        // Add the projectile to the world's game elements
	        world.getMesBalles().add(projectile);
	        //System.out.println("Player shoots " + (projectileDirection == 1 ? "right" : "left"));
	    }
	  
	  
	  public void touche(Bullet balle) {
		  Rectangle testHitBox = new Rectangle(balle.getX(), balle.getY() + 2, balle.getWidth(), balle.getHeight() );
		  for (Wall element : world.getLettre()) {
	            if (element instanceof Wall && testHitBox.overlaps(element.getHitBox())) {
	            	
	            	Wall monWall = element;
	            	monWall.setActive(0);
	            	world.retirerLettre(element);
	            	world.retirerBalle(balle);
	            	
	            	
	            	playerExplosion = new Explosion(monWall.getX(), monWall.getY());
                    world.getGameElements().add(playerExplosion);
	                
	            }
	        }
	        
	  }
	  
	  
	 

}

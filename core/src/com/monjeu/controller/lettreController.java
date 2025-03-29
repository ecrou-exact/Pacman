package com.monjeu.controller;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.monjeu.model.GameElement;
import com.monjeu.model.Wall;
import com.monjeu.model.World;

public class lettreController {

	 private World world;
	 private Array<Wall> mesLettres;
	
	
	public lettreController(Array<Wall> mesLettres, World world) {
		 this.world = world;
		 this.mesLettres = mesLettres;
	}
	 public void update(float delta) {
		 for (Wall element : world.getLettre()) {
			 
			 Rectangle newHitBox = new Rectangle(element.getX(), element.getY(), element.getWidth(), element.getHeight());
			 element.setHitBoxLettre(newHitBox);
			 
			 
			 
			 if(element.getDirection().equals("droite")) {
				 element.setX((int) (element.getX() + element.getSpeed() * delta));
			 }else {
				 element.setX((int) (element.getX() - element.getSpeed() * delta));
			 }
	        }
		 for (Wall element : world.getLettre()) {
			 if(element.getX() < 4) {
				 if(element.getDirection().equals("gauche")) {
					 element.setDirection("droite");
				 }
			 }else if(element.getX() > 850) {
				 if(element.getDirection().equals("droite")) {
					 element.setDirection("gauche");
				 }
			 }
			 
			
	     }
		 
	 }

}

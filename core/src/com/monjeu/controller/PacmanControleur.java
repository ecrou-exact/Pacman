package com.monjeu.controller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.monjeu.model.GameConstants;
import com.monjeu.model.Pacman;
import com.monjeu.model.World;

public class PacmanControleur {
	 private Pacman pacman;
	 private World world;


	public PacmanControleur(Pacman pacman, World world) {
		this.pacman = pacman;
        this.world = world;
	}
	public void update(float delta) {
		
		pacman.update(delta);
		
		 if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			 pacman.setDirection("gauche");
			 if(peutSeDiriger() == true) {
				 pacman.setX((int) (pacman.getX() - GameConstants.PACMAN_SPEED * delta));
			 }
		 }
		 if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			 pacman.setDirection("droite");
		 }
		 if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			 pacman.setDirection("haut");
		 }
		 if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			 pacman.setDirection("bas");
		 }		 
	}
	
	
	public boolean peutSeDiriger() {
		//to do
		
		return true;
	}

}

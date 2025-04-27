package com.monjeu.controller;

import com.monjeu.model.GameElement;
import com.monjeu.model.Ghost;
import com.monjeu.model.World;
//import com.monjeu.model.Pacman;
//import java.util.ArrayList;
//import java.util.Random;

public class GhostControleur {
	private World world;
	//private Ghost ghost;
	//private Pacman pacman;
	//private Random random = new Random();
	
	public GhostControleur(World world) { //, Ghost ghost, Pacman pacman
		this.world = world;
		//this.ghost = ghost;
		//this.pacman = pacman;
	}
	
	public void update(float delta) {
		for (GameElement element : world.getGameElements()) {
            if (element instanceof Ghost) {
                element.update(delta);
            }
        }
    }
	
	//private void moveRandomly(Ghost ghost) {
	//}
}

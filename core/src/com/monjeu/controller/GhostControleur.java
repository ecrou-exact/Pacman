package com.monjeu.controller;

import com.monjeu.model.GameElement;
import com.monjeu.model.Ghost;
import com.monjeu.model.Wall;
import com.monjeu.model.World;

public class GhostControleur {

	private World world;
	
	public GhostControleur(World world) {
		this.world = world;
	}
	public void update(float delta) {
		for (GameElement element : world.getGameElements()) {
            if (element instanceof Ghost) {
                element.update(delta);
            }
        }
    }

}

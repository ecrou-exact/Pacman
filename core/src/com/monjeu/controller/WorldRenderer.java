package com.monjeu.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.monjeu.model.GameElement;
import com.monjeu.model.Pacman;
import com.monjeu.model.World;
import com.monjeu.view.GameOverScreen;
import com.monjeu.view.GameWonScreen;
import com.monjeu.view.MainGame;
import com.monjeu.view.TextureFactory;

public class WorldRenderer {
    private World world;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private BitmapFont font;
    
    private PacmanControleur pacmanControleur;
    private GhostControleur ghostControleur;


    
    // Game over flag and player explosion reference (if needed)
    private boolean gameOver = false;
    private int ScorePacman = 0 ; 
    
    private MainGame mainGame;
    
    public WorldRenderer(World world, OrthographicCamera camera,MainGame mainGame) {
        this.world = world;
        this.batch = new SpriteBatch();
        this.camera = camera; 
        this.mainGame = mainGame;
        font = new BitmapFont();
        
        pacmanControleur = new PacmanControleur(world.getPacman(), world, this);
        ghostControleur = new GhostControleur( world);
    }
    
    public void render(float delta) {
    	
    	pacmanControleur.update(delta);
    	ghostControleur.update(delta);
    	
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        
        
      
        
        // afficher les murs
        
        for (GameElement element : world.getGameElements()) {
        	if (element instanceof com.monjeu.model.Wall) {
                element.render(batch);
            }
        	if (element instanceof com.monjeu.model.Ghost) {
                element.render(batch);
            }
        	if (element instanceof com.monjeu.model.Pacgom) {							// J'ai rajouté ca
        		if (((com.monjeu.model.Pacgom) element).getActive() == true) {
        			element.render(batch);
        		}
        	}
        }
        
        // afficher Pacman
        Pacman pacman = world.getPacman();
        pacman.render(batch);
        
        
        
        String ScoreMessage= "Scores :  " + this.ScorePacman;
        font.getData().setScale(2);
        font.draw(batch,  ScoreMessage, 10,  camera.viewportHeight - 30);
        
        batch.end();
    }
    
   
    
    public int getScorePacman() {
    	
		return ScorePacman;
	}

	public void setScorePacman(int scorePacman) {
		ScorePacman = scorePacman;
	}
	
	public void rajoutePoint(int scorePacman) {
		this.ScorePacman = this.ScorePacman + scorePacman;
	}

	public void dispose() {
        batch.dispose();
        font.dispose();
    }
    
    public void update(float delta) {
        world.update(delta);
    }
}

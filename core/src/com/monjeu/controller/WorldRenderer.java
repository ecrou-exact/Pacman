package com.monjeu.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.monjeu.model.Ball;
import com.monjeu.model.Bullet;
import com.monjeu.model.Char;
import com.monjeu.model.Explosion;
import com.monjeu.model.GameElement;
import com.monjeu.model.Wall;
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
    private lettreController monControlleurLettre;
    private CharController monCharControlleur;
   
    private static final int TILE_SIZE = 32;
    private static final int PLAYER_SIZE = 25;
    
    // Game over flag and player explosion reference (if needed)
    private boolean gameOver = false;
   
    
    private MainGame mainGame;
    
    public WorldRenderer(World world, OrthographicCamera camera,MainGame mainGame) {
        this.world = world;
        this.batch = new SpriteBatch();
        this.camera = camera; 
        this.mainGame = mainGame;
        
        
        monControlleurLettre = new lettreController(world.getLettre(),world);
        monCharControlleur = new CharController(world.getLettre(), world.getChar(),world); 
        
        font = new BitmapFont();
    }
    
    public void render(float delta) {
    	
    	monControlleurLettre.update(delta);
    	monCharControlleur.update(delta);
    	
    	
    	 // explosions)
        for (int i = world.getGameElements().size - 1; i >= 0; i--) {
            GameElement element = world.getGameElements().get(i);
            if (element instanceof Explosion) {
                Explosion explosion = (Explosion) element;
                explosion.update(delta);
                if (explosion.isFinished()) {
                    if (explosion.getEnemyToReset() != null) {
                        Wall enemy = explosion.getEnemyToReset();
                        enemy.reset(); // Reset enemy to initial state (position and speed)
                        world.getGameElements().add(enemy);
                        world.getLettre().add(enemy);
                        explosion.clearEnemyToReset();
                    }
                    world.getGameElements().removeIndex(i);
                }
            }
        }
    	 
    	
    	
    	
       
        
        // 6) Begin rendering
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        
        // Render walls and ladders
        for (GameElement element : world.getGameElements()) {
            if (element instanceof com.monjeu.model.Wall) {
            	if(((com.monjeu.model.Wall) element).getActive()==1) {
            		batch.draw(TextureFactory.getInstance().getLettre(), 
                            element.getX(), element.getY(), TILE_SIZE, TILE_SIZE);
            	}
                
            } 
        }
        
        
       Char monChar =  world.getChar();
    	//new Char(10 * TILE_SIZE , 1 * TILE_SIZE);
       
       batch.draw(TextureFactory.getInstance().getChar(), monChar.getX(), monChar.getY(), TILE_SIZE, TILE_SIZE);
        
       
       
       for (Bullet element : world.getMesBalles()) {
           
           batch.draw(TextureFactory.getInstance().getBall(),
                   element.getX(), element.getY(), element.getWidth(), element.getHeight());
       
   }
       
       
        
        
        if(world.getLettre().size == 0 ) {
       	 font.draw(batch, "You WON", camera.viewportWidth / 2 - 50, camera.viewportHeight / 2);

            // Aller vers la page de Game Over
            ((Game) Gdx.app.getApplicationListener()).setScreen(new GameWonScreen(mainGame));
       }
        
        // Enable blending for transparent explosions
        //batch.enableBlending();
        // Render explosions
        for (GameElement element : world.getGameElements()) {
            if (element instanceof Explosion) {
                ((Explosion) element).render(batch);
            }
        }
        //batch.disableBlending();

        
        batch.end();
    }
    
   
    
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
    
    public void update(float delta) {
        world.update(delta);
    }
}

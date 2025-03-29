package com.monjeu.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureFactory {
    private static TextureFactory instance;
    
    // Existing textures
    private Texture brick;
    private Texture ball;
    private Texture explosionSheet;
    private Texture Background;
    private Texture Canon;
    private Texture mesLettres;
    private Texture balles;
    private Texture ExplosionSheet;

    
    private TextureFactory() {
        // Load existing textures
        brick = new Texture(Gdx.files.internal("textures/brick.png"));
        ball = new Texture(Gdx.files.internal("textures/RoundBullet.png"));
        Background = new Texture(Gdx.files.internal("textures/Fond/background.png"));
        Canon = new Texture(Gdx.files.internal("textures/Char/char.png"));
        mesLettres = new Texture(Gdx.files.internal("textures/Lettres/A.png"));
        balles = new Texture(Gdx.files.internal("textures/projectile/bullet.png"));
        ExplosionSheet = new Texture(Gdx.files.internal("textures/Explosion/Explosion.png"));
    }
    
    public static TextureFactory getInstance() {
        if (instance == null) {
            instance = new TextureFactory();
        }
        return instance;
    }
    public Texture getBalles() {
    	return balles;
    }
    public Texture getExplosionSheet() {
    	return ExplosionSheet;
    }
  
    
    
    public Texture getChar() {
    	return Canon;
    }
  
    public Texture getFondEcran() {
    	return Background;
    }
    public Texture getLettre() {
    	return mesLettres;
    }
    
    
    public Texture getTextureBrick() {
        return brick;
    }
    
 
    public Texture getBall() {
        return ball;
    }
    
    
 // 
    
    // Dispose all textures when no longer needed
    public void dispose() {
        brick.dispose();
        ball.dispose();
        explosionSheet.dispose();
        
       
    }
}

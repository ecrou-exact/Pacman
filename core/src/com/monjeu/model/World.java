package com.monjeu.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class World {
    //private String background;
    private int width;
    private int height;
    private Array<GameElement> gameElements;
    private Array<Wall> mesLettres;
    private Array<Bullet> mesBalles;
    
   private Char charVrai;

   

    // Taille des blocs (32x32)
    private static final int TILE_SIZE = 32;

    // Constructeur pour initialiser le niveau
    public World() {
        gameElements = new Array<GameElement>();
        mesLettres  = new Array<Wall>();
        mesBalles = new Array<Bullet>();
        loadLevel("levels/level1.json");
    };
    
    
    
    public void retirerLettre(Wall maLettre) {
    	for (int i = mesLettres.size - 1; i >= 0; i--) {
			Wall element = mesLettres.get(i);
			if(element == maLettre) {
				mesLettres.removeIndex(i);
			}
		}
    }
    
    
    
    
    public Array<Wall> getLettre(){
    	return this.mesLettres;
    }
    
 
  
    
    public Array<Bullet> getMesBalles() {
		return mesBalles;
	}
    
    
  
    

	public void setMesBalles(Array<Bullet> mesBalles) {
		this.mesBalles = mesBalles;
	}
	public void retirerBalle(Bullet maBalle) {
		for (int i = mesBalles.size - 1; i >= 0; i--) {
			Bullet element = mesBalles.get(i);
			if(element == maBalle) {
				mesBalles.removeIndex(i);
			}
		}
	}

	// Méthode pour charger le niveau depuis un fichier JSON
    private void loadLevel(String filePath) {
        FileHandle file = Gdx.files.internal(filePath);
        Json json = new Json();
        LevelData levelData = json.fromJson(LevelData.class, file.readString());

        // Charger les informations de base du niveau
        //this.background = levelData.background;
        this.width = levelData.width;
        this.height = levelData.height;

        //charger les informations de la balle
        
       this.charVrai = new Char( levelData.char1.x * TILE_SIZE,
                levelData.char1.y * TILE_SIZE, levelData.char1.speed , 
                levelData.char1.direction ,levelData.char1.initialShootDelay,
                levelData.char1.burstShootDelay);
       
       

        // Charger les murs
        for (LevelData.WallData wall : levelData.walls) {
            Wall wallObj = new Wall(wall.x * TILE_SIZE, wall.y * TILE_SIZE, wall.direction, wall.speed);
            gameElements.add(wallObj);
            mesLettres.add(wallObj);
        }
       
    }
    

    // Méthode pour obtenir tous les éléments du jeu
    public Array<GameElement> getGameElements() {
        return gameElements;
    }
    
 
    public Char getChar() {
    	return this.charVrai;
    }
    
   
    
    // Méthode de rendu pour afficher les éléments à l'écran (vide ici)
    public void render(float delta) {}

    // Classe interne pour représenter les données du niveau
    private static class LevelData {
      
		public String background;
        public int width;
        public int height;
        public BallData ball;
        public Array<WallData> walls;
        public CharData char1;
       

        public static class BallData {
            public int x;
            public int y;
            public int speed;
          
        }
       
        public static class WallData {
            public int x;
            public int y;
            public String direction;
            public int speed;
        }
        
        public static class CharData{
        	public int x;
            public int y;
            public int speed;
            public String direction;
            public float initialShootDelay;
            public float burstShootDelay;
        }

    }
    
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
   
    
    public static int getTileSize() {
        return TILE_SIZE;
    }
    
    public void setGameElements(Array<GameElement> gameElements) {
        this.gameElements = gameElements;
    }
    
    public void update(float delta) {
    	
    }

	
}

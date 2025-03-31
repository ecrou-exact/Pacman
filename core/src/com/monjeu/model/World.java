/*___________________________________Biblioth�que_______________________________________*/
package com.monjeu.model;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
/*______________________________________________________________________________________*/

/**
 * Classe repr�sentant le monde du jeu.
 * Elle g�re les �l�ments du jeu et le chargement des niveaux.
 */
public class World {
    
    /**
     * Chemin de l'image de fond du niveau.
     */
    private String background;
    
    /**
     * Liste des �l�ments du jeu pr�sents dans le monde.
     */
    private Array<GameElement> gameElements;
    private Pacman pacman;

    /**
     * Constructeur qui initialise le monde et charge un niveau par d�faut.
     */
    public World() {
        gameElements = new Array<GameElement>();
        loadLevel("levels/level1.json");
    }
    
    /**
     * Charge les donn�es d'un niveau depuis un fichier JSON.
     * 
     * @param filePath Chemin du fichier JSON contenant les donn�es du niveau.
     */
    private void loadLevel(String filePath) {
        FileHandle file = Gdx.files.internal(filePath);
        Json json = new Json();
        LevelData levelData = json.fromJson(LevelData.class, file.readString());

        // Charger les informations de base du niveau
        this.background = levelData.background;
        this.pacman = new Pacman( 
        		levelData.pacman.x * 32/*GameConstants.PACMAN_SIZE*/,
                levelData.pacman.y * 32/*GameConstants.PACMAN_SIZE*/,
                levelData.pacman.direction);
     
      
        
        
        // Charger les murs
        for (LevelData.WallData wall : levelData.walls) {
            Wall wallObj = new Wall(wall.x * GameConstants.WALL_SIZE, wall.y * GameConstants.WALL_SIZE);
            gameElements.add(wallObj);
        }
    }
    


	/**
     * Retourne la liste des �l�ments du jeu pr�sents dans le monde.
     * 
     * @return Liste des �l�ments du jeu.
     */
    public Array<GameElement> getGameElements() {
        return gameElements;
    }

    /**
     * D�finit la liste des �l�ments du jeu.
     * 
     * @param gameElements Nouvelle liste des �l�ments du jeu.
     */
    public void setGameElements(Array<GameElement> gameElements) {
        this.gameElements = gameElements;
    }
    

    public Pacman getPacman() {
		return pacman;
	}

	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}

	/**
     * Met � jour l'�tat du monde.
     * 
     * @param delta Temps �coul� depuis la derni�re mise � jour.
     */
    public void update(float delta) {
        // Impl�mentation future
    }

    /**
     * Affiche les �l�ments du monde � l'�cran.
     * 
     * @param delta Temps �coul� depuis le dernier rendu.
     */
    public void render(float delta) {
        // Impl�mentation future
    }

    /**
     * Classe interne repr�sentant les donn�es du niveau charg�es depuis le fichier JSON.
     */
    private static class LevelData {
        /**
         * Nom du fichier de l'image de fond.
         */
        public String background;
        /**
         * Informations sur Pacman
         */
        public PacmanData pacman;
        /**
         * Listes des murs
         */
        public Array<WallData> walls;
        
        
        
        public static class PacmanData{
        	 public int x;
             public int y;
             public String direction;
        }
        public static class WallData {
            public int x;
            public int y;
        }
    }
}


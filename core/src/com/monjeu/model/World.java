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
        // loadLevel("levels/level2.json");
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

        int decalageX = 5;
        int decalageY = 7;
        
        // Charger les informations de base du niveau
        this.background = levelData.background;
        this.pacman = new Pacman( 
        		(levelData.pacman.x + decalageX) * GameConstants.WALL_SIZE,
                (levelData.pacman.y + decalageY) * GameConstants.WALL_SIZE,
                levelData.pacman.direction);
        
        // Charger les Pacgom
        for (LevelData.PacgomData pacgom : levelData.pacgom) {
            Pacgom pacgomObj = new Pacgom((pacgom.x + decalageX )* GameConstants.PACGOM_SIZE, (pacgom.y + decalageY) * GameConstants.PACGOM_SIZE);
            gameElements.add(pacgomObj);
        } 
        
        // Charger les murs
        for (LevelData.WallData wall : levelData.walls) {
            Wall wallObj = new Wall((wall.x + decalageX )* GameConstants.WALL_SIZE, (wall.y + decalageY) * GameConstants.WALL_SIZE, wall.type);
            gameElements.add(wallObj);
        }
        
        // Charger les Ghosts
        for (LevelData.GhostData ghost : levelData.ghosts) {
            Ghost ghostObj = new Ghost((ghost.x + decalageX) * GameConstants.GHOST_SIZE, (ghost.y +decalageY) * GameConstants.GHOST_SIZE, ghost.direction , ghost.couleur);
            gameElements.add(ghostObj);

            
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
        /**
         * Listes des Pacgom
         */
        public Array<PacgomData> pacgom;
        /**
         * Listes des m�chants
         */
        public Array<GhostData> ghosts;
        
        public static class GhostData{
        	public int x;
            public int y;
            public String direction;
            public String couleur;
        }
        
        public static class PacmanData{
        	 public int x;
             public int y;
             public String direction;
        }
        public static class WallData {
            public int x;
            public int y;
            public int type;
        }
        public static class PacgomData {
            public int x;
            public int y;
        }
    }
}


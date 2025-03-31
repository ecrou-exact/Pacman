package com.monjeu.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Classe TextureFactory qui gère le chargement et la gestion des textures du jeu.
 * Cette classe suit le pattern Singleton pour garantir une seule instance de gestion des textures.
 */
public class TextureFactory {
    private static TextureFactory instance;
    
    private Texture fantome1;
    private Texture fantome2;
    private Texture fantome3;
    private Texture fantome4;
    
    private Texture bloc;
    private Texture fond;
    
    private Texture boule;
    private Texture superBoule;
    
    private Texture pacmanDroite1, pacmanDroite2, pacmanDroite3;
    private Texture pacmanGauche1, pacmanGauche2, pacmanGauche3;
    private Texture pacmanHaut1, pacmanHaut2, pacmanHaut3;
    private Texture pacmanBas1, pacmanBas2, pacmanBas3;
    
    private Animation<TextureRegion> pacmanDroiteAnimation;
    private Animation<TextureRegion> pacmanGaucheAnimation;
    private Animation<TextureRegion> pacmanHautAnimation;
    private Animation<TextureRegion> pacmanBasAnimation;
    
    /**
     * Constructeur privé empêchant l'instanciation directe.
     * Initialise toutes les textures utilisées dans le jeu.
     */
    private TextureFactory() {
       fantome1 = new Texture(Gdx.files.internal("textures/Fantomes/ghost1.png"));
       fantome2 = new Texture(Gdx.files.internal("textures/Fantomes/ghost2.png"));
       fantome3 = new Texture(Gdx.files.internal("textures/Fantomes/ghost3.png"));
       fantome4 = new Texture(Gdx.files.internal("textures/Fantomes/ghost4.png"));
       
       bloc = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc.png"));
       fond = new Texture(Gdx.files.internal("textures/Labyrinthe/dark.png"));
       
       boule = new Texture(Gdx.files.internal("textures/Pacgommes/pellet.png"));
       superBoule = new Texture(Gdx.files.internal("textures/Pacgommes/superpellet.png"));
       
       pacmanDroite1 = new Texture(Gdx.files.internal("textures/Pacman/droite/pacman-3.png"));
       pacmanDroite2 = new Texture(Gdx.files.internal("textures/Pacman/droite/pacmanDown.png"));
       pacmanDroite3 = new Texture(Gdx.files.internal("textures/Pacman/droite/pacmanDown-2.png"));
       
       pacmanGauche1 = new Texture(Gdx.files.internal("textures/Pacman/gauche/pacman-3.png"));
       pacmanGauche2 = new Texture(Gdx.files.internal("textures/Pacman/gauche/pacmanLeft.png"));
       pacmanGauche3 = new Texture(Gdx.files.internal("textures/Pacman/gauche/pacmanLeft-2.png"));
       
       pacmanHaut1 = new Texture(Gdx.files.internal("textures/Pacman/haut/pacman-3.png"));
       pacmanHaut2 = new Texture(Gdx.files.internal("textures/Pacman/haut/pacmanUp.png"));
       pacmanHaut3 = new Texture(Gdx.files.internal("textures/Pacman/haut/pacmanUp-2.png"));
       
       pacmanBas1 = new Texture(Gdx.files.internal("textures/Pacman/bas/pacman-3.png"));
       pacmanBas2 = new Texture(Gdx.files.internal("textures/Pacman/bas/pacmanDown.png"));
       pacmanBas3 = new Texture(Gdx.files.internal("textures/Pacman/bas/pacmanDown-2.png"));
       
       pacmanDroiteAnimation = new Animation<>(0.06f, 
               new TextureRegion(pacmanDroite1),
               new TextureRegion(pacmanDroite2),
               new TextureRegion(pacmanDroite3)
           );
       pacmanDroiteAnimation.setPlayMode(Animation.PlayMode.LOOP);
       
       pacmanGaucheAnimation = new Animation<>(0.06f, 
               new TextureRegion(pacmanGauche1),
               new TextureRegion(pacmanGauche2),
               new TextureRegion(pacmanGauche3)
           );
       pacmanGaucheAnimation.setPlayMode(Animation.PlayMode.LOOP);
       
       pacmanHautAnimation = new Animation<>(0.06f, 
               new TextureRegion(pacmanHaut1),
               new TextureRegion(pacmanHaut2),
               new TextureRegion(pacmanHaut3)
           );
       pacmanHautAnimation.setPlayMode(Animation.PlayMode.LOOP);
       
       pacmanBasAnimation = new Animation<>(0.06f, 
               new TextureRegion(pacmanBas1),
               new TextureRegion(pacmanBas2),
               new TextureRegion(pacmanBas3)
           );
       pacmanBasAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }
    
    /**
     * Retourne l'instance unique de la classe.
     * @return instance unique de TextureFactory
     */
    public static TextureFactory getInstance() {
        if (instance == null) {
            instance = new TextureFactory();
        }
        return instance;
    }
    
    
    /**
     * Getter pour accéder aux Textures.
     */
    
    public Texture getFantome1() {
		return fantome1;
	}

	public Texture getFantome2() {
		return fantome2;
	}

	public Texture getFantome3() {
		return fantome3;
	}

	public Texture getFantome4() {
		return fantome4;
	}

	public Texture getBloc() {
		return bloc;
	}

	public Texture getFond() {
		return fond;
	}

	public Texture getBoule() {
		return boule;
	}

	public Texture getSuperBoule() {
		return superBoule;
	}

	public Texture getPacmanDroite1() {
		return pacmanDroite1;
	}

	public Texture getPacmanDroite2() {
		return pacmanDroite2;
	}

	public Texture getPacmanDroite3() {
		return pacmanDroite3;
	}

	public Texture getPacmanGauche1() {
		return pacmanGauche1;
	}

	public Texture getPacmanGauche2() {
		return pacmanGauche2;
	}

	public Texture getPacmanGauche3() {
		return pacmanGauche3;
	}

	public Texture getPacmanHaut1() {
		return pacmanHaut1;
	}

	public Texture getPacmanHaut2() {
		return pacmanHaut2;
	}

	public Texture getPacmanHaut3() {
		return pacmanHaut3;
	}

	public Texture getPacmanBas1() {
		return pacmanBas1;
	}

	public Texture getPacmanBas2() {
		return pacmanBas2;
	}

	public Texture getPacmanBas3() {
		return pacmanBas3;
	}

	public Animation<TextureRegion> getPacmanDroiteAnimation() {
		return pacmanDroiteAnimation;
	}

	public Animation<TextureRegion> getPacmanGaucheAnimation() {
		return pacmanGaucheAnimation;
	}

	public Animation<TextureRegion> getPacmanHautAnimation() {
		return pacmanHautAnimation;
	}

	public Animation<TextureRegion> getPacmanBasAnimation() {
		return pacmanBasAnimation;
	}

	/**
     * Libère la mémoire utilisée par les textures chargées.
     */
    public void dispose() {
        if (fantome1 != null) fantome1.dispose();
        if (fantome2 != null) fantome2.dispose();
        if (fantome3 != null) fantome3.dispose();
        if (fantome4 != null) fantome4.dispose();
        if (bloc != null) bloc.dispose();
        if (fond != null) fond.dispose();
        if (boule != null) boule.dispose();
        if (superBoule != null) superBoule.dispose();
        if (pacmanDroite1 != null) pacmanDroite1.dispose();
        if (pacmanDroite2 != null) pacmanDroite2.dispose();
        if (pacmanDroite3 != null) pacmanDroite3.dispose();
        if (pacmanGauche1 != null) pacmanGauche1.dispose();
        if (pacmanGauche2 != null) pacmanGauche2.dispose();
        if (pacmanGauche3 != null) pacmanGauche3.dispose();
        if (pacmanHaut1 != null) pacmanHaut1.dispose();
        if (pacmanHaut2 != null) pacmanHaut2.dispose();
        if (pacmanHaut3 != null) pacmanHaut3.dispose();
        if (pacmanBas1 != null) pacmanBas1.dispose();
        if (pacmanBas2 != null) pacmanBas2.dispose();
        if (pacmanBas3 != null) pacmanBas3.dispose();
    }
}

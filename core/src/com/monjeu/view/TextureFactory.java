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
    private Texture fantomeEatAble;
    
    private Texture bloc0;
    private Texture bloc1;
    private Texture bloc2;
    private Texture bloc3;
    private Texture bloc4;
    private Texture bloc5;
    private Texture bloc6;
    private Texture bloc7;
    private Texture bloc8;
    private Texture bloc9;
    private Texture bloc10;
    private Texture bloc11;
    private Texture bloc12;
    private Texture bloc13;
    private Texture bloc14;
    
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
       fantomeEatAble = new Texture(Gdx.files.internal("textures/Fantomes/ghostEatAble.png"));
       
       bloc0 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc0.png"));
       bloc1 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc1.png"));
       bloc2 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc2.png"));
       bloc3 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc3.png"));
       bloc4 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc4.png"));
       bloc5 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc5.png"));
       bloc6 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc6.png"));
       bloc7 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc7.png"));
       bloc8 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc8.png"));
       bloc9 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc9.png"));
       bloc10 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc10.png"));
       bloc11 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc11.png"));
       bloc12 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc12.png"));
       bloc13 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc13.png"));
       bloc14 = new Texture(Gdx.files.internal("textures/Labyrinthe/bloc14.png"));
       
       fond = new Texture(Gdx.files.internal("textures/Labyrinthe/dark.png"));
       
       boule = new Texture(Gdx.files.internal("textures/Pacgommes/pellet.png"));
       superBoule = new Texture(Gdx.files.internal("textures/Pacgommes/superpellet.png"));
       
       pacmanDroite1 = new Texture(Gdx.files.internal("textures/Pacman/droite/pacman-3.png"));
       pacmanDroite2 = new Texture(Gdx.files.internal("textures/Pacman/droite/pacmanRight.png"));
       pacmanDroite3 = new Texture(Gdx.files.internal("textures/Pacman/droite/pacmanRight-2.png"));
       
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
               new TextureRegion(pacmanDroite3),
               new TextureRegion(pacmanDroite2)
           );
       pacmanDroiteAnimation.setPlayMode(Animation.PlayMode.LOOP);
       
       pacmanGaucheAnimation = new Animation<>(0.06f, 
               new TextureRegion(pacmanGauche1),
               new TextureRegion(pacmanGauche2),
               new TextureRegion(pacmanGauche3),
               new TextureRegion(pacmanGauche2)
           );
       pacmanGaucheAnimation.setPlayMode(Animation.PlayMode.LOOP);
       
       pacmanHautAnimation = new Animation<>(0.06f, 
               new TextureRegion(pacmanHaut1),
               new TextureRegion(pacmanHaut2),
               new TextureRegion(pacmanHaut3),
               new TextureRegion(pacmanHaut2)
           );
       pacmanHautAnimation.setPlayMode(Animation.PlayMode.LOOP);
       
       pacmanBasAnimation = new Animation<>(0.06f, 
               new TextureRegion(pacmanBas1),
               new TextureRegion(pacmanBas2),
               new TextureRegion(pacmanBas3),
               new TextureRegion(pacmanBas2)
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
	public Texture getFantomeEatAble() {
		return fantomeEatAble;
	}
	
	
	public Texture getBloc0() {
		return bloc0;
	}
	public Texture getBloc1() {
		return bloc1;
	}
	public Texture getBloc2() {
		return bloc2;
	}
	public Texture getBloc3() {
		return bloc3;
	}
	public Texture getBloc4() {
		return bloc4;
	}
	public Texture getBloc5() {
		return bloc5;
	}
	public Texture getBloc6() {
		return bloc6;
	}
	public Texture getBloc7() {
		return bloc7;
	}
	public Texture getBloc8() {
		return bloc8;
	}
	public Texture getBloc9() {
		return bloc9;
	}
	public Texture getBloc10() {
		return bloc10;
	}
	public Texture getBloc11() {
		return bloc11;
	}
	public Texture getBloc12() {
		return bloc12;
	}
	public Texture getBloc13() {
		return bloc13;
	}
	public Texture getBloc14() {
		return bloc14;
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
        
        if (bloc0 != null) bloc0.dispose();
        if (bloc1 != null) bloc1.dispose();
        if (bloc2 != null) bloc2.dispose();
        if (bloc3 != null) bloc3.dispose();
        if (bloc4 != null) bloc4.dispose();
        if (bloc5 != null) bloc5.dispose();
        if (bloc6 != null) bloc6.dispose();
        if (bloc7 != null) bloc7.dispose();
        if (bloc8 != null) bloc8.dispose();
        if (bloc9 != null) bloc9.dispose();
        if (bloc10 != null) bloc10.dispose();
        if (bloc11 != null) bloc11.dispose();
        if (bloc12 != null) bloc12.dispose();
        if (bloc13 != null) bloc13.dispose();
        if (bloc14 != null) bloc14.dispose();
        
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

package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
//import com.me.gdxInvader.GdxInvader;
//import com.mygdx.game.MyGdxGame;
import com.monjeu.view.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1200;  // Largeur fixe
        config.height = 1000; // Hauteur fixe
        //config.resizable = false; // Empêcher le redimensionnement
		new LwjglApplication(new MainGame() , config);
	}
}

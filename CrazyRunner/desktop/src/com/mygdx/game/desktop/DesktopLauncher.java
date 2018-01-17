package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.mygdx.game.CrazyRunner;

public class DesktopLauncher {
	public static void main (String[] arg) {
            	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.height = 1200;
                config.width = 900;
		new LwjglApplication(new CrazyRunner(), config);
	}
}

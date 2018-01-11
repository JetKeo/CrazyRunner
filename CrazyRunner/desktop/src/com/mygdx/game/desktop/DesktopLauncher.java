package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;
import com.mygdx.game.CrazyRunner;

public class DesktopLauncher {
	public static void main (String[] arg) {
//            Settings settings = new Settings();
//            settings.maxHeight = 2000;
//            settings.maxWidth = 2000;
            
            
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1200;
                config.height = 900;
                new LwjglApplication(new CrazyRunner(), config);
	}
}

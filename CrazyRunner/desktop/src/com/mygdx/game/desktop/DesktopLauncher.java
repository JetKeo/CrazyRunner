package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;
import com.mygdx.game.CrazyRunner;

public class DesktopLauncher {
	public static void main (String[] arg) {
            Settings settings = new Settings();
            settings.maxHeight = 1600;
            settings.maxWidth = 900;
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new CrazyRunner(), config);
	}
}

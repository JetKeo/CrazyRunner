package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CrazyRunner extends ApplicationAdapter {
	SpriteBatch batch;
        private Tree tree;
        
        
	
	@Override
	public void create () {
		batch = new SpriteBatch();
                
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
                
		//batch.draw(tree, 0, 0, 60, 60);
                
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		tree.dispose();
	}
        
        
}

    

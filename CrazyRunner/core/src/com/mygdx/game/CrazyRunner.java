package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CrazyRunner extends Game {

    private SpriteBatch batch;
    
    @Override
    public void create() {
        batch = new SpriteBatch();    
        MainGame game = new MainGame(this);      
        this.setScreen(game);     
    }

    @Override
    public void render() {
        //clear screen to prep for drawing
//        Gdx.gl20.glClearColor(0, 0, 0, 1);
//        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        batch.begin();
//        batch.end();
        
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
    
    public SpriteBatch getBatch(){
        return batch;
    }
}

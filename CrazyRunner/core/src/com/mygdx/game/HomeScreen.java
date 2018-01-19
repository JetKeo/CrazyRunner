/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author khans4349
 */
public class HomeScreen implements Screen{

    //crazzyrunner
    private CrazyRunner gameManager;
    //spritebatch
    private SpriteBatch batch;
    // background
    private Texture main;
    
    public HomeScreen(CrazyRunner game){
        //initialize all variables
        this.gameManager = game; 
        this.batch = game.getBatch();
        main = new Texture("screen.gif");
        
    }
    
    
    @Override
    public void show() {
        
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        
        batch.draw(main, 0, 0, 1200, 900);
                
        batch.end();
        
    }

    @Override
    public void resize(int i, int i1) {
        
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void hide() {
        
    }

    @Override
    public void dispose() {
        
    }
    
}

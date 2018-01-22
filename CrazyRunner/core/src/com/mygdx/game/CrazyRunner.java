package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CrazyRunner extends Game {

    private SpriteBatch batch;
//    private boolean mainScreen;
//    private boolean htpScreen;
//    private boolean howToPlay;
    private Music music;
    private boolean setGameScreen;
    

    @Override
    public void create() {

        // initialize variables
        this.setGameScreen = false;
        
        batch = new SpriteBatch();
        
        // import sound
        Music music = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));
        // play sound
        music.play();
              
        // game screens
        HomeScreen gameMenu = new HomeScreen(this);
        MainGame gameScreen = new MainGame(this);
        HowToPlay helpScreen = new HowToPlay(this);
        
        // set default to home screen
        this.setScreen(gameMenu);
           
        // once      
        if (setGameScreen == true) {
            System.out.println("hello111");
            this.getScreen().hide();
            this.setScreen(gameScreen);   
        }  
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }
    
//    public setScreen(CrazyRunner game){
//        if(setGameScreen == true){
//            this.setScreen(gameScreen);
//        }
    }
}
}

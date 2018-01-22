package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CrazyRunner extends Game {

    private SpriteBatch batch;
    private boolean mainScreen;
    private boolean htpScreen;
    private boolean howToPlay;
    private Sound music;
    

    @Override
    public void create() {

        batch = new SpriteBatch();
        
        // game screens
        HomeScreen gameMenu = new HomeScreen(this);
        MainGame gameScreen = new MainGame(this);
        HowToPlay helpScreen = new HowToPlay(this);
        
        // set to main screen when game starts
        howToPlay = false;
        setGameScreen();

        // mouse input
        if (Gdx.input.isTouched()) {
            int mouseX = Gdx.input.getX();
            int mouseY = Gdx.input.getY();
            
            // start button
            if (mouseX >= 50 && mouseX <= 400) {
                if (mouseX >= 50 && mouseX <= 400) {
                    setGameScreen();
                }
            }
            // how to play button
            if (mouseX >= 15 && mouseX <= 215) {
                if (mouseX >= 15 && mouseX <= 76) {
                    setHtpScreen();
                }
            }
        }
        
        if (mainScreen == true) {
            this.setScreen(gameMenu);
        }    
        if (mainScreen == false) {
            this.setScreen(gameScreen);
        }
        if(htpScreen == true){
            // this.setHtpScreen(helpScreen);
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

    public void setMainScreen() {
        this.mainScreen = true;
    }
    
    public void setGameScreen(){
        this.mainScreen = false;
    }
    public void setHtpScreen(){
        this.howToPlay = true;
    }

    public boolean mainScreen() {
        return this.mainScreen();
    }
    
    public boolean GameScreen(){
        return this.GameScreen();
    }
    
    public boolean htpScreen(){
        return this.htpScreen();
    }
}

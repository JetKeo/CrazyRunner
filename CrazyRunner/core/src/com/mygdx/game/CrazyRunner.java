package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Shezar Khan, Anthony Peragine, Jet Keonakhone
 *
 */
public class CrazyRunner extends Game {

    // instance variables
    private SpriteBatch batch;
    private Music music;

    @Override
    public void create() {

        // initialize variables
        batch = new SpriteBatch();
        // import sound
        Music music = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));
        // play sound
        music.play();
        // set screen to be used
        MainGame gameScreen = new MainGame(this);
        // turn on th main game screen
        this.setScreen(gameScreen);
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
}

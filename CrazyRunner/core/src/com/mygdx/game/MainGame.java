/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author khans4349
 */
public class MainGame implements Screen {

    //crazzyrunner
    private CrazyRunner gameManager;
    //array to determine terrain type
    private int[] spot;
    //player
    private Player player;
    private Texture personImg;
    //terrain variables
    private Grass grass;
    private Ashphalt ashphalt;
    private Water water;
    //y keeps track of where the terrains are located
    private int y;
    //limiting variable for the amount of grass
    private int grassCount;
    //spritebatch
    private SpriteBatch batch;

    private int getPlayerPositionX;
    private int getPlayerPositionY;
    private Sound music;
    
    private AnimatedPlayer man;
    
    private BitmapFont font;
    private CharSequence str;

    public MainGame(CrazyRunner game) {
        //initialize all variables
        this.gameManager = game;
        player = new Player();
        spot = new int[15];
        grassCount = 0;
        this.grass = new Grass(1200, 60);
        this.ashphalt = new Ashphalt(1200, 60);
        this.water = new Water(1200, 60);
        generate();
        personImg = new Texture("person.png");
        
        man = new AnimatedPlayer(100, 100);

        this.batch = game.getBatch();
        
        font = new BitmapFont();
        font.getData().setScale(2);
        str = "0";
        
    }

    /*
     * Generates a number between 1 and 3 into each of an array's position besides the first
     * and last
     */
    public void generate() {
        //base case of grass at the beginning and end of screen
        this.spot[0] = 1;
        this.spot[14] = 1;
        //randomly generates with a maximum of 3 grass
        for (int i = 1; i < 14; i++) {
            if (grassCount != 3) {
                this.spot[i] = (int) Math.ceil(Math.random() * 3);
                if (spot[i] == 1) {
                    grassCount++;
                }
            } else {
                this.spot[i] = generateRange(2, 3);
            }
        }
        //resets maximum grass generated
        grassCount = 0;
    }

    /*
     * generates a number between a given range
     */
    public int generateRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float deltaTime) {
        
        man.update(deltaTime);
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //draws terrains
        batch.begin();
        
        man.render(batch);
        
        //counts 15 spots and places terrain in each spot
        for (int i = 0; i < 15; i++) {
            //1, 2, 3 determine which terrain is rendered, then increase y accordingly for next row
            if (spot[i] == 1) {
                batch.draw(grass.getImg(), 0, this.y, grass.getXSize(), grass.getYSize());
                this.y = this.y + 60;
            } else if (spot[i] == 2) {
                batch.draw(ashphalt.getImg(), 0, this.y, ashphalt.getXSize(), ashphalt.getYSize());
                this.y = this.y + 60;
            } else {
                batch.draw(water.getImg(), 0, this.y, water.getXSize(), water.getYSize());
                this.y = this.y + 60;
            }

        }
        
        
        font.draw(batch, str, 1150, 875);
        
        
        // if player moves up + implementing screen boundaries
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (player.getY() != 900) {
                player.setY(player.getY() + 30);
            }
        }
        // if player moves down
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (player.getY() != 0) {
                player.setY(player.getY() - 30);
            }
        }
        // if player moves right
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (player.getX() <= 1139) {
                player.setX(player.getX() + 30);
            }
        }
        // if player moves left
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (player.getX() != 0) {
                player.setX(player.getX() - 30);
            }
        }

        // draw player
        batch.draw(personImg, player.getX(), player.getY(), 55, 55);
        
        man.update(deltaTime);

        //regenerates terrain to continue game
        if (player.getY() > 840) {
            generate();
            player.resetY();
        }

        batch.end();
        //reset y back to 0
        this.y = 0;
    }

    //returns position array
    public int[] getSpot() {
        return this.spot;
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

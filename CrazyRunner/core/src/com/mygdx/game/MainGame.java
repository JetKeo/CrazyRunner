/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author khans4349
 */
public class MainGame implements Screen {

    //crazzyrunner
    private CrazyRunner gameManager;
    //array to determine terrain type
    private int[] spot;
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

    public MainGame(CrazyRunner game) {
        //initialize all variables
        this.gameManager = game;

        spot = new int[15];
        grassCount = 0;
        this.grass = new Grass(1200, 60);
        this.ashphalt = new Ashphalt(1200, 60);
        this.water = new Water(1200, 60);
        generate();

        this.batch = game.getBatch();
    }

    /*
     * Generates a number between 1 and 3
     */
    public void generate() {
        this.spot[0] = 1;
        this.spot[14] = 1;
        for (int i = 1; i < 14; i++) {
            if (grassCount != 3) {
                this.spot[i] = (int) Math.ceil(Math.random() * 3);
                if (spot[i] == 1) {
                    grassCount++;
                }
            } else {
                this.spot[i] = generateRange(2, 3);
                System.out.println(this.spot[i]);
            }
        }
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

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //draws terrains
        batch.begin();
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
        batch.end();
        //reset y back to 0
        this.y = 0;
    }

    public int[] getSpot(){
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

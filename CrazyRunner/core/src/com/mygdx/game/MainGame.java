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
    private int[] pos;
    //player
    private Player player;
    private Texture personImg;
    //terrain variables
    private Grass grass;
    private Ashphalt ashphalt;
    private Water water;

    private Tree tree;
    private Log log;
    private Car car;
    //y keeps track of where the terrains are located
    private int y;

    private int treeX;
    private int treeX1;
    private int treeX2;
    private int treeX3;
    private int treeX4;
    private int treeX5;

    private int carX;
    
    private int logX;
    private int logX1;
    private int logX2;

    //limiting variable for the amount of grass
    private int grassCount;
    private int treeCount;
    //spritebatch
    private SpriteBatch batch;

    private int getPlayerPositionX;
    private int getPlayerPositionY;
    private Sound music;

    private AnimatedPlayer man;

    public MainGame(CrazyRunner game) {
        //initialize all variables
        this.gameManager = game;
        player = new Player();
        spot = new int[15];
        pos = new int[20];
        grassCount = 0;
        treeCount = 0;
        logX = 1200;
        logX1 = 800;
        logX2 = 400;
        this.grass = new Grass(1200, 60);
        this.ashphalt = new Ashphalt(1200, 60);
        this.water = new Water(1200, 60);

        generate();
        generateTree();

        this.tree = new Tree(treeX, 60, 60);
        this.log = new Log(logX, 100, 60);
        this.car = new Car(carX, 80, 60);
        personImg = new Texture("person.png");

        man = new AnimatedPlayer(100, 100);

        this.batch = game.getBatch();

    }

    /*
     * Generates a number between 1 and 3 into each of an array's position besides the first
     * and last
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

    public void generateTree() {
        //possible spawn positions
        pos[0] = 0;
        pos[1] = 60;
        pos[2] = 120;
        pos[3] = 180;
        pos[4] = 240;
        pos[5] = 300;
        pos[6] = 360;
        pos[7] = 420;
        pos[8] = 480;
        pos[9] = 540;
        pos[10] = 600;
        pos[11] = 660;
        pos[12] = 720;
        pos[13] = 780;
        pos[14] = 840;
        pos[15] = 900;
        pos[16] = 960;
        pos[17] = 1020;
        pos[18] = 1080;
        pos[19] = 1140;

        this.treeX = pos[(int) Math.ceil(Math.random() * 19)];
        this.treeX1 = pos[(int) Math.ceil(Math.random() * 19)];
        this.treeX2 = pos[(int) Math.ceil(Math.random() * 19)];
        this.treeX3 = pos[(int) Math.ceil(Math.random() * 19)];
        this.treeX4 = pos[(int) Math.ceil(Math.random() * 19)];
        this.treeX5 = pos[(int) Math.ceil(Math.random() * 19)];

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
                
                batch.draw(tree.getObjectImg(), this.treeX, this.y, tree.getWidth(), tree.getLength());

                batch.draw(tree.getObjectImg(), this.treeX1, this.y, tree.getWidth(), tree.getLength());

                batch.draw(tree.getObjectImg(), this.treeX2, this.y, tree.getWidth(), tree.getLength());

                batch.draw(tree.getObjectImg(), this.treeX3, this.y, tree.getWidth(), tree.getLength());

                batch.draw(tree.getObjectImg(), this.treeX4, this.y, tree.getWidth(), tree.getLength());

                batch.draw(tree.getObjectImg(), this.treeX5, this.y, tree.getWidth(), tree.getLength());

                this.y = this.y + 60;

            } else if (spot[i] == 2) {
                
                batch.draw(ashphalt.getImg(), 0, this.y, ashphalt.getXSize(), ashphalt.getYSize());

                batch.draw(car.getObjectImg(), this.carX, this.y, car.getWidth(), car.getLength());
                
                this.y = this.y + 60;
            } else {
                batch.draw(water.getImg(), 0, this.y, water.getXSize(), water.getYSize());
                
                batch.draw(log.getObjectImg(), logX, this.y, log.getWidth(), log.getLength());
                
                batch.draw(log.getObjectImg(), logX1, this.y, log.getWidth(), log.getLength());
                
                batch.draw(log.getObjectImg(), logX2, this.y, log.getWidth(), log.getLength());
                
                this.y = this.y + 60;
            }

        }
        
        //car movement
        if(carX < 1200){
            carX = carX + 4;
        } else {
            carX = 0;
        }
        
        //log movement
        if(logX > 0){
            logX = logX - 2;
            
        } else {
            logX = 1200;
        }
        
        if(logX1 > 0){
            logX1 = logX1 - 2;
            
        } else {
            logX1 = 1200;
        }
        
        if(logX2 > 0){
            logX2 = logX2 - 2;
            
        } else {
            logX2 = 1200;
        }

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
            generateTree();
            player.resetY();
        }

        batch.end();
        //reset y back to 0
        this.y = 0;

        grassCount = 0;
        treeCount = 0;

    }

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



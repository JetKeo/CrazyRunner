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
 * @author Shezar Khan, Anthony Peragine, Jet Keonakhone
 * 
 */
public class MainGame implements Screen {

    //crazzyrunner
    private CrazyRunner gameManager;

    //spritebatch
    private SpriteBatch batch;

    //player variables
    // private Player player;
    // private Texture personImg;
    private int getPlayerPositionX;
    private int getPlayerPositionY;
    private int score;

    //terrain variables
    //array to determine terrain type
    private int[] spot;
    private int[] pos;
    private Grass grass;
    private Ashphalt ashphalt;
    private Water water;

    private Tree[] test;

    private Tree[] ary1;
    private Tree[] ary2;
    private Tree[] ary3;

    private Tree tree;
    private Log log;
    private Car car;
    //y keeps track of where the terrains are located
    private int y;
    private int x;

    private int treeX;
    private int treeX1;
    private int treeX2;
    private int treeX3;
    private int treeX4;
    private int treeX5;

    private int carX;
    private int carX2;

    private int logX;
    private int logX1;
    private int logX2;

    //limiting variable for the amount of grass
    private int grassCount;

    // animated variables
    private AnimatedPlayer p1;

    // SCREEN IMAGES
    // home screen images
    private Texture main;
    // rules button
    private Texture rules;
    // start button
    private Texture start;

    // game screen
    private Texture back;

    // how to play background
    private Texture htpBackground;
    private Texture rulesText;
    private Texture arrowText;
    private Texture arrow;
    private Texture descriptionText;

    // boolean statements to switch screens
    // game screen
    private boolean gameScreen;
    // how to play page
    private boolean htpScreen;
    // start screen
    private boolean startScreen;

    //score updater
    private int prePos;

    // Font
    private BitmapFont font;
    private CharSequence str;

    private int stopper;

    // restart boolean
    private boolean restart;

    // death boolean
    private boolean death;
    
     // speed of objects
     private double speedO;

    public MainGame(CrazyRunner game) {
        //initialize all variables

        // game manager
        this.gameManager = game;

        // game batch
        this.batch = game.getBatch();

        stopper = 0;

        // player
        // player = new Player();
        score = 0;
        p1 = new AnimatedPlayer(Gdx.graphics.getWidth() / 2 - (55 / 2), 900);

        //score updater at 0
        prePos = 0;

        // terain variables
        spot = new int[15];
        pos = new int[20];
        grassCount = 0;
        this.grass = new Grass(1200, 60);
        this.ashphalt = new Ashphalt(1200, 60);
        this.water = new Water(1200, 60);
        generate();

        // import texture from assets
        //person img
        // personImg = new Texture("person.png");
        this.test = new Tree[14];
        logX = 1200;
        logX1 = 800;
        logX2 = 400;
        carX2 = 600;

        // generate();
        this.tree = new Tree(treeX, 60, 60);
        this.log = new Log(logX, 100, 60);
        this.car = new Car(carX, 80, 60);

        // home screen images
        // background
        main = new Texture("background.jpg");
        // rules button
        rules = new Texture("rules.png");
        // start button
        start = new Texture("start.png");

        // how to play images
        // background
        htpBackground = new Texture("htpBackground.jpg");
        rulesText = new Texture("rulesHeader.png");
        arrowText = new Texture("arrowText.png");
        arrow = new Texture("arrow.png");
        descriptionText = new Texture("descriptionText.png");

        // game screen images
        // back arrow image
        back = new Texture("back.png");

        // boolean variables default set
        this.gameScreen = false;
        this.htpScreen = false;
        this.startScreen = true;

        //font
        font = new BitmapFont();
        font.getData().setScale(2);
        str = "0";

        // restart variable starts at false for player
        this.restart = false;

        // start out as not dead
        this.death = false;
        
        // speed of objects
        this.speedO = 3.0;
        
       
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
        //reset max grass
        grassCount = 0;
    }

    /*
     * generates a number between a given range
     */
    public int generateRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public Tree[] generateTree() {
        for (int i = 0; i < 6; i++) {
            test[i] = new Tree(generateRange(1, 1200), 60, 60);
        }
        return test;

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float deltaTime) {

        p1.update(deltaTime);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // set game screen
        // boolean gameScreen = false;
        //draws terrains
        batch.begin();

        // mouse input
        if (Gdx.input.isTouched()) {
            int mouseX = Gdx.input.getX();
            int mouseY = Gdx.input.getY();

            // main page
            // how to play button
            if (mouseX >= 10 && mouseX <= 190 && startScreen == true) {
                if (mouseY >= 825 && mouseY <= 885) {

                    htpScreen = true;
                    startScreen = false;
                }
            }

            // game screen
            // back button
            if (mouseX >= 10 && mouseX <= 82 && gameScreen == true) {
                if (mouseY >= 18 && mouseY <= 50) {

                    startScreen = true;
                    gameScreen = false;
                }
            }

            // how to play page
            // back button
            if (mouseX >= 10 && mouseX <= 82 && htpScreen == true) {
                if (mouseY >= 18 && mouseY <= 50) {

                    startScreen = true;
                    htpScreen = false;
                }
            }

        }
        // keyboard input
        // go to the game
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            gameScreen = true;
            startScreen = false;
        }

        // start screen
        if (gameScreen == false && htpScreen == false && startScreen == true) {
            // draw homepage background
            batch.draw(main, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            // draw rules button
            batch.draw(rules, 10, 15, 180, 50);
            // draw start button
            batch.draw(start, 335, 235, 480, 70);

        }

        //counts 15 spots and places terrain in each spot
        if (gameScreen == true && htpScreen == false && startScreen == false) {

            for (int i = 0; i < 15; i++) {

                //1, 2, 3 determine which terrain is rendered, then increase y accordingly for next row
                if (spot[i] == 1) {
                    batch.draw(grass.getImg(), 0, this.y, grass.getXSize(), grass.getYSize());
                    if (this.y >= 60) {
                        if (stopper == 0) {
                            ary1 = generateTree();
                            ary2 = generateTree();
                            ary3 = generateTree();
                            stopper++;
                        }
                        for (int x = 0; x < 6; x++) {
                            batch.draw(test[0].getObjectImg(), ary1[x].getX(), this.y, ary1[x].getWidth(), ary1[x].getLength());
                        }
                    }                                 
                    this.y = this.y + 60;

                } else if (spot[i] == 2) {
                    batch.draw(ashphalt.getImg(), 0, this.y, ashphalt.getXSize(), ashphalt.getYSize());
                    batch.draw(car.getObjectImg(), this.carX, this.y, car.getWidth(), car.getLength());
                    batch.draw(car.getObjectImg(), this.carX2, this.y, car.getWidth(), car.getLength());
                    
                    if (this.y == p1.getY()) {
                        if ((p1.getX() <= carX + 80 && p1.getX() >= carX || p1.getX() <= carX2 + 80 && p1.getX() >= carX2) 
                                && (p1.getY() <= this.y + 60 && p1.getY() >= this.y || (p1.getY() + 40) >= this.y + 60 && (p1.getY() + 40) <= this.y )){                          
                            death = true;
                        } else {
                            death = false;

                        }

                    }
                    this.y = this.y + 60;

                   
                } else {
                    batch.draw(water.getImg(), 0, this.y, water.getXSize(), water.getYSize());
                    batch.draw(log.getObjectImg(), logX, this.y, log.getWidth(), log.getLength());
                    batch.draw(log.getObjectImg(), logX1, this.y, log.getWidth(), log.getLength());
                    batch.draw(log.getObjectImg(), logX2, this.y, log.getWidth(), log.getLength());

                    if (this.y == p1.getY()) {
                        if (p1.getX() <= logX + 100 && p1.getX() >= logX || p1.getX() <= logX1 + 100 && p1.getX() >= logX1 || p1.getX() <= logX2 + 100 && p1.getX() >= logX2) {
                            death = false;
                        } else {
                            death = true;
                        }
                    }
                    this.y = this.y + 60;

                }

            }
            //car movement
            if (carX < 1200) {
                carX = (int) (carX + speedO);
            } else {
                carX = 0;
            }

            if (carX2 < 1200) {
                carX2 = (int) (carX2 + speedO);
            } else {
                carX2 = 0;
            }
            //log movement
            if (logX > -100) {
                logX = (int) (logX - speedO);

            } else {
                logX = 1200;
            }

            if (logX1 > -100) {
                logX1 = (int) (logX1 - speedO);

            } else {
                logX1 = 1200;
            }

            if (logX2 > -100) {
                logX2 = (int) (logX2 - speedO);

            } else {
                logX2 = 1200;
            }

            //update score
            if (p1.getY() >= prePos + 60) {
                prePos = prePos + 60;
                score = score + 1;
                str = Integer.toString(score + 1);
            }
            //draw font
            font.draw(batch, str, 1150, 875);

            //draw back button
            batch.draw(back, 10, 850, 75, 32);

            // if player moves right
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && death == false) {
                if (p1.getX() <= 1140) {
                    p1.setX((int) (p1.getX() + 15));
                }
            }
            // if player moves left
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && death == false) {
                if (p1.getX() >= 10) {
                    p1.setX((int) (p1.getX() - 15));
                }
            }

            if (death == true) {
                p1.resetX();
                p1.resetY();
                score = 0;
                death = false;
            }

            //player
            // batch.draw(personImg, player.getX(), player.getY(), 55, 55);
            p1.render(batch);

        }

        if (p1.getY() > 840) {
            generate();
            generateTree();
            p1.resetY();
            prePos = 0;
            speedO = speedO + 0.4;
        }

        //reset y back to 0
        this.y = 0;
        grassCount = 0;

        // how to play screen
        if (gameScreen == false && htpScreen == true && startScreen == false) {
            // background
            batch.draw(htpBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 15);
            // draw back arrow
            batch.draw(back, 10, 850, 75, 32);
            // draw rules header
            batch.draw(rulesText, 300, 690, 600, 200);
            // arrow header
            batch.draw(arrowText, Gdx.graphics.getWidth() / 2 - 150, 600, 300, 75);
            // arrows
            batch.draw(arrow, Gdx.graphics.getWidth() / 2 - 113, 440, 225, 150);
            // description header
            batch.draw(descriptionText, Gdx.graphics.getWidth() / 2 - 100, 350, 200, 75);

            // info instructions text
        }
        batch.end();

    }

    public boolean getDeath() {
        return death;
    }

    // add a revival method
    //returns position array
    public int[] getSpot() {
        return this.spot;
    }

    public void resetScore() {
        score = 0;
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

    public boolean isDead() {
        return death = true;
    }
}

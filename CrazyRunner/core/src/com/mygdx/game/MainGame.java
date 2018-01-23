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
    
    //spritebatch
    private SpriteBatch batch;
    
    //player variables
    private Player player;
    private Texture personImg;
    private int getPlayerPositionX;
    private int getPlayerPositionY;
    private int score;
    
    //terrain variables
    //array to determine terrain type
    private int[] spot;
    private Grass grass;
    private Ashphalt ashphalt;
    private Water water;
    //y keeps track of where the terrains are located
    private int y;
    //limiting variable for the amount of grass
    private int grassCount;
    
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
    
    // boolean statements to switch screens
    // game screen
    private boolean gameScreen;
    // how to play page
    private boolean htpScreen;
    // start screen
    private boolean startScreen;
    
    //score updater
    private int prePos;
    
    // working on this class 
    private AnimatedPlayer man;
    
    private BitmapFont font;
    private CharSequence str;

    public MainGame(CrazyRunner game) {
        //initialize all variables
        
        // game manager
        this.gameManager = game;
        
        // game batch
        this.batch = game.getBatch();
        
        // player
        player = new Player();
        score = 0;
        
        //score updater at 0
        prePos = 0;
        
        // terain variables
        spot = new int[15];
        grassCount = 0;
        this.grass = new Grass(1200, 60);
        this.ashphalt = new Ashphalt(1200, 60);
        this.water = new Water(1200, 60);
        generate();
        
        // import texture from assets
        //person img
        personImg = new Texture("person.png");
        
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
        
        // working on
//        man = new AnimatedPlayer(100, 100);

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

    @Override
    public void show() {
    }

    @Override
    public void render(float deltaTime) {

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
            
            System.out.println("x: " + mouseX);
            System.out.println("y: " + mouseY);
            
            // main page
            // how to play button
            if (mouseX >= 10 && mouseX <= 190 && startScreen == true) {
                if (mouseY >= 825 && mouseY <= 885) {
                    System.out.println("ola");
                    htpScreen = true;
                    startScreen = false;
                }
            }
            
            // game screen
            // back button
            if (mouseX >= 10 && mouseX <= 82 && gameScreen == true) {
                if (mouseY >= 18 && mouseY <= 50) {
                    System.out.println("ola");
                    startScreen = true;
                    gameScreen = false;
                }
            }
            
            // how to play page
            // back button
            if (mouseX >= 10 && mouseX <= 82 && htpScreen == true) {
                if (mouseY >= 18 && mouseY <= 50) {
                    System.out.println("ola");
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
                    this.y = this.y + 60;
                } else if (spot[i] == 2) {
                    batch.draw(ashphalt.getImg(), 0, this.y, ashphalt.getXSize(), ashphalt.getYSize());
                    this.y = this.y + 60;
                } else {
                    batch.draw(water.getImg(), 0, this.y, water.getXSize(), water.getYSize());
                    this.y = this.y + 60;
                }

            }
            //update score
            if(player.getY() >= prePos + 60){
                prePos = prePos + 60;
                score = score + 1;
                str = Integer.toString(score + 1); 
            }
             //draw font
            font.draw(batch, str, 1150, 875);
            
            //draw back button
            batch.draw(back, 10, 850, 75, 32);
            
            // if player moves up + implementing screen boundaries
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                if (player.getY() != 900) {
                    player.setY(player.getY() + 3);
                }
            }
            // if player moves down
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                if (player.getY() != 0) {
                    player.setY(player.getY() - 3);
                }
            }
            // if player moves right
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                if (player.getX() <= 1139) {
                    player.setX(player.getX() + 3);
                }
            }
            // if player moves left
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                if (player.getX() != 0) {
                    player.setX(player.getX() - 3);
                }
            }
            
           
            
            //player
            batch.draw(personImg, player.getX(), player.getY(), 55, 55);

        }
        

            //regenerates terrain to continue game
            if (player.getY() > 840) {
                generate();
                player.resetY();
                prePos = 0;
            }
            


            
            //reset y back to 0
            this.y = 0;
            
            // how to play screen
        if (gameScreen == false && htpScreen == true && startScreen == false) {
            // background
            batch.draw(htpBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            // draw back arrow
            batch.draw(back, 10, 850, 75, 32);

            // info instructions text
        }       
        batch.end(); 

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author Shezar Khan, Anthony Peragine, Jet Keonakhone
 */
public class AnimatedPlayer {

    // player location variables
    private float x;
    private float y;
    // player movement variables
    private float dx;
    private float dy;
    // facing down or not
    private boolean facingDown;
//    // face right or not
//    private boolean facingRight;

    // the amount of time an animation has been running
    private float elapsed;

    // animation variables for moving
    private Animation<TextureRegion> run;
    private Animation<TextureRegion> runD;

//    private Animation<TextureRegion> runR;
//    private Animation<TextureRegion> runL;
    // pictures when standing still
    private TextureRegion stand;
    private TextureRegion standD;

//    private TextureRegion standR;
//    private TextureRegion standL;
    // texture atlas that will help load in the images from the big image
    // this was created from running the texture packer (in Desktop Launcher)
    private TextureAtlas atlas;

//    // for horizontal animations
//    private TextureAtlas atlas2;
    // set speed of player
    private int speed;

    // constructor - we need to know where the player starts
    public AnimatedPlayer(float x, float y) {
        // sets the income position
        this.x = x;
        this.y = y;

        // player starts standing still
        this.dx = 0;
        this.dy = 0;

        // no animation going on, so no time yet
        this.elapsed = 0;

        // players speed
        this.speed = 15;

        // load in the texture atlast to start finding pictures
        this.atlas = new TextureAtlas("packed/man.atlas");

        // finding the standing picture and load it in
        this.stand = atlas.findRegion("stand");
        // we create a new texture from the standing picture
        // this creates a duplicate picture so we can flip it for the other direction
        this.standD = new TextureRegion(stand);
        this.standD.flip(false, true);

        // create a run animation by finding every picture named run
        // the atlas has an index from each picture to order them correctly
        // this was done by naming the pictures in a certain way (run_1, run_2, etc.)
        // load in picture from atlas going up
        // create up animation
        run = new Animation(1f / 20f, atlas.findRegions("run"));

        // load in the pictures from the atlas again, but we will flip them this time
        Array<AtlasRegion> runDFrames = atlas.findRegions("run");
        for (int i = 0; i < 9; i++) {
            // this is how we flip each image
            runDFrames.get(i).flip(false, true);
        }
        // create the down animation
        runD = new Animation(1f / 20f, runDFrames);

        // start off by facing up
        this.facingDown = false;

        // ATTEMPTED TO INCORPORATE HORIZONTAL ANIMATIONS ALONGSIDE VERTICAL ANIMATIONS,--------------------------------------------------------------------------- 
        // HOWEVER I FAILED SO I COMMENTED OUT (Most of the code)SHOWING I TRIED-----------------------------------------------------------------------------------
//        // start by facing up
//        this.facingRight = false;
//        // HORIZONTAL ANIMATION
//      
//        // second atlas
//        this.atlas2 = new TextureAtlas("packed2/man2.atlas");  
//        // load in texture facing right
//        this.standR = atlas2.findRegion("standR");
//        // load in texture facing left
//        this.standL = new TextureRegion(standR);
//        this.standL.flip(true, false);
//        
//        runR = new Animation(1f / 10f, atlas2.findRegions("run"));
//        
//        // load in the pictures from the atlas again, but we will flip them this time
//        Array<AtlasRegion> runLFrames = atlas2.findRegions("run");
//        for (int i = 0; i < 9; i++) {
//            // this is how we flip each image
//            runLFrames.get(i).flip(true, false);
//        }
//        // create the left animation
//        runL = new Animation(1f / 10f, runLFrames);
//        
//        
        // create a run animation facing right
        // load in picture from atlas going right
//        Array<AtlasRegion> runRFrames = atlas.findRegions("run");
//        // start from pic 10 and go till 18
//        for (int i = 10; i < 18; i++) {
//            // keep same position
//            runRFrames.get(i).flip(false, false);
//        }
//        runR = new Animation(1f / 10f, atlas.findRegions("run_10"));
//        runR = new Animation(1f / 10f, atlas.findRegions("run_11"));
//        runR = new Animation(1f / 10f, atlas.findRegions("run_12"));
//        runR = new Animation(1f / 10f, atlas.findRegions("run_13"));
//        runR = new Animation(1f / 10f, atlas.findRegions("run_14"));
//        runR = new Animation(1f / 10f, atlas.findRegions("run_15"));
//        runR = new Animation(1f / 10f, atlas.findRegions("run_16"));
//        runR = new Animation(1f / 10f, atlas.findRegions("run_17"));
//        runR = new Animation(1f / 10f, atlas.findRegions("run_18"));
        // create right animation
        // runR = new Animation(1f / 10f, runRFrames);
        // create a run animation facing left
        // load in picture from atlas
//        Array<AtlasRegion> runLFrames = atlas.findRegions("run");
//        // start from pic 10 and go till 18
//        for (int i = 10; i < 18; i++) {
//            // flip position
//            runLFrames.get(i).flip(true, false);
//        }
//        // create left animation
//        runL = new Animation(1f / 10f, runLFrames);
//        runL = new Animation(1f / 10f, atlas.findRegions("run_10"));
//        runL = new Animation(1f / 10f, atlas.findRegions("run_11"));
//        runL = new Animation(1f / 10f, atlas.findRegions("run_12"));
//        runL = new Animation(1f / 10f, atlas.findRegions("run_13"));
//        runL = new Animation(1f / 10f, atlas.findRegions("run_14"));
//        runL = new Animation(1f / 10f, atlas.findRegions("run_15"));
//        runL = new Animation(1f / 10f, atlas.findRegions("run_16"));
//        runL = new Animation(1f / 10f, atlas.findRegions("run_17"));
//        runL = new Animation(1f / 10f, atlas.findRegions("run_18"));
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    }

    // get float of x
    public float getX() {
        return x;
    }

    // get float of y
    public float getY() {
        return y;
    }

    public void update(float deltaTime) {

        // if I'm pressing up
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            // set the x displacement to start moving up
            this.dy = speed;
            this.dx = 0;
            // increase the animation timer
            this.elapsed = this.elapsed + deltaTime;
            // set boolean to face down
            this.facingDown = false;

            // if im pressing down and persons y position is greater than zero
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && this.y >= 0) {
            // set the x displacement to start moving down
            this.dy = -speed;
            this.dx = 0;
            // increase the animation timer
            this.elapsed = this.elapsed + deltaTime;
            // im facing down
            this.facingDown = true;

        } else {
            // stop the y displacement
            this.dy = 0;
            // no more animation so reset the timer
            this.elapsed = 0;
        }
        // update y position
        this.y = this.y + this.dy;

        // ATTEMPTED TO INCORPORATE HORIZONTAL ANIMATIONS ALONGSIDE VERTICAL ANIMATIONS,--------------------------------------------------------------------------- 
        // HOWEVER I FAILED SO I COMMENTED OUT SHOWING I TRIED-----------------------------------------------------------------------------------------------------
//        // if I'm pressing right
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && this.x <= 1105) {
//            // set the x displacement to start moving right
//            this.dx = 15;
//            this.dy = 0;
//            // increase the animation timer
//            this.elapsed = this.elapsed + deltaTime;
////            horizontal = true;
////            vertical = false;
////            this.facingDown = false;
////            this.facingRight = true;
//            
//        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && this.x >= 0) {
//            // set the x displacement to start moving left
//            this.dy = - 15;
//            this.dy = 0;
//            // increase the animation timer
//            this.elapsed = this.elapsed + deltaTime;
////            horizontal = true;
////            vertical = false;
////            this.facingDown = false;
////            this.facingRight = false;
//            
//        } else {
//            // stop the x displacement
//            this.dx = 0;
//            // no more animation so reset the timer
//            this.elapsed = 0;
////            horizontal = true;
////            vertical = false;
//        }
        // this.x = this.x + this.dx;
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    }

    public void render(SpriteBatch batch) {
        // standing
        if (this.dy == 0) {
            // pic the correct picture for UP or DOWN
            if (facingDown == true) {
                batch.draw(standD, x, y, 40, 40);
            } else {
                batch.draw(stand, x, y, 40, 40);
            }

            // SAME THING ------------------------------------------------------------------------------------------------------------------------------------------------
//            // horizontal animation
//        }else if(this.dx == 0 && horizontal == true){
//            if(facingRight == true){
//                batch.draw(standR, x, y);
//            }else if(facingRight == false){            
//                batch.draw(standL, x, y);
//            }
            // -----------------------------------------------------------------------------------------------------------------------------------------------------------
            // set up or down movement during elapsed time
        } else if (this.dy > 0) {
            batch.draw(run.getKeyFrame(elapsed, true), x, y, 40, 40);
            // Down animation
        } else if (this.dy < 0) {
            batch.draw(runD.getKeyFrame(elapsed, true), x, y, 40, 40);
        }

        // SAME THING ------------------------------------------------------------------------------------------------------------------------------------------------
        // right animation
//        } else if (this.dx > 0&& vertical == false && horizontal == true) {
//            batch.draw(runR.getKeyFrame(elapsed, true), x, y);
//            // left animation
//        } else if (this.dx < 0&& vertical == false && horizontal == true) {
//            batch.draw(runL.getKeyFrame(elapsed, true), x, y);
//        }
        // -----------------------------------------------------------------------------------------------------------------------------------------------------------
    }

    // resets y position
    public void resetY() {
        this.y = 0;
    }

    // resets x position
    public void resetX() {
        this.x = Gdx.graphics.getWidth() / 2 - (55 / 2);
    }

    // set the value of x coordinate
    public void setX(int x) {
        this.x = x;
    }

    // sets the value of y coordinate
    public void setY(int y) {
        this.y = y;
    }

    // get rid of heavy objects
    public void dispose() {
        atlas.dispose();
    }
}

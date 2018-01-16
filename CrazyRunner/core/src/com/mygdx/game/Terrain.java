/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author peraa0837
 */

public abstract class Terrain {
    private int xsize;
    private int ysize;
    private int y;

    public Terrain(int xsize, int ysize){
        this.xsize = xsize;
        this.ysize = ysize;
       }
    
    public void nextRow(){
        this.y = this.y + 60;
    }
    
    public int getXSize(){
        return this.xsize;
    }
    
    public int getYSize(){
        return this.ysize;
    }
    
    public int getY(){
        return this.y;
    }
}
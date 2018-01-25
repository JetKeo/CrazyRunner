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
 * @author Shezar Khan, Anthony Peragine, Jet Keonakhone 
 * Abstract class for various terrains
 */
public abstract class Terrain {

    // instance variables
    private int xsize;
    private int ysize;
    private int y;
    private int x;

    public Terrain(int xsize, int ysize) {
        // constructor
        this.xsize = xsize;
        this.ysize = ysize;
    }

    // return size of x
    public int getXSize() {
        return this.xsize;
    }

    // return size of y
    public int getYSize() {
        return this.ysize;
    }

    // return y position
    public int getY() {
        return this.y;
    }

    // return x position
    private int getX() {
        return this.x;
    }
}

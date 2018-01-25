/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author Shezar Khan, Anthony Peragine, Jet Keonakhone 
 * Abstract class for objects
 */
public abstract class Objects {

    // instance variables
    private int width;
    private int length;
    private int x;

    public Objects(int x, int width, int length) {
        // constructor
        this.x = x;
        this.width = width;
        this.length = length;

    }

    // get the width
    public int getWidth() {
        return width;

    }

    // get the length
    public int getLength() {
        return length;

    }

    // get X
    public int getX() {
        return x;
    }
}

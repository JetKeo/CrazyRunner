/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author jetkeo

 */

public abstract class Objects {

    private int width;
    private int length;
    private int x;

    public Objects(int x, int width, int length){

        this.x = x;
        this.width = width;
        this.length = length;

    }

    public int getWidth(){
        return width;

    }

    public int getLength(){
        return length;

    }

    public int getX(){
        return x;
    }
}
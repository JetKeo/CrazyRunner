/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author peraa0837
 */
public class Water extends Terrain{
    private Texture img;
    //used to identify the grass from other terrains
    private int id = 1;
    
    public Water(int width, int height){
        super(width, height);
        img = new Texture("water.png");
    }
    
    public Texture getImg(){
        return this.img;
    }
    
    public int getId(){
        return id;
    }
    
    
    public void dispose(){
        img.dispose();
    }
}

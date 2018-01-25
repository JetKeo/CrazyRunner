/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 *
 *@author Shezar Khan, Anthony Peragine, Jet Keonakhone
 * Water is a subclass of Terrain
 */
public class Water extends Terrain{
    // import image
    private Texture img;
    //used to identify the grass from other terrains
    private int id = 1;
    
    public Water(int width, int height){
        // width and height remain same
        super(width, height);
        // texture only exclusion
        img = new Texture("water.png");
    }
    // return image
    public Texture getImg(){
        return this.img;
    }
    // return ID
    public int getId(){
        return id;
    }
    
    // dispose of heavy objects
    public void dispose(){
        img.dispose();
    }
}

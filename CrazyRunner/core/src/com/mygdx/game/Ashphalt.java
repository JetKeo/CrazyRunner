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
public class Ashphalt extends Terrain{
    private Texture img;
    //used to identify the grass from other terrains
    private int id = 2;
    
    public Ashphalt(int width, int height){
        super(width, height);
        img = new Texture("ashphalt.png");
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

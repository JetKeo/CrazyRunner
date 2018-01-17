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
    int terrain;
    
    float x;
    float y;

    
    public Objects(int terrain, float x, float y){
        this.terrain = terrain;
        
        this.x = x;
        this.y = y;
 
    }
    
    public int getTerrain(){
        return terrain;
    }
    
    public float getX(){
        return x;
    }
    
    public float getY(){
        return y;
    }
    
    
        
    
    
    
    
}

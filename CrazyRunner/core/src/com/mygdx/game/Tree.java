/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jetkeo
 */
public class Tree extends Objects {
    private Texture tree;
 
    int[] pos = new int[20];

    public Tree(String name, int terrain, float x, float y) {
        super(terrain, x, y);
        tree = new Texture("tree.png");
    }
    
    public Texture getObjectImg(){
        return this.tree;
    }

    void dispose() {
        tree.dispose();
    }
    
    
}
        

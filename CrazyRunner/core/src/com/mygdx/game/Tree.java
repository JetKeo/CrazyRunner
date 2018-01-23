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

    public Tree(int x,int width, int height) {
        super(x, width, height);
        tree = new Texture("tree.png");
    }
    
    public Texture getObjectImg(){
        return this.tree;
    }

    void dispose() {
        tree.dispose();
    }
    
    
}
        

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
 * @author Shezar Khan, Anthony Peragine, Jet Keonakhone 
 * Tree is a subclass of Objects
 */
public class Tree extends Objects {

    // import image
    private Texture tree;

    public Tree(int x, int width, int height) {
        // width, height and x remain the same
        super(x, width, height);
        // texture only exclusion
        tree = new Texture("tree.png");
    }

    // return texture
    public Texture getObjectImg() {
        return this.tree;
    }

    // dispose of heavy objects
    void dispose() {
        tree.dispose();
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author Shezar Khan, Anthony Peragine, Jet Keonakhone 
 * Car is a subclass of Objects
 */
public class Car extends Objects {
    // import image
    private Texture car;

    public Car(int x,int width, int height) {
        // width, height and x remain the same
        super(x, width, height);
        // texture only exclusion
        car = new Texture("car.png");
    }

    // return texture
    public Texture getObjectImg(){
        return this.car;
    }

    // dispose of heavy objects
    void dispose() {
        car.dispose();
    }
}
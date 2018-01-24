
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author jetkeo
 */
public class Car extends Objects {

    private Texture car;

    public Car(int x,int width, int height) {
        super(x, width, height);
        car = new Texture("car.png");
    }

    public Texture getObjectImg(){
        return this.car;
    }

    void dispose() {
        car.dispose();
    }
}
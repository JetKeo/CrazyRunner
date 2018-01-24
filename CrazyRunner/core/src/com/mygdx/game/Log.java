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

public class Log extends Objects {
    private Texture log;

    public Log(int x,int width, int height) {
        super(x, width, height);
        log = new Texture("log.png");
    } 

    public Texture getObjectImg(){
        return this.log;
    }

    void dispose() {
        log.dispose();
    }
}
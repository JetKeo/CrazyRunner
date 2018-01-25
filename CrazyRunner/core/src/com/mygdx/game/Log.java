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
 * Log is a subclass of Objects
 */
public class Log extends Objects {

    // import image
    private Texture log;

    public Log(int x, int width, int height) {
        // width, height and x remain the same
        super(x, width, height);
        // texture only exclusion
        log = new Texture("log.png");
    }

    // return texture
    public Texture getObjectImg() {
        return this.log;
    }

    // dispose of heavy objects
    void dispose() {
        log.dispose();
    }
}

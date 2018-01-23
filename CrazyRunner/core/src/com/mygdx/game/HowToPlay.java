///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mygdx.game;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//
///**
// *
// * @author sheza
// */
//public class HowToPlay implements Screen{
//
//    //crazzyrunner
//    private CrazyRunner gameManager;
//    //spritebatch
//    private SpriteBatch batch;
//    // background png
//    private Texture background;
//    // how to play text screen
//    private Texture header;
//    
//    public HowToPlay(CrazyRunner game){
//        //initialize all variables
//        this.gameManager = game; 
//        this.batch = game.getBatch();
//    }
//    
//    @Override
//    public void show() {
//        // clear screen
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        
//        // begin batch
//        batch.begin();
//              
//        // end batch
//        batch.end();
//    }
//
//    @Override
//    public void render(float f) {
//    }
//
//    @Override
//    public void resize(int i, int i1) {
//    }
//
//    @Override
//    public void pause() {
//    }
//
//    @Override
//    public void resume() {
//    }
//
//    @Override
//    public void hide() {
//    }
//
//    @Override
//    public void dispose() {
//    }
//    
//}

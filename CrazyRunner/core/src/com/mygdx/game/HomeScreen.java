///*
// * To change this template, choose Tools | Templates
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
// * @author khans4349
// */
//public class HomeScreen implements Screen{
//
//    //crazzyrunner
//    private CrazyRunner gameManager;
//    //spritebatch
//    private SpriteBatch batch;
//    // background
//    private Texture main;
//    // rules button
//    private Texture rules;
//    // start button
//    private Texture start;
//    // boolean
//    private CrazyRunner setMainScreen;
//    // boolean
//    private CrazyRunner setGameScreen;
//    //boolean
//    private boolean gameScreen;
// 
//    // private AnimatedPlayer man;
//    
//    public HomeScreen(CrazyRunner game){
//        //initialize all variables
//        this.gameManager = game; 
//        this.batch = game.getBatch();
//        
//        main = new Texture("screen.gif");
//        rules = new Texture("rules.png");
//        start = new Texture("start.png");
//        
//        this.gameScreen = false;
//        // man = new AnimatedPlayer(100, 100);
//    }
//    
//    
//    @Override
//    public void show() {
//        
//    }
//
//    @Override
//    public void render(float f) {
//        // clear screen
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        
//        // man.update(f);
//        
//        // begin batch
//        batch.begin();
//        
//        
//        
//        // draw homepage background
//        batch.draw(main, 0, 0, 1200, 900);
//        
//        // draw rules button
//        batch.draw(rules, 15, 15, 200, 61);
//        
//        // draw start button
//        batch.draw(start, 50, 450, 300, 300);
//        
//         // mouse input
//        if (Gdx.input.isTouched()) {
//            int mouseX = Gdx.input.getX();
//            int mouseY = Gdx.input.getY();
//            
//            // start button
//            if (mouseX >= 50 && mouseX <= 400) {
//                if (mouseX >= 50 && mouseX <= 400) {
//                    for(int i = 0; i < 10; i++){
//                        System.out.println("hello" + i);
//                    }
//                    setGameScreen();
//                }
//            }
//            // how to play button
//            if (mouseX >= 15 && mouseX <= 215) {
//                if (mouseX >= 15 && mouseX <= 76) {
//                    // setHtpScreen();
//                }
//            }
//        }
//            
//        // end batch
//        batch.end();
//        
//    }
//
//    @Override
//    public void resize(int i, int i1) {
//        
//    }
//
//    @Override
//    public void pause() {
//        
//    }
//
//    @Override
//    public void resume() {
//        
//    }
//
//    @Override
//    public void hide() {
//        
//    }
//
//    @Override
//    public void dispose() {
//        
//    }
//    public boolean setGameScreen(){
//        return gameScreen = true;
//        
//    }
//    
//}

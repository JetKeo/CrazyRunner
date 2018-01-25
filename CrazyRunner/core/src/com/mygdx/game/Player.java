///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mygdx.game;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//
///**
// *
// * @author khans4349
// */
//public class Player {
//    // instance variables for location of player
//    // x coordinate
//    private int x;
//    // y coordinate
//    private int y;
//    // spriteBatch
//    private SpriteBatch batch;
//    // texture 
//    private Texture personImg;
//    // screen boundaries
//    // nvr mind ignore this (for collision detection only)
//    private boolean topBoundary;
//    private boolean bottemBoundary;
//    private boolean leftBoundary;
//    private boolean rightBoundary;
//    
//    public void create(){
//        batch = new SpriteBatch();
//        personImg = new Texture("person.png");
//        y = 0;
//        x = 600;
//    }
//    
//    public int getX(){
//        return x;
//    }
//    public int getY(){
//        return y;
//    }
//    
//    public void resetY(){
//        this.y = 0;
//    }
//    
//    public void setX(int x){
//        this.x = x;
//    }
//    
//    public void setY(int y){
//        this.y = y;
//    }
//    
//    
//}

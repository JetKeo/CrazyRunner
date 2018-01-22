///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mygdx.game;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//
///**
// *
// * @author sheza
// */
//public class Sound {
//    // Create instance variables
//    // private SpriteBatch batch;
//    private Music song;
//    
//    public void play() {
//        // Make the music stop
//        this.song.stop();
//        // Import the file (song)
//        this.song = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));
//        // this.song = Gdx.audio.newMusic(Gdx.audio.newMusic("sound.mp3"));
//        // Start the music loop
//        this.song.setLooping(true);
//        // Play the song
//        this.song.play();
//    }
//
//    /**
//     * Stop music
//     */
//    public void stopMusic() {
//        // Stop the music
//        this.song.stop();
//    }
//}

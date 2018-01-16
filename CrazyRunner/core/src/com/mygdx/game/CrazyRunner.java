package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CrazyRunner extends ApplicationAdapter {

    private SpriteBatch batch;
    private int[] spot;
    private Grass grass;
    private Ashphalt ashphalt;
    private Water water;
    private int y;
    // Ashphalt ashphalt;
    // Water water;

    @Override
    public void create() {
        batch = new SpriteBatch();
        spot = new int[15];
        this.grass = new Grass(1200, 60);
        this.ashphalt = new Ashphalt(1200, 180);
        this.water = new Water(1200, 180);
        generate();
    }

    public int[] generate() {
        for(int i = 0; i < 15; i++){
            this.spot[i] = (int) Math.ceil(Math.random() * 3);
        }
        return spot;
    }

    @Override
    public void render() {

        batch.begin();
        for(int i = 0; i < 15; i++){
            if(spot[i] == 1){
                batch.draw(grass.getImg(), 0, this.y, grass.getXSize(), grass.getYSize());
                this.y = this.y + 60;
            }else if(spot[i] == 2){
                batch.draw(ashphalt.getImg(), 0, this.y, ashphalt.getXSize(), ashphalt.getYSize());
                this.y = this.y + 180;
            }else{
                batch.draw(water.getImg(), 0, this.y, water.getXSize(), water.getYSize());
                this.y = this.y + 180;
            }
        
        
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        grass.dispose();
    }
}

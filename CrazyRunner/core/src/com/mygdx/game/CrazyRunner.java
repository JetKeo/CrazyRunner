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
    private int grassCount;
    // Ashphalt ashphalt;
    // Water water;

    @Override
    public void create() {
        batch = new SpriteBatch();
        spot = new int[15];
        grassCount = 0;
        this.grass = new Grass(1200, 60);
        this.ashphalt = new Ashphalt(1200, 60);
        this.water = new Water(1200, 60);
        generate();
    }

    public void generate() {
        this.spot[0] = 1;
        this.spot[14] = 1;
        for (int i = 1; i < 14; i++) {
            if (grassCount != 1) {
                this.spot[i] = (int) Math.ceil(Math.random() * 3);
                if(spot[i] == 1){
                grassCount++;
                }
            }else{
                this.spot[i] = (int) Math.random() * 3 + 2;
            }
        }

    }

    @Override
    public void render() {
        //clear screen to prep for drawing
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        //counts 15 spots and places terrain in each spot
        for (int i = 0; i < 15; i++) {
            //1, 2, 3 determine which terrain is rendered, then increase y accordingly for next row
            if (spot[i] == 1) {
                batch.draw(grass.getImg(), 0, this.y, grass.getXSize(), grass.getYSize());
                this.y = this.y + 60;
            } else if (spot[i] == 2) {
                batch.draw(ashphalt.getImg(), 0, this.y, ashphalt.getXSize(), ashphalt.getYSize());
                this.y = this.y + 60;
            } else {
                batch.draw(water.getImg(), 0, this.y, water.getXSize(), water.getYSize());
                this.y = this.y + 60;
            }


        }
        //reset y back to 0
        this.y = 0;
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        grass.dispose();
        ashphalt.dispose();
        water.dispose();
    }
}

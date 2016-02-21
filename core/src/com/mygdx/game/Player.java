package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Player{

    public int posicio;
    public Rectangle r;
	private int w;
	private Rectangle r0, r1, r2;

    public Player(float w){
	    posicio = 1;
	    r0 = new Rectangle((w/6f)-50, 30, 148, 260);
	    r1 = new Rectangle((w/2f)-50, 30, 148, 260);
	    r2 = new Rectangle((w*5/6f)-50, 30, 148, 260);
	    r = r1;
    }

	public void setPosicio(int p){
		if(p == 0) r = r0;
		if(p == 1) r = r1;
		if(p == 2) r = r2;
	}
}

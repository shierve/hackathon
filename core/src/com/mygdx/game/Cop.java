package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Cop{
    private int posicio; //0, 1, 2 (X)
	public int y;
	public Rectangle r;

	public Cop(int posicio, int height){
		float w = Gdx.graphics.getWidth();
		this.posicio = posicio;
		y = height+260;
		r = new Rectangle(posicio, y, w/3.1f, 250);
	}
	public int getPosicio(){
		float w = Gdx.graphics.getWidth();
		if(posicio == 0) return (int)(w/6f)+50;
		if(posicio == 1) return (int)(w/2f)+50;
		if(posicio == 2) return (int)(w*5/6f+50);
		return 0;
	}

	public int getPosicior(){
		float w = Gdx.graphics.getWidth();
		if(posicio == 0) return (int)(0);
		if(posicio == 1) return (int)(w/3f);
		if(posicio == 2) return (int)(w*2/3f);
		return 0;
	}
}

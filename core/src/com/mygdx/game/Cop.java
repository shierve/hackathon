package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

public class Cop{
    private int posicio; //0, 1, 2 (X)
	public int y;
	public Rectangle r;


	public Cop(int posicio, int height){
		this.posicio = posicio;
		y = height+260;
		r = new Rectangle(posicio, y, 148, 260);
	}
	public int getPosicio(){ return posicio; }
}

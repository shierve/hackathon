package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

public class Intersection {
	private double x;
	private double y;
	private Street horizontal;
	private Street vertical;

	private static final int map_size_x = 1061;
	private static final int map_size_y = 1023;
	private static final int margin = 20;

	private boolean green_light;

	public Intersection(double x, double y, Street h, Street v){
		this.x = x;
		this.y = y;
		this.green_light = true;
		horizontal = h;
		vertical = v;
	}

	public double getX(){ return x; }

	public double getY(){ return y; }

	public Street getHorizontal(){ return horizontal; }
	public Street getVertical(){ return vertical; }

	public void setX(double x){
		this.x = x;
	}

	public void setY(double y){
		this.y = y;
	}

	public boolean contains(double x, double y){
		Rectangle r = new Rectangle(Math.round(this.x * map_size_x)-margin, Math.round(this.y * map_size_y)-margin, 2*margin, 2*margin);
		return r.contains((float) x, (float) y);
	}
}

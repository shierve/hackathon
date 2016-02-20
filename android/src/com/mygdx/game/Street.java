package com.mygdx.game;

public class Street {
	private boolean vertical;
	private double position;

	public Street(boolean vertical, double position){
		this.vertical = vertical;
		this.position = position;
	}

	public boolean isVertical(){
		return vertical;
	}

	public double getPosition(){
		return position;
	}

	public void setVertical(boolean b){
		vertical = b;
	}

	public void setPosition(double p){
		position = p;
	}
}

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class Car {
	protected Street street;
	protected double position;
	protected double speed;
	protected int direction; //1 or -1

	//SPRITE with rotation functions

	protected boolean at_intersection;
	protected Intersection intersection;

	public Car(Street street, double position, double speed){
		this.street = street;
		this.position = position;
		this.speed = speed;
		intersection = null;
	}

	public  Car(){
		//make it appear on the edge of view
	}

	public Street getStreet(){
		return street;
	}

	public double getPosition(){
		return position;
	}

	public double getSpeed(){
		return speed;
	}

	public boolean isAtIntersection() {	return at_intersection;	}

	public void checkIntersections(Array<Intersection> intersections) {
		Iterator<Intersection> iter = intersections.iterator();
		while (iter.hasNext()) {
			Intersection i = iter.next();
			if(i.contains((street.isVertical() ? street.getPosition() : position), (street.isVertical() ? position : street.getPosition()))){
				intersection = i;
				at_intersection = true;
				return;
			}
		}
		intersection = null;
		at_intersection = false;
	}

	public void setStreet(Street s){
		street = s;
	}

	public void setPosition(double p){
		position = p;
	}

	public void setSpeed(double s){
		speed = s;
	}

	public void setAtIntersection(boolean b){
		at_intersection = b;
	}

	public void turn_right(){

	}
	public void turn_left(){

	}
}

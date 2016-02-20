package com.mygdx.game;

public class Car {
	private Street street;
	private double position;
	private double speed;

	private boolean at_intersection;

	public Car(Street street, double position, double speed){
		this.street = street;
		this.position = position;
		this.speed = speed;
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

	public boolean isAtIntersection() {
		return at_intersection;
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
}

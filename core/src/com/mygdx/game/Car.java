package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

import javafx.util.Pair;

public abstract class Car {

    protected enum Direction {
        LEFT, DOWN, RIGHT, UP
    }

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
        this.direction = 1;
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

    public Pair<Double,Double> getCoordinates() {
        Double x,y;
        if (street.isVertical()) {
            x = street.getPosition();
            y = getPosition();
        }
        else {
            y = street.getPosition();
            x = getPosition();
        }

        return new Pair<Double, Double>(x,y);
    }

    public void u_turn() {
        //TODO: check if within map
        direction*=-1;
        position += speed*direction;
    }

	public void turn_right(){
        //change street
        street = (street.isVertical() ? intersection.getHorizontal() : intersection.getVertical());
        //direction
        if(!street.isVertical()) direction *= -1;
        //new pos is exact pos of intersection
        position = (street.isVertical() ? intersection.getHorizontal().getPosition() : intersection.getVertical().getPosition());
        //rotate car TODO
	}
	public void turn_left(){
        street = (street.isVertical() ? intersection.getHorizontal() : intersection.getVertical());
        if(street.isVertical()) direction *= -1;
        position = (street.isVertical() ? intersection.getHorizontal().getPosition() : intersection.getVertical().getPosition());
	}

    public void go_straight() {
        //TODO: check
        position += speed*direction;
    }

    public void stop() {
        speed = 0;
    }

    public Direction getCarDirection() {
        if (street.isVertical()) {
            if (direction > 1)
                return Direction.UP;
            else
                return Direction.DOWN;
        }
        else {
            if (direction > 1)
                return Direction.RIGHT;
            else
                return Direction.LEFT;
        }
    }

    public static Direction getPlayerCarDirection(Car dest, Car source) {
        Pair<Double,Double> d_car_coord = dest.getCoordinates();
        Pair<Double,Double> s_car_coord = source.getCoordinates();

        Direction d_car_dir;
        Double x_distance = d_car_coord.getKey()-s_car_coord.getKey();
        Double y_distance = d_car_coord.getValue()-s_car_coord.getValue();

        //Get player car direction from this police car
        if (Math.abs(x_distance) < Math.abs(y_distance)) {
            if (y_distance > 0)
                d_car_dir = Direction.UP;
            else
                d_car_dir = Direction.DOWN;
        }
        else {
            if (x_distance > 0)
                d_car_dir = Direction.RIGHT;
            else
                d_car_dir = Direction.LEFT;
        }
        return d_car_dir;
    }

    public abstract void next_position();

}

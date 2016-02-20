package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class Artificial extends Car{

	public Artificial(){

	}

	public void next_position(Array<Intersection> intersections){
		if(at_intersection){
			Random r = new Random();
			int rn = r.nextInt((3 - 1) + 1) + 1;
			if(rn == 1){
				//TODO: check if within map
				position += speed*direction;
			}
			if(rn == 2){
				//turn right
				//change street
				street = (street.isVertical() ? intersection.getHorizontal() : intersection.getVertical());
				//direction
				if(!street.isVertical()) direction *= -1;
				//new pos is exact pos of intersection
				position = (street.isVertical() ? intersection.getHorizontal().getPosition() : intersection.getVertical().getPosition());
				//rotate car TODO

			}
			if(rn == 3){
				//turn left
				street = (street.isVertical() ? intersection.getHorizontal() : intersection.getVertical());
				if(street.isVertical()) direction *= -1;
				position = (street.isVertical() ? intersection.getHorizontal().getPosition() : intersection.getVertical().getPosition());
			}
		}
		else{
			//TODO: check
			position += speed;
		}
	}
}

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

				//new street is the street with vert != vert and pos pos
				//new pos is exact pos of intersection
				//rotate car
			}
			if(rn == 3){
				//turn left
				//new street
			}
		}
		else{
			//TODO: check
			position += speed;
		}
	}
}

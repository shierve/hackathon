package com.mygdx.game;

import java.util.Random;

public class Artificial extends Car{

	public Artificial(){

	}

	public void next_position(){
		if(at_intersection){
			Random r = new Random();
			int rn = r.nextInt((3 - 1) + 1) + 1;
			if(rn == 1){
				position += speed;
			}
			if(rn == 2){
				//turn right
			}
			if(rn == 3){
				//turn left
			}
		}
		if(){
			//TODO: check if within map
			position += speed;
		}
	}
}

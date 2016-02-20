package com.mygdx.game;

import java.util.Random;

public class Cop extends Car{

	public Cop(Street street, double position, double speed){
		super(street, position, speed);
	}

    @Override
	public void next_position(){
        //TODO: check traffic lights
        if(at_intersection){

        }
        else{
            go_straight();
        }
	}
}

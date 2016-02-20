package com.mygdx.game;

public class Cop extends Car{

	public Cop(Street street, double position, double speed){
		super(street, position, speed);
	}

    @Override
	public void next_position(){
        //TODO: check traffic lights
        if(at_intersection){
            Direction dest_dir = getPlayerCarDirection(this);
            setRelativeDirectionCourse(dest_dir);
        }
        else{
            go_straight();
        }
	}
}

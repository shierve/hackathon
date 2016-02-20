package com.mygdx.game;

public class Cop extends Car{

	public Cop(Street street, double position, double speed){
		super(street, position, speed);
	}

    @Override
	public void next_position(){
        //TODO: check traffic lights
        if(at_intersection){
            Direction my_dir = getCarDirection();
            Direction dest_dir = getPlayerCarDirection(this);
            switch (my_dir) {
                case UP:
                    switch(dest_dir) {
                        case UP:
                            go_straight();
                            break;
                        case DOWN:
                            u_turn();
                            break;
                        case RIGHT:
                            turn_right();
                            break;
                        case LEFT:
                            turn_left();
                            break;
                    }
                    break;
                case DOWN:
                    switch(dest_dir) {
                        case UP:
                            u_turn();
                            break;
                        case DOWN:
                            go_straight();
                            break;
                        case RIGHT:
                            turn_left();
                            break;
                        case LEFT:
                            turn_right();
                            break;
                    }
                    break;
                case RIGHT:
                    switch(dest_dir) {
                        case UP:
                            turn_left();
                            break;
                        case DOWN:
                            turn_right();
                            break;
                        case RIGHT:
                            go_straight();
                            break;
                        case LEFT:
                            u_turn();
                            break;
                    }
                    break;
                case LEFT:
                    switch(dest_dir) {
                        case UP:
                            turn_right();
                            break;
                        case DOWN:
                            turn_left();
                            break;
                        case RIGHT:
                            u_turn();
                            break;
                        case LEFT:
                            go_straight();
                            break;
                    }
                    break;
            }
        }
        else{
            go_straight();
        }
	}
}

package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class Artificial extends Car{

	public Artificial(Street street, double position, double speed) {
        super(street, position, speed);
	}

    @Override
	public void next_position(){
		if(at_intersection){
			Random r = new Random();
			int rn = r.nextInt((3 - 1) + 1) + 1;
            switch (rn) {
                case 1:
                    go_straight();
                    break;
                case 2:
                    turn_right();
                    break;
                case 3:
                    turn_left();
                    break;
            }
		}
		else{
			go_straight();
		}
	}
}

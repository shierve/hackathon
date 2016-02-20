package com.mygdx.game;

public class Player extends Car {

    static private Player player = null;

    private Player(Street street, double position, double speed){
        super(street, position, speed);
    }

    public void newInstance(Street street, double position, double speed){
        if (player == null)
            player = new Player(street, position, speed);
    }

    @Override
    public void next_position(){

    }
}

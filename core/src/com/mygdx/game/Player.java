package com.mygdx.game;

public class Player extends Car {

    static private Direction next_dir;
    static private Player player = null;

    private Player(Street street, double position, double speed){
        super(street, position, speed);
    }

    public static Player newInstance(Street street, double position, double speed){
        if (player == null) {
            player = new Player(street, position, speed);
            return player;
        }
        return null;
    }

    public static Car getCarInstance() {
        return player;
    }

    public static void setNextDir(Direction dir) {
        next_dir = dir;
    }

    @Override
    public void next_position(){
        //TODO:check trafic lights
        if (at_intersection) {
            if (next_dir != null) {
                setRelativeDirectionCourse(next_dir);
            } else
                go_straight();
        }
        else
            go_straight();

        next_dir = null;
    }
}

package com.mygdx.game;

/**
 * Created by Lanma on 20-Feb-16.
 */
public class Player extends Car {

    static private Direction next_dir;
    static private Player player = null;

    private Player(Street street, double position, double speed){
        super(street, position, speed);
    }

    public static void newInstance(Street street, double position, double speed){
        if (player == null)
            player = new Player(street, position, speed);
    }

    public static Car getCarInstance() {
        return player;
    }

    @Override
    public void next_position(){
        //TODO:check trafic lights
        if (next_dir != null) {
            Direction dir = getCarDirection();
            switch (dir) {
                case UP:
                    switch(next_dir) {
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
                    switch(next_dir) {
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
                    switch(next_dir) {
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
                    switch(next_dir) {
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
        else
            go_straight();
        next_dir = null;
    }
}

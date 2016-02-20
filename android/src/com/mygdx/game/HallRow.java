package com.mygdx.game;

/**
 * Created by Lanma on 20-Feb-16.
 */
public class HallRow {
    private String name;
    private int score;

    public HallRow(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

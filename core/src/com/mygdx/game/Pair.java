package com.mygdx.game;

/**
 * Created by Lanma on 20-Feb-16.
 */
public class Pair<K,V> {
    K left;
    V right;

    public Pair(K left, V right) {
        this.left = left;
        this.right = right;
    }

    public K getKey() {
        return left;
    }

    public void setKey(K new_left) {
        left = new_left;
    }

    public V getValue() {
        return right;
    }

    public void setValue(V new_right) {
        right = new_right;
    }
}

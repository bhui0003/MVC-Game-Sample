package com.nimooli.mvc.model;

public class Empty extends Element {

    @Override
    public String toString() {
        return " ";
    }

    @Override
    public boolean move(DIRECTION dir, Element caller) {
        return true;
    }
}

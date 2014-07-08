package com.nimooli.mvc.model;

public class Cheese extends Element {

    @Override
    public String toString() {
        return "h";
    }

    @Override
    public boolean move(DIRECTION dir, Element caller) {
        boolean isMouse = (caller instanceof Mouse);

        if (isMouse) {
            Board.getInstance().updateScore();
            return true;
        }

        return false;
    }

}

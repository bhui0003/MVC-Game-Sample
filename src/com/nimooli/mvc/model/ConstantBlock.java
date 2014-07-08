package com.nimooli.mvc.model;

public class ConstantBlock extends Element {

    @Override
    public String toString() {
        return "X";
    }

    @Override
    public boolean move(DIRECTION dir, Element caller) {
        return false;
    }
}

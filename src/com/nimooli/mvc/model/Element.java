package com.nimooli.mvc.model;

public abstract class Element {

    private Cell container;

    public Cell getContainer() {
        return container;
    }

    public void setContainer(Cell c) {
        container = c;
        if (container.getElement() != this) {
            container.setElement(this);
        }
    }

    public abstract boolean move(DIRECTION dir, Element caller);

    @Override
    public String toString() {
        return "Element";
    }

    public void gameOver() {
    }
}

package com.nimooli.mvc.model;

public class MovableBlock extends Element {

    @Override
    public boolean move(DIRECTION dir, Element caller) {
        Cell neighborCell = getContainer().getNeighbor(dir);
        Element neighborElement = neighborCell.getElement();

        boolean canMove = neighborElement.move(dir, this);

        if (canMove) {
            getContainer().setElement(new Empty());
            neighborCell.setElement(this);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "b";
    }
}

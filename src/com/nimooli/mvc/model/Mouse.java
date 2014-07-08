package com.nimooli.mvc.model;

public class Mouse extends Element {

    int lives;
    boolean trapped = false;
    boolean wasTrappedOnLastMove = false;

    public Mouse(int lives) {
        this.lives = lives;
    }

    public Mouse() {
        lives = 3;
    }

    @Override
    public boolean move(DIRECTION dir, Element caller) {

        if (lives == 0) {
            return false;
        }

        if (trapped)
            return false;


        Cell neighborCell = getContainer().getNeighbor(dir);
        boolean canMove;

        if (neighborCell != null && neighborCell.isEmpty()) {
            canMove = true;
        } else {
            Element neighborElement = neighborCell.getElement();
            canMove = neighborElement.move(dir, this);
        }


        if (canMove) {

            if (wasTrappedOnLastMove) {
                getContainer().setElement(new Trap());
                wasTrappedOnLastMove = false;
            } else {
                getContainer().setElement(new Empty());
            }
            neighborCell.setElement(this);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {

        if (trapped) {
            return "M";
        }

        return "m";

    }

    public int getLives() {
        return lives;
    }

    public boolean isTrapped() {
        return trapped;
    }

    public void setTrapped(boolean trapped) {
        this.trapped = trapped;
        if (trapped == false) {
            wasTrappedOnLastMove = true;
        }
    }

    public void kill() {
        lives--;

        // Game over
        if (lives == 0) {
            Board.getInstance().gameOver();
        } else {
            Board.getInstance().getNewLocation(this);
        }
        Board.getInstance().notifyLivesChanged(lives);

    }
}

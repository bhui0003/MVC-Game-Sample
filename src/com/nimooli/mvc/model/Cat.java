package com.nimooli.mvc.model;

import java.util.Random;

public class Cat extends Element implements Runnable {

    private static Random random;
    boolean steppedOnTrap = false;
    boolean allowedToMove = true;
    private boolean trappedInWalls = false;

    public Cat() {
        random = new Random();
    }

    @Override
    public void run() {
        while (allowedToMove) {
            move();

            try {
                Thread.currentThread().sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void gameOver() {
        allowedToMove = false;
        System.out.println("game over");
    }

    @Override
    public boolean move(DIRECTION dir, Element caller) {

        if (isMouse(caller)) {
            Mouse m = (Mouse) caller;
            m.kill();
            return true;
        } else if (caller != null) { // Cat cannot be pushed by other elements
            return false;
        } else { // cat is moving by itself

            Cell neighborCell = getContainer().getNeighbor(dir);
            Element e = neighborCell.getElement();

            // Maybe the cat moves into a cell that contains a mouse
            if (isMouse(e)) {
                Mouse m = (Mouse) e;
                m.kill();
                getContainer().setElement(new Empty());
                neighborCell.setElement(this);
                return true;
            } else {

                if (neighborCell.isEmpty()) {

                    if (steppedOnTrap) {
                        getContainer().setElement(new Trap());
                        steppedOnTrap = false;
                    } else {
                        getContainer().setElement(new Empty());
                    }

                    neighborCell.setElement(this);
                    return true;
                } else if (e instanceof Trap) {
                    steppedOnTrap = true;
                    getContainer().setElement(new Empty());
                    neighborCell.setElement(this);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    @Override
    public String toString() {
        if (steppedOnTrap) {
            return "C";
        }

        return "c";
    }

    public void move() {
        int tries = 0;
        int randomDir = random.nextInt(4);
        boolean moved = false;

        while (!moved) {
            // Tried all directions already
            if (tries > 8) {
                trappedInWalls = true;
                trapped();
                break;
                // Try another direction
            } else {
                switch (randomDir) {
                    case 0:
                        moved = move(DIRECTION.NORTH, null);
                        break;

                    case 1:
                        moved = move(DIRECTION.EAST, null);
                        break;

                    case 2:
                        moved = move(DIRECTION.WEST, null);
                        break;

                    case 3:
                        moved = move(DIRECTION.SOUTH, null);
                        break;
                }

                if (moved) {
                    trappedInWalls = false;
                }
            }
            randomDir = random.nextInt(4);
            tries++;
        }

    }

    public boolean isSteppedOnTrap() {
        return steppedOnTrap;
    }

    public void setSteppedOnTrap(boolean isOnTrap) {
        steppedOnTrap = isOnTrap;
    }

    private void trapped() {
        System.out.print("Cat is trapped!");
        trappedInWalls = true;
        /* Check if it is the only cat on the board or not
         * if it is, turn into cheese, else just keep trying to move
         */
        if (Board.getInstance().getNumberOfCats() == 1 || Board.getInstance().areAllCatsTrapped()) {
            allowedToMove = false;
            System.out.println("Only one cat on board, turn into cheese!");
            Cheese cheese = new Cheese();
            getContainer().setElement(cheese);
        } else { // If there are other cats that are free, this cat can still try to move
            allowedToMove = true;
            System.out.println(" But still can move because the other cat(s) are free!");

        }


    }

    private boolean isMouse(Element e) {
        return (e instanceof Mouse);
    }

    public boolean isTrappedInWalls() {
        return trappedInWalls;
    }
}

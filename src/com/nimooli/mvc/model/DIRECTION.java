package com.nimooli.mvc.model;

/**
 * Enum that represents 4 directions and can return the opposite direction
 */
public enum DIRECTION {
    WEST, NORTH, EAST, SOUTH;

    private DIRECTION opposite;

    static {
        NORTH.opposite = SOUTH;
        SOUTH.opposite = NORTH;
        EAST.opposite = WEST;
        WEST.opposite = EAST;
    }

    public DIRECTION getOppositeDirection() {
        return opposite;
    }

}

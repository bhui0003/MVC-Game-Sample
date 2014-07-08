package com.nimooli.mvc.model;

import com.nimooli.mvc.view.CellView;

import java.util.EnumMap;

public class Cell {

    private Element element;

    private EnumMap<DIRECTION, Cell> neighborCells;

    private CellView callBackView;

    public Cell() {
        element = new Empty();
    }

    public Cell(Element containedElement) {
        element = containedElement;
        element.setContainer(this);
    }

    @Override
    public String toString() {
        return "Cell: " + this.getElement().toString();
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element containedElement) {
        element = containedElement;
        element.setContainer(this);
        callBackView.redraw();
    }


    public boolean isEmpty() {
        if (element instanceof Empty)
            return true;

        return false;
    }


    public Cell getNeighbor(DIRECTION dir) {
        if (neighborCells != null) {
            return neighborCells.get(dir);
        } else return null;
    }

    /**
     * Sets the neighbor of current cell in direction dir to cell c.
     * Also sets the neighbor of c to this.
     */
    public void setNeighbor(DIRECTION dir, Cell c) {
        if (neighborCells == null) {
            neighborCells = new EnumMap<DIRECTION, Cell>(DIRECTION.class);
        }

        neighborCells.put(dir, c);
    }

    public void setNeighbors(EnumMap<DIRECTION, Cell> map) {
        neighborCells = map;
    }

    public void setCallBackView(CellView callBackView) {
        this.callBackView = callBackView;
    }

    public void clearNeighbors() {
        if (neighborCells != null) {
            neighborCells.clear();
        }
    }


    public EnumMap<DIRECTION, Cell> getNeighborCells() {
        return neighborCells;
    }
}



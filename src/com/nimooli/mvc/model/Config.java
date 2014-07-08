package com.nimooli.mvc.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * ProtoConfig holds a configuration of objects for easier testing.
 */
public class Config {

    private int ROW, COLUMN;
    private List<Cell> configCells;
    private Mouse mouse = null;
    private List<Cat> cats = new ArrayList<Cat>();

    public Config(List<Element> elements, int columnSize) {
        configCells = new ArrayList<Cell>();
        COLUMN = columnSize;
        ROW = elements.size() / columnSize;


        // Create a 2D array from the arraylist
        Element[][] elements2D = new Element[ROW][COLUMN];
        Cell[][] cells = new Cell[ROW][COLUMN];

        // Add elements to the Cells
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                elements2D[i][j] = elements.get(j + (i * COLUMN));

                if (elements2D[i][j] instanceof Mouse) {
                    if (mouse == null) {
                        mouse = (Mouse) elements2D[i][j];
                    } else {
                        System.err.println("More than 1 mouse detected. This will cause problems!");
                    }
                }

                if (elements2D[i][j] instanceof Cat) {
                    cats.add((Cat) elements2D[i][j]);
                }

                cells[i][j] = new Cell(elements2D[i][j]);
                configCells.add(cells[i][j]);
            }
        }

        // Set each cell's neighbors
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {

                Cell currentCell = cells[i][j];
                EnumMap<DIRECTION, Cell> neighbors = new EnumMap<DIRECTION, Cell>(DIRECTION.class);

                // Outer cells on the left side

                if (i != 0) {
                    neighbors.put(DIRECTION.NORTH, cells[i - 1][j]);
                }

                if (i != ROW - 1) {
                    neighbors.put(DIRECTION.SOUTH, cells[i + 1][j]);
                }

                if (j != 0) {
                    neighbors.put(DIRECTION.WEST, cells[i][j - 1]);
                }

                if (j != COLUMN - 1) {
                    neighbors.put(DIRECTION.EAST, cells[i][j + 1]);
                }

                currentCell.setNeighbors(neighbors);
            }
        }
    }

    public Mouse getMouse() {
        return mouse;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public int getRowSize() {
        return ROW;
    }

    public int getColumnSize() {
        return COLUMN;
    }

    /*
     * Prints the board's elements
     */
    public void printBoard() {

        for (int i = 0; i < configCells.size(); i++) {
            if (i != 0 && i % COLUMN == 0) {
                System.out.println();
            }

            System.out.print(configCells.get(i).getElement().toString());

        }
        System.out.println();
    }

    public String getBoardString() {
        StringBuffer res = new StringBuffer(configCells.size() * 2);

        for (Cell c : configCells) {
            res.append(c.getElement().toString());
        }

        return res.toString();
    }

    public void getFreeLocation(Element caller) {
        for (Cell c : configCells) {
            if (c.isEmpty()) {
                caller.getContainer().setElement(new Empty());
                c.setElement(caller);
                return;
            }
        }
    }

    public void resetNeighbors() {
        for (Cell c : configCells) {
            c.clearNeighbors();
        }
    }

    public List<Cell> getCells() {
        return configCells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Config config = (Config) o;

        if (this.getBoardString().equals(config.getBoardString()))
            return true;


        return false;
    }

    @Override
    public String toString() {
        return "ProtoConfig{" +
                "ROW=" + ROW +
                ", COLUMN=" + COLUMN +
                ", configCells=" + configCells +
                '}';
    }

    public void gameOver() {
        for (Cell cell : configCells) {
            cell.getElement().gameOver();
        }
    }
}

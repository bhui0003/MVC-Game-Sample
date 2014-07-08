package com.nimooli.mvc.model;

import com.nimooli.mvc.view.BoardView;

import java.util.List;

public class Board {

    private static Board b = null;
    private static int score;

    private Config boardConfig;
    private BoardView boardView;

    private Board() {

    }

    public static Board getInstance() {
        if (b == null) {
            b = new Board();
        }

        return b;
    }

    /*
     * This method sets the boardConfig to be the given cells.
     * Used in prototype program
     */
    public void init(Config config) {
        score = 0;
        boardConfig = config;
    }


    @Override
    public String toString() {
        return "Board";
    }


    private void resetNeighbors() {
        boardConfig.resetNeighbors();
    }


    // is called by the mouse if it has no more lives
    public void gameOver() {
        boardConfig.gameOver();
    }

    public int getScore() {
        return score;
    }

    public void updateScore() {
        score++;
        boardView.notifyScoreChanged(score);
    }

    // Returns a new empty cell to the caller, mostly used by the Mouse to
    // revive
    public void getNewLocation(Element caller) {
        if (boardConfig != null) {
            boardConfig.getFreeLocation(caller);
        }
    }

    public void register(BoardView boardView) {
        this.boardView = boardView;
    }

    public int getNumberOfCats() {

        if (boardConfig.getCats() == null) {
            System.out.println("BOARDCONFIG RETUNS NULL?!");
        }
        return boardConfig.getCats().size();
    }

    public void notifyLivesChanged(int livesRemaining) {
        boardView.notifyLivesChanged(livesRemaining);
    }

    public void notifyDataChanged() {
        boardView.notifyDataChanged();
    }

    public boolean areAllCatsTrapped() {

        List<Cat> allCats = boardConfig.getCats();
        boolean result = true;

        for (Cat c : allCats) {
            if (!c.isTrappedInWalls()) {
                result = false;
                break;
            }
        }

        return result;
    }
}

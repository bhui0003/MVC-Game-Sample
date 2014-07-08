package com.nimooli.mvc.view;

import com.nimooli.mvc.model.Board;
import com.nimooli.mvc.model.Cell;
import com.nimooli.mvc.model.Config;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nima Ghafoori on 5/9/14.
 */
public class BoardView extends JPanel {

    List<CellView> cellViews;

    private int size; // Size of the board's column, row
    private JPanel gridPanel; //Jpanel containing the grid
    private JPanel topPanel; // Jpanel containing the top bar which hosts the score and lives of mouse
    private JLabel scoreLabel;
    private JLabel livesLabel;

    public BoardView(Config boardConfig) {
        super(new BorderLayout());

        Board.getInstance().register(this); // Register so we can be notified if scores or lives are changed
        Board.getInstance().init(boardConfig);

        gridPanel = new JPanel();
        topPanel = new JPanel();
        scoreLabel = new JLabel("0");
        livesLabel = new JLabel();

        GridLayout gridLayout = new GridLayout(boardConfig.getRowSize(), boardConfig.getColumnSize(), -1, -1);
        gridPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        gridPanel.setLayout(gridLayout);
        gridPanel.setSize(16, 16);

        topPanel.setLayout(new FlowLayout());
        JLabel scoreTextLabel = new JLabel("Score:");

        topPanel.add(scoreTextLabel);
        topPanel.add(scoreLabel);

        JLabel livesTextLabel = new JLabel("Lives:");
        topPanel.add(livesTextLabel);
        topPanel.add(livesLabel);

        add(gridPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        List<Cell> allCells = boardConfig.getCells();
        cellViews = new ArrayList<CellView>();

        for (Cell c : allCells) {
            CellView cellView = new CellView(c);
            cellViews.add(cellView);
            gridPanel.add(cellView);
        }
    }

    public void notifyScoreChanged(int score) { //Added by Dima Chanis
        scoreLabel.setText("" + score);
    }

    public void notifyLivesChanged(int livesRemaining) {//Added by Dima Chanis
        livesLabel.setText("" + livesRemaining);
    }

    public void notifyDataChanged() { //Added by dima Chanis
        gridPanel.validate();
    }
}

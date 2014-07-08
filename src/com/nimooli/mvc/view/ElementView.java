package com.nimooli.mvc.view;

import javax.swing.*;

/**
 * Created by Nima Ghafoori on 5/9/14.
 */
public abstract class ElementView {

    private CellView cellView;

    protected ElementView(CellView c) {
        this.cellView = c;
    }

    public abstract JLabel getElementView();

    public CellView getCellView() {
        return cellView;
    }
}

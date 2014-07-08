package com.nimooli.mvc.view;

import javax.swing.*;

/**
 * Created by Nima Ghafoori on 5/9/14.
 */
public class EmptyView extends ElementView {

    JLabel emptyLabel;

    public EmptyView(CellView c) {
        super(c);
        emptyLabel = new JLabel(" ");
    }

    @Override
    public JLabel getElementView() {
        return emptyLabel;
    }
}

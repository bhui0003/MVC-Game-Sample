package com.nimooli.mvc.view;

import com.nimooli.mvc.Utils;

import javax.swing.*;

/**
 * Created by Nima Ghafoori on 5/9/14.
 */
public class CheeseView extends ElementView {

    JLabel emptyLabel;

    public CheeseView(CellView c) {
        super(c);
        emptyLabel = new JLabel(new ImageIcon(Utils.CHEESE_IMAGE_URL));
    }

    @Override
    public JLabel getElementView() {
        return emptyLabel;
    }
}

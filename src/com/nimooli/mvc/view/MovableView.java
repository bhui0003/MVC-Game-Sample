package com.nimooli.mvc.view;

import com.nimooli.mvc.Utils;

import javax.swing.*;

/**
 * Created by Nima Ghafoori on 5/9/14.
 */
public class MovableView extends ElementView {

    JLabel movableLabel;

    public MovableView(CellView c) {
        super(c);
        movableLabel = new JLabel(new ImageIcon(Utils.UNMOVABLE_IMAGE_URL));
    }

    @Override
    public JLabel getElementView() {
        return movableLabel;
    }
}

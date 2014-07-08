package com.nimooli.mvc.view;

import com.nimooli.mvc.Utils;
import com.nimooli.mvc.model.Mouse;

import javax.swing.*;

//Done by Dima Chanis


public class MouseView extends ElementView {

    JLabel normalLabel;
    JLabel trappedLabel;

    public MouseView(CellView c) {
        super(c);
        normalLabel = new JLabel(new ImageIcon(Utils.MOUSE_IMAGE_URL));
        trappedLabel = new JLabel(new ImageIcon(Utils.MOUSE_TRAPPED_URL));

    }

    @Override
    public JLabel getElementView() {

        // Check if mouse is trapped or not
        if (((Mouse) getCellView().getCell().getElement()).isTrapped()) {
            return trappedLabel;
        }

        return normalLabel;
    }


}

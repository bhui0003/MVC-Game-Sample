package com.nimooli.mvc.view;

import com.nimooli.mvc.Utils;

import javax.swing.*;

//Done by Dima Chanis


public class TrapView extends ElementView {

    JLabel trapLabel;

    public TrapView(CellView c) {
        super(c);
        trapLabel = new JLabel(new ImageIcon(Utils.TRAP_IMAGE_URL));
    }

    @Override
    public JLabel getElementView() {
        return trapLabel;
    }
}

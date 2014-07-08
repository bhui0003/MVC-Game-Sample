package com.nimooli.mvc.view;

import com.nimooli.mvc.Utils;

import javax.swing.*;

/**
 * Created by Nima Ghafoori on 5/9/14.
 */
public class UnmovableView extends ElementView {

    JLabel unmovableLabel;

    public UnmovableView(CellView c) {
        super(c);
        unmovableLabel = new JLabel(new ImageIcon(Utils.MOVABLE_IMAGE_URL));
    }

    @Override
    public JLabel getElementView() {
        return unmovableLabel;
    }
}

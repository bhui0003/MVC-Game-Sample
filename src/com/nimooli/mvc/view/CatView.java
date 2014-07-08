package com.nimooli.mvc.view;

import com.nimooli.mvc.Utils;
import com.nimooli.mvc.model.Cat;

import javax.swing.*;

//Done by Dima Chanis


public class CatView extends ElementView {

    JLabel catLabel;
    JLabel catOnTrapLabel;

    public CatView(CellView c) {
        super(c);
        catLabel = new JLabel(new ImageIcon(Utils.CAT_IMAGE_URL));
        catOnTrapLabel = new JLabel(new ImageIcon(Utils.CAT_TRAPPED_URL));
    }

    @Override
    public JLabel getElementView() {

        if (((Cat) getCellView().getCell().getElement()).isSteppedOnTrap()) {
            return catOnTrapLabel;
        }

        return catLabel;
    }
}

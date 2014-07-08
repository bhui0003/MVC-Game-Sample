package com.nimooli.mvc.view;

import com.nimooli.mvc.model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nima Ghafoori on 5/9/14.
 */
public class CellView extends JPanel {

    ElementView elementView;
    Cell cell;

    public CellView(Cell cell) {
        super(new BorderLayout());
        this.cell = cell;
        cell.setCallBackView(this);
        elementView = getElementViewFromCell(cell);
        add(elementView.getElementView());
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        repaint();

    }

    private ElementView getElementViewFromCell(Cell cell) {
        Element e = cell.getElement();

        if (e instanceof Cat) {
            return new CatView(this);
        } else if (e instanceof Mouse) {
            return new MouseView(this);
        } else if (e instanceof MovableBlock) {
            return new MovableView(this);
        } else if (e instanceof ConstantBlock) {
            return new UnmovableView(this);
        } else if (e instanceof Cheese) {
            return new CheeseView(this);
        } else if (e instanceof Trap) {
            return new TrapView(this);
        } else {
            return new EmptyView(this);
        }

    }

    public boolean isEmpty() {
        return (cell.isEmpty());
    }

    public ElementView getElementView() {
        return elementView;
    }

    public void setElementView(ElementView elementView) {
        this.elementView = elementView;
    }

    public Cell getCell() {
        return cell;
    }


    public void redraw() {
        elementView = getElementViewFromCell(cell);
        removeAll();
        add(elementView.getElementView());
        repaint();
        Board.getInstance().notifyDataChanged();
    }
}

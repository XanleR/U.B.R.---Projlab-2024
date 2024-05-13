package game.graphical;

import javax.swing.*;

public abstract class ElementView {
    private int xCoord;
    private int yCoord;
    private JLabel image;

    protected abstract void drawImage();

    protected abstract void initView();
}

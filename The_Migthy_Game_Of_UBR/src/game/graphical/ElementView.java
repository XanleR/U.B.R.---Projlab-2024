package game.graphical;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public abstract class ElementView {
    protected int xCoord;
    protected int yCoord;
    protected JLabel image;
    protected int preferredWidth;
    protected int preferredHeight;

    public abstract void drawImage();

    protected abstract void initView(JLabel i, int x, int y);
}

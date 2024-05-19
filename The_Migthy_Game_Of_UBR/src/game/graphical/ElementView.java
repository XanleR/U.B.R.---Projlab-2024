package game.graphical;

import javax.swing.*;
import java.awt.*;

public abstract class ElementView {
    protected int xCoord;
    protected int yCoord;
    protected JLabel image;

    public abstract void drawImage(int width, int height);

    protected abstract void initView(JLabel i, int x, int y);
}

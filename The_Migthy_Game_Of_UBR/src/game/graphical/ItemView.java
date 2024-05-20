package game.graphical;

import game.items.Item;

import javax.swing.*;
import java.awt.*;

import static game.GUI.gameFrame;

public class ItemView extends ElementView{

    public ItemView(ImageIcon icon, int x, int y){
        this.xCoord = x;
        this.yCoord = y;
        icon.setImage(icon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        this.image = new JLabel(icon);
        image.setLocation(this.xCoord, this.yCoord);
        image.setSize(50, 50);
        image.setVisible(true);
    }

    @Override
    public void drawImage() {
        gameFrame.getMapView().add(this.image);
        GameFrame.getInstance().getMapView().revalidate();
        GameFrame.getInstance().getMapView().repaint();
    }

    @Override
    protected void initView(JLabel i, int x, int y){}
}

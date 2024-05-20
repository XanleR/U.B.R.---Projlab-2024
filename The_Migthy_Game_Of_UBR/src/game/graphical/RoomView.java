package game.graphical;

import game.rooms.Room;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import static game.GUI.gameFrame;

public class RoomView extends ElementView{

    //private Room room;

    public RoomView(ImageIcon newIcon, int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
        newIcon.setImage(newIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        image = new JLabel(newIcon);
        image.setLocation(xCoord, yCoord);
        image.setSize(50,50);
        image.setVisible(true);
    }

    @Override
    public void drawImage() {
        gameFrame.getMapView().add(image);
        GameFrame.getInstance().getMapView().revalidate();
        GameFrame.getInstance().getMapView().repaint();
    }

    @Override
    protected void initView(JLabel i, int x, int y) {}


}

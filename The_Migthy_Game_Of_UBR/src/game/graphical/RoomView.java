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



    private JLabel maxCharLabel = new JLabel();

    public RoomView(ImageIcon newIcon, int x, int y, Room r) {
        this.xCoord = x;
        this.yCoord = y;
        this.room = r;
        newIcon.setImage(newIcon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        image = new JLabel(newIcon);
        image.setLocation(xCoord, yCoord);
        image.setSize(60,60);
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

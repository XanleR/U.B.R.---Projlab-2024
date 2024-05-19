package game.graphical;

import game.rooms.Room;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RoomView extends ElementView{

    private Room room;

    public RoomView(Room room) {
        this.room = room;
        this.xCoord = room.getX();
        this.yCoord = room.getY();



        try {
            BufferedImage myPicture = ImageIO.read(new File(room.imageLocation()));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            image = picLabel;
            //image.setLocation(xCoord, yCoord);
            image.setBounds(xCoord, yCoord, 20, 20);
            //System.out.printf("Shiiit");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void drawImage() {
        GameFrame.getInstance().getMapView().add(image);
        GameFrame.getInstance().getMapView().revalidate();
        GameFrame.getInstance().getMapView().repaint();


    }

    @Override
    protected void initView(JLabel i, int x, int y) {

    }


}

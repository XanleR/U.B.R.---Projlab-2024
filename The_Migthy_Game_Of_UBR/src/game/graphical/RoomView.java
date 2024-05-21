package game.graphical;

import game.rooms.Room;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static game.GUI.gameFrame;

public class RoomView extends ElementView{

    private Room room;

<<<<<<< Updated upstream
    public RoomView(Room room) {
        this.room = room;
        this.xCoord = room.getX();
        this.yCoord = room.getY();



        //try {
            //BufferedImage myPicture = ImageIO.read(new File(room.imageLocation()));
            ImageIcon myPicture = new ImageIcon(room.imageLocation());
            myPicture.setImage(myPicture.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            image = new JLabel(myPicture);
            image.setLocation(xCoord, yCoord);
            image.setSize(30,30);
            image.setVisible(true);
            //image.setBounds(50, 50, 20, 20);
            //System.out.printf("Shiiit");
        /*} catch (IOException e) {
            throw new RuntimeException(e);
        }*/
=======
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
>>>>>>> Stashed changes
    }

    @Override
    public void drawImage() {
        gameFrame.getMapView().add(image);
        GameFrame.getInstance().getMapView().revalidate();
        GameFrame.getInstance().getMapView().repaint();


    }

    @Override
    protected void initView(JLabel i, int x, int y) {

    }


}

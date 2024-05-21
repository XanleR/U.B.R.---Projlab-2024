package game.graphical;

import game.rooms.Room;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import static game.GUI.gameFrame;

public class RoomView extends ElementView{

    private Room room;

    private JLabel maxCharLabel = new JLabel();

    private String filename;

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

        for(Room tmpRoom : room.getNeighbours()){
            filename = "Assets/arrow.png";
            if(room.getX() < tmpRoom.getX() || (room.getX() == tmpRoom.getX() && room.getY() < tmpRoom.getY()) ){
                filename = "Assets/arrowBackwards.png";
            }
            if(tmpRoom.getNeighbours().contains(room)){
                filename = "Assets/arrow2way.png";
            }

            JLabel arrow = drawArrow(room.getX()+30, room.getY()+30, tmpRoom.getX()+30, tmpRoom.getY()+30);
            gameFrame.addArrow(arrow);



        }

        gameFrame.getMapView().add(image);



        GameFrame.getInstance().getMapView().revalidate();
        GameFrame.getInstance().getMapView().repaint();
    }

    @Override
    protected void initView(JLabel i, int x, int y) {}


    private JLabel drawArrow(int x1, int y1, int x2, int y2) {
        int width = Math.abs(x1 - x2);
        int heigh = Math.abs(y1 - y2);

        double degree = Math.toDegrees(Math.atan((double) heigh / (double) width));
        if ((x1 < x2 && y1 > y2) || (x1 > x2 && y1 < y2)){
            degree *= -1;
        }
        try{

            BufferedImage originalimg = ImageIO.read(new File(filename));
            BufferedImage rotatedImg = rotate(originalimg, degree);
            JLabel arrow = new JLabel(new ImageIcon(rotatedImg));

            if (x1 <= x2 && y1 <= y2)
                arrow.setBounds(x1, y1, width, heigh);
            else if (x1 < x2 && y1 > y2)
                arrow.setBounds(x1, y2, width, heigh);
            else if (x1 > x2 && y1 < y2)
                arrow.setBounds(x2, y1, width, heigh);
            else if (x1 >= x2 && y1 >= y2)
                arrow.setBounds(x2, y2, width, heigh);

            return arrow;


        }catch (Exception e){
            System.out.println("Error loading in the arrow image" + e);
        }

        return null;
    }

    public BufferedImage rotate(BufferedImage image, double degrees) {

        double radians = Math.toRadians(degrees);
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        int newWidth = (int) Math.round(image.getWidth() * cos + image.getHeight() * sin);
        int newHeight = (int) Math.round(image.getWidth() * sin + image.getHeight() * cos);

        BufferedImage rotate = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotate.createGraphics();
        int x = (newWidth - image.getWidth()) / 2;
        int y = (newHeight - image.getHeight()) / 2;

        AffineTransform at = new AffineTransform();
        at.setToRotation(radians, x + (image.getWidth() / 2), y + (image.getHeight() / 2));

        at.translate(x, y);
        g2d.setTransform(at);
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return rotate;
    }

//    private JLabel drawArrow(int x1, int y1, int x2, int y2) {
//        BufferedImage arrowImage = null;
//        try {
//            arrowImage = ImageIO.read(new File("Assets/Door(OneWay).png"));
//        } catch (Exception e) {
//            System.out.println("Error loading arrow image...");
//        }
//        double angle = Math.atan2(y2 - y1, x2 - x1);
//        double distance = Math.hypot(x2 - x1, y2 - y1);
//
//        int arrowWidth = (int) distance;
//        int arrowHeight = arrowImage.getHeight();
//        BufferedImage transformedImage = new BufferedImage(
//                arrowWidth, arrowHeight, BufferedImage.TYPE_INT_ARGB);
//
//        Graphics2D g2d = transformedImage.createGraphics();
//        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        AffineTransform tx = new AffineTransform();
//        tx.translate(0, arrowHeight / 2.0);  // Translate to the middle of the height
//        tx.rotate(angle, 0, 0);  // Rotate around the translated origin
//        tx.scale(distance / arrowImage.getWidth(), 1.0);  // Scale only width
//        tx.translate(0, -arrowHeight / 2.0);  // Translate back after rotation
//
//        g2d.drawImage(arrowImage, tx, null);
//        g2d.dispose();
//
//        ImageIcon arrowIcon = new ImageIcon(transformedImage);
//        JLabel arrowLabel = new JLabel(arrowIcon);
//        arrowLabel.setBounds(x1, y1 - arrowHeight / 2, arrowWidth, arrowHeight);
//
//        return arrowLabel;
//    }

}

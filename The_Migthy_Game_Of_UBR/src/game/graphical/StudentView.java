package game.graphical;

import game.characters.Character;
import game.characters.Student;

import javax.swing.*;

import java.awt.*;

import static game.GUI.gameFrame;

public class StudentView extends CharacterView{
    private JLabel maskedLabel;
    private JLabel tvszLabel;


    private Student student;

    public StudentView(ImageIcon icon, Student _student) {
        super(icon, _student);
        this.student = _student;
        maskedLabel = new JLabel(Integer.toString(_student.getxCoord()));
        maskedLabel.setLocation(student.getxCoord() + 3, student.getyCoord() + 3);
        tvszLabel = new JLabel(Integer.toString(student.getTVSZ() == null ? 0 : student.getTVSZ().getRemainingProtection()));
        tvszLabel.setLocation(student.getxCoord() + 5, student.getyCoord() + 5);
    }

    @Override
    public void drawImage() {


        this.xCoord = student.getxCoord();
        this.yCoord = student.getyCoord();
        image.setLocation(xCoord, yCoord);

        gameFrame.getMapView().add(this.image);

        gameFrame.getMapView().add(maskedLabel);
        gameFrame.getMapView().add(tvszLabel);

        GameFrame.getInstance().getMapView().revalidate();
        GameFrame.getInstance().getMapView().repaint();
    }

}

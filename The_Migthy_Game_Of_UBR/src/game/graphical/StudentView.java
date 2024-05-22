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
        maskedLabel = new JLabel(Integer.toString(_student.getMaskedRounds()));
        maskedLabel.setLocation(student.getxCoord() + 25, student.getyCoord() + 25);
        tvszLabel = new JLabel(Integer.toString(student.getTVSZ() == null ? 0 : student.getTVSZ().getRemainingProtection()));
        tvszLabel.setLocation(student.getxCoord() + 25, student.getyCoord() + 15);
        maskedLabel.setSize(50, 30);
        tvszLabel.setSize(50, 30);
    }

    @Override
    public void drawImage() {
        this.xCoord = student.getxCoord();
        this.yCoord = student.getyCoord();
        image.setLocation(xCoord, yCoord);
        nameLAbel.setLocation(this.character.getxCoord()-15, this.character.getyCoord()+15);
        nameLAbel.setSize(100, 50);
        maskedLabel.setLocation(student.getxCoord() + 25, student.getyCoord() + 25);
        tvszLabel.setLocation(student.getxCoord() + 25, student.getyCoord() + 15);
        maskedLabel.setSize(50, 30);
        tvszLabel.setSize(50, 30);

        gameFrame.getMapView().add(this.image);

        gameFrame.getMapView().add(maskedLabel);
        gameFrame.getMapView().add(tvszLabel);
        gameFrame.getMapView().add(nameLAbel);
        GameFrame.getInstance().getMapView().revalidate();
        GameFrame.getInstance().getMapView().repaint();
    }

}

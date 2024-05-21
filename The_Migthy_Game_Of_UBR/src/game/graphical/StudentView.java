package game.graphical;

import game.characters.Character;
import game.characters.Student;

import javax.swing.*;

import static game.GUI.gameFrame;

public class StudentView extends CharacterView{
    private Student s;
    private JLabel maskedLabel;
    private JLabel tvszLabel;
<<<<<<< Updated upstream
    public StudentView(Student s) {
        super(s);
        this.s = s;
=======

    private Student student;

    public StudentView(ImageIcon icon, Student _student) {
        super(icon, _student);
        this.student = _student;
        maskedLabel = new JLabel(Integer.toString(_student.getxCoord()));
        maskedLabel.setLocation(student.getxCoord() + 3, student.getyCoord() + 3);
        tvszLabel = new JLabel(Integer.toString(student.getTVSZ() == null ? 0 : student.getTVSZ().getRemainingProtection()));
        tvszLabel.setLocation(student.getxCoord() + 5, student.getyCoord() + 5);
>>>>>>> Stashed changes
    }

    @Override
    public void drawImage() {
        super.drawImage();
        maskedLabel.setSize(preferredWidth - 2, preferredHeight - 2);
        tvszLabel.setSize(preferredWidth - 2, preferredHeight - 2);
        gameFrame.getMapView().add(maskedLabel);
        gameFrame.getMapView().add(tvszLabel);
    }

    @Override
    protected void initView(JLabel i, int x, int y) {
        super.initView(i, x, y);
        String mask = Integer.toString(s.getMaskedRounds());
        maskedLabel = new JLabel(mask);
        maskedLabel.setLocation(x, y + 1);

        String tvszL = Integer.toString(s.getTVSZ().getRemainingProtection());
        tvszLabel = new JLabel(tvszL);
        tvszLabel.setLocation(x + 1, y + 1);
    }
}

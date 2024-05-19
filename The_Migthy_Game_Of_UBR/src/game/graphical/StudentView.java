package game.graphical;

import game.characters.Character;
import game.characters.Student;

import javax.swing.*;

import static game.GUI.gameFrame;

public class StudentView extends CharacterView{
    private Student s;
    private JLabel maskedLabel;
    private JLabel tvszLabel;
    public StudentView(Student s) {
        super(s);
        this.s = s;
    }

    @Override
    public void drawImage(int width, int height) {
        super.drawImage(width, height);
        maskedLabel.setSize(width - 2, height - 2);
        tvszLabel.setSize(width - 2, height - 2);
        gameFrame.mapView.add(maskedLabel);
        gameFrame.mapView.add(tvszLabel);
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

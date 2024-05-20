package game.graphical;

import game.characters.Character;
import game.characters.Student;

import javax.swing.*;

import java.awt.*;

import static game.GUI.gameFrame;

public class StudentView extends CharacterView{
    private JLabel maskedLabel;
    private JLabel tvszLabel;

    public StudentView(ImageIcon icon, int x, int y, int stun, int mask, int tvsz) {
        super(icon, x, y, stun);
        maskedLabel = new JLabel(Integer.toString(mask));
        maskedLabel.setLocation(x + 3, y + 3);
        tvszLabel = new JLabel(Integer.toString(tvsz));
        tvszLabel.setLocation(x + 5, y + 5);
    }

    @Override
    public void drawImage() {
        super.drawImage();
        gameFrame.getMapView().add(maskedLabel);
        gameFrame.getMapView().add(tvszLabel);
    }

}

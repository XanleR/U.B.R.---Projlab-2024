package game.graphical;

import game.items.Item;

import javax.swing.*;

import static game.GUI.gameFrame;

public class FFP2View extends ItemView{

    JLabel durabilityLabel;
    public FFP2View(ImageIcon icon, int x, int y, int durabilityCount) {
        super(icon, x, y);
        durabilityLabel = new JLabel(Integer.toString(durabilityCount));
        durabilityLabel.setLocation(x+2, y+2);
        durabilityLabel.setSize(15, 15);
    }

    @Override
    public void drawImage() {
        super.drawImage();
        gameFrame.getMapView().add(this.durabilityLabel);
    }
}

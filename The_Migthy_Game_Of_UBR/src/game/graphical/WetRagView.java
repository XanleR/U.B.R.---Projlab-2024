package game.graphical;

import game.items.Item;

import javax.swing.*;

import static game.GUI.gameFrame;

public class WetRagView extends ItemView{

    private JLabel wetnessLabel;
    public WetRagView(ImageIcon icon, int x, int y, int wetness) {
        super(icon, x, y);
        wetnessLabel = new JLabel(Integer.toString(wetness));
        wetnessLabel.setLocation(x-7, y-7);
        wetnessLabel.setSize(30, 30);
    }

    @Override
    public void drawImage() {
        super.drawImage();
        gameFrame.getMapView().add(this.wetnessLabel);
    }
}

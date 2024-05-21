package game.graphical;

import game.items.Item;

import javax.swing.*;

import static game.GUI.gameFrame;

public class TransistorView extends ItemView{

    private JLabel isOnLabel;
    private JLabel isPairedLabel;
    public TransistorView(ImageIcon icon, int x, int y, boolean isOn, boolean isPaired) {
        super(icon, x, y);
        if(isOn){
            isOnLabel = new JLabel("ON");
        }else{
            isOnLabel = new JLabel("OFF");
        }
        if(isPaired){
            isPairedLabel = new JLabel("P");
        }else{
            isPairedLabel = new JLabel("IP");
        }

        isOnLabel.setLocation(x+4, y-10);
        isPairedLabel.setLocation(x+4, y-20);
        isOnLabel.setSize(40, 40);
        isPairedLabel.setSize(40, 40);
    }

    @Override
    public void drawImage() {
        super.drawImage();
        gameFrame.getMapView().add(this.isOnLabel);
        gameFrame.getMapView().add(this.isPairedLabel);
    }
}

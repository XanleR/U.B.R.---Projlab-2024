package game.graphical;

import game.items.Item;
import game.items.TVSZ;

import javax.swing.*;

import static game.GUI.gameFrame;

public class TVSZView extends ItemView{
    private JLabel remainingProtLabel;

    public TVSZView(ImageIcon icon, int x, int y, int remaingingProt) {
        super(icon, x, y);
        remainingProtLabel = new JLabel(Integer.toString(remaingingProt));
        remainingProtLabel.setLocation(x+2, y+2);
    }


    @Override
    protected void initView(JLabel i, int x, int y){}

    @Override
    public void drawImage() {
        super.drawImage();
        gameFrame.getMapView().add(remainingProtLabel);
        GameFrame.getInstance().getMapView().revalidate();
        GameFrame.getInstance().getMapView().repaint();
    }
}

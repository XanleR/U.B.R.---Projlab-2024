package game.graphical;

import game.items.Item;
import game.items.TVSZ;

import javax.swing.*;

import static game.GUI.gameFrame;

public class TVSZView extends ItemView{
    private JLabel remainingProtLabel;
    private TVSZ tvsz;
    public TVSZView(TVSZ tvsz) {
        super(tvsz);
        this.tvsz = tvsz;
    }

    @Override
    protected void initView(JLabel i, int x, int y){
        i.setLocation(this.xCoord, this.yCoord);
        this.image = i;
        String s = Integer.toString(this.tvsz.getRemainingProtection());
        this.remainingProtLabel = new JLabel(s);
        this.remainingProtLabel.setLocation(this.xCoord + 1, this.yCoord + 1);
    }

    @Override
    public void drawImage(int width, int height) {
        super.drawImage(width, height);
        remainingProtLabel.setSize(width - 2, height - 2);
        gameFrame.mapView.add(remainingProtLabel);
    }
}

package game.graphical;

import game.items.Item;

import javax.swing.*;
import java.awt.*;

import static game.GUI.gameFrame;

public class ItemView extends ElementView{
    protected Item item;
    public ItemView (Item i){
        this.item = i;
    }

    @Override
    public void drawImage() {
        this.image.setPreferredSize(new Dimension(preferredWidth, preferredHeight));
        gameFrame.getMapView().add(this.image);
    }

    @Override
    protected void initView(JLabel i, int x, int y){
        i.setLocation(this.xCoord, this.yCoord);
        this.image = i;
    }
}

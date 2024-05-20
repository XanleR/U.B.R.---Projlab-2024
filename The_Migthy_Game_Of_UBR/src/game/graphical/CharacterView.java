package game.graphical;

import game.characters.Character;
import game.items.Item;

import javax.swing.*;
import java.awt.*;

import static game.GUI.gameFrame;

public class CharacterView extends ElementView {

    protected JLabel stunnedLabel;
    public CharacterView (ImageIcon icon, int x, int y, int stun){
        this.xCoord = x;
        this.yCoord = y;
        icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        this.image = new JLabel(icon);
        image.setLocation(x, y);
        stunnedLabel = new JLabel(Integer.toString(stun));
        stunnedLabel.setLocation(this.xCoord + 2, this.yCoord + 2);
    }
    
    @Override
    public void drawImage() {
        gameFrame.getMapView().add(this.image);
        gameFrame.getMapView().add(stunnedLabel);
        GameFrame.getInstance().getMapView().revalidate();
        GameFrame.getInstance().getMapView().repaint();
    }

    @Override
    protected void initView(JLabel i, int x, int y){}
}

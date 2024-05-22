package game.graphical;

import game.characters.Character;
import game.items.Item;

import javax.swing.*;
import java.awt.*;

import static game.GUI.gameFrame;

public class CharacterView extends ElementView {

    protected JLabel stunnedLabel;
    Character character;

    public CharacterView (ImageIcon icon, Character _character) {
        this.xCoord = _character.getxCoord();
        this.yCoord = _character.getyCoord();
        this.character = _character;
        icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        this.image = new JLabel(icon);
        image.setLocation(xCoord, yCoord);
        image.setSize(30, 30);
        stunnedLabel = new JLabel(Integer.toString(character.getStunnedRounds()));
        stunnedLabel.setLocation(this.xCoord + 2, this.yCoord + 2);
    }
    
    @Override
    public void drawImage() {
        this.xCoord = character.getxCoord();
        this.yCoord = character.getyCoord();

        image.setLocation(xCoord, yCoord);

        gameFrame.getMapView().add(this.image);
        gameFrame.getMapView().add(stunnedLabel);
        GameFrame.getInstance().getMapView().revalidate();
        GameFrame.getInstance().getMapView().repaint();
    }

    @Override
    protected void initView(JLabel i, int x, int y){}
}

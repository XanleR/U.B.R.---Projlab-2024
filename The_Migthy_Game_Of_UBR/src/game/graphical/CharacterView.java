package game.graphical;

import game.characters.Character;
import game.items.Item;

import javax.swing.*;
import java.awt.*;

import static game.GUI.gameFrame;

public class CharacterView extends ElementView {

    protected Character character;
    protected JLabel stunnedLabel;
    public CharacterView (Character c){
        this.character = c;
    }
    @Override
    public void drawImage(int width, int height) {
        this.image.setPreferredSize(new Dimension(width, height));
        gameFrame.mapView.add(this.image);
        stunnedLabel.setSize(width - 2, height - 2);
        gameFrame.mapView.add(stunnedLabel);
    }
    @Override
    protected void initView(JLabel i, int x, int y){
        i.setLocation(this.xCoord, this.yCoord);
        this.image = i;

        String stun = Integer.toString(character.getStunnedRounds());
        stunnedLabel = new JLabel(stun);
        stunnedLabel.setLocation(x - 1, y - 1);
    }
}

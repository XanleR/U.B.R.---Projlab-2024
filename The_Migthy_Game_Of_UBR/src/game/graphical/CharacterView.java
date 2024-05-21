package game.graphical;

import game.characters.Character;
import game.items.Item;

import javax.swing.*;
import java.awt.*;

import static game.GUI.gameFrame;

public class CharacterView extends ElementView {

    private Character character;
    protected JLabel stunnedLabel;
<<<<<<< Updated upstream
    public CharacterView (Character c){
        this.character = c;
=======
    public CharacterView (ImageIcon icon, Character _character){
        this.xCoord = _character.getxCoord();
        this.yCoord = _character.getyCoord();
        this.character = _character;
        icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        this.image = new JLabel(icon);
        image.setLocation(xCoord, yCoord);
        image.setSize(30, 30);
        stunnedLabel = new JLabel(Integer.toString(character.getStunnedRounds()));
        stunnedLabel.setLocation(this.xCoord + 2, this.yCoord + 2);
>>>>>>> Stashed changes
    }
    
    @Override
    public void drawImage() {
        this.image.setPreferredSize(new Dimension(preferredWidth, preferredHeight));
        gameFrame.getMapView().add(this.image);
        stunnedLabel.setSize(preferredWidth - 2, preferredHeight - 2);
        gameFrame.getMapView().add(stunnedLabel);
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

package game.graphical;

import game.characters.Character;
import game.items.Item;

import javax.swing.*;
import java.awt.*;

import static game.GUI.gameFrame;

public class CharacterView extends ElementView {

    protected JLabel stunnedLabel;
    protected JLabel nameLAbel;
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
        stunnedLabel.setLocation(this.xCoord + 40, this.yCoord + 40);
        nameLAbel = new JLabel(this.character.getUniqueName());
        nameLAbel.setLocation(_character.getxCoord()-15, _character.getyCoord()+15);
        nameLAbel.setSize(100, 50);
    }
    
    @Override
    public void drawImage() {



        this.xCoord = character.getxCoord();
        this.yCoord = character.getyCoord();

        if(xCoord == 0 && yCoord == 0){
            System.out.println("Null for some reason");
        }

        image.setLocation(xCoord, yCoord);
        nameLAbel.setLocation(this.character.getxCoord()-15, this.character.getyCoord()+15);
        stunnedLabel.setLocation(this.xCoord + 40, this.yCoord + 40);
        nameLAbel.setSize(100, 50);
        gameFrame.getMapView().add(this.image);
        gameFrame.getMapView().add(stunnedLabel);
        gameFrame.getMapView().add(nameLAbel);
        GameFrame.getInstance().getMapView().revalidate();
        GameFrame.getInstance().getMapView().repaint();
    }

    @Override
    protected void initView(JLabel i, int x, int y){}
}

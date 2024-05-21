package game.graphical;

import game.items.GlassOfBeer;

import javax.swing.*;

import static game.GUI.gameFrame;

public class GlassOfBeerView extends ItemView{
    private JLabel activatedLabel;
    private JLabel activeRoundsLabel;

    public GlassOfBeerView(ImageIcon icon, int x, int y, int activeRounds, boolean isActive) {
        super(icon, x, y);
        if(isActive){
            activatedLabel = new JLabel("A");
        }else{
            activatedLabel = new JLabel("IA");
        }
        activeRoundsLabel = new JLabel(Integer.toString(activeRounds));
        activatedLabel.setLocation(x+2, y);
        activeRoundsLabel.setLocation(x+2, y+2);
        activatedLabel.setSize(15, 15);
        activeRoundsLabel.setSize(15, 15);
    }


    @Override
    public void drawImage() {
        super.drawImage();
        gameFrame.getMapView().add(activatedLabel);
        gameFrame.getMapView().add(activeRoundsLabel);
    }

    @Override
    protected void initView(JLabel i, int x, int y) {}
}

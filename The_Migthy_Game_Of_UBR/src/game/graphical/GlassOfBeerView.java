package game.graphical;

import game.items.GlassOfBeer;

import javax.swing.*;

import static game.GUI.gameFrame;

public class GlassOfBeerView extends ItemView{
    private JLabel activatedLabel;
    private JLabel activeRoundsLabel;
    private GlassOfBeer glassOfBeer;

    public GlassOfBeerView(GlassOfBeer glassOfBeer) {
        super(glassOfBeer);
        this.glassOfBeer = glassOfBeer;
    }

    @Override
    public void drawImage() {
        super.drawImage();
        activatedLabel.setSize(preferredWidth - 2, preferredHeight - 2);
        activeRoundsLabel.setSize(preferredWidth - 2, preferredHeight - 2);
        gameFrame.getMapView().add(activatedLabel);
        gameFrame.getMapView().add(activeRoundsLabel);
    }

    @Override
    protected void initView(JLabel i, int x, int y) {
        super.initView(i, x, y);

        String isActive;
        if (this.glassOfBeer.getActivated()){
            isActive = "Active";
        }
        else {
            isActive = "Inactive";
        }
        activatedLabel = new JLabel(isActive);
        activatedLabel.setLocation(x, y + 1);

        String activatedRounds = Integer.toString(this.glassOfBeer.getActiveRounds());
        activeRoundsLabel = new JLabel((activatedRounds));
        activeRoundsLabel.setLocation(x + 1, y + 1);
    }
}

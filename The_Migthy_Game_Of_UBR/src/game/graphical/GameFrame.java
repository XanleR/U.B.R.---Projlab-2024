package game.graphical;

import game.GameController;
import game.characters.Character;
import game.characters.Student;
import game.rooms.Room;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    //Az aktuálisan körön lévő játékosnak a neve
    private JLabel actualPlayer = new JLabel();
    //Az aktuális játékosnak a maradék akcióinak száma
    private JLabel remainingAction = new JLabel();
    //A játék köreinek számlálója
    private JLabel currentRound = new JLabel();
    //Gomb, amivel a hallgató tud mozogni
    private JButton moveButton;
    //Gomb, amivel a hallgató tud tranzisztor ugrást végrehajtani
    private JButton tranJumpButton;
    //Gomb, amivel a hallgató el tud dobni egy itemet
    private JButton dropItemButton;
    //Gomb, amivel egy hallgató tud használni egy itemet
    private JButton useItemButton;
    //Gomb, amivel a hallgató be tudja kapcsolni a szobában a tranzisztort
    private JButton turnOnTransButton;
    //Gomb, amivel a hallgató a tétlen maradását tudja végrehajtani
    private JButton idleButton;
    //A pálya eltárolására szolgáló változó
    private MapView mapView;
    //Az aktuálisan körön lévő karakter, melyről szeretnénk információt kirajzolni
    private Student currentPlayer;
    private JPanel controllerPanel = new JPanel();

    private static GameFrame instance;

    private final int frameWidth = 1000;
    private final int frameHeight = 600;

    private GameFrame(){}

    public static GameFrame getInstance(){
        if(instance == null){
            instance = new GameFrame();
        }
        return instance;
    }


    //input: -
    //method: A gombokat inicializálja
    //return: void
    public void initButtons(){
        moveButton = new JButton("Move");
        tranJumpButton = new JButton("Transistor Jump");
        dropItemButton = new JButton("Drop Item");
        useItemButton = new JButton("Use Item");
        turnOnTransButton = new JButton("Turn On Transistor");
        idleButton = new JButton("Idle");
    }

    //input: -
    //method: Frissíti a pályán kívüli egyéb HUD elemek tartalmát
    //return: void
    public void updateHud(){
        if(currentPlayer != null){
            actualPlayer.setText(currentPlayer.getUniqueName());
            remainingAction.setText("Remaining Action: " + currentPlayer.getRemainingactions());
            currentRound.setText("Round " + GameController.getInstance().getRoundCounter());

            //magic
            moveButton.setEnabled(currentPlayer.getRoom().getNeighbours().stream().anyMatch(room -> room.isAccessible(currentPlayer.getRoom())));

            tranJumpButton.setEnabled(currentPlayer.getRoom().geTransistor() != null && currentPlayer.getRoom().geTransistor().getIsOn());
            dropItemButton.setEnabled(!currentPlayer.getInventory().isEmpty());
            useItemButton.setEnabled(!currentPlayer.getInventory().isEmpty());
            turnOnTransButton.setEnabled(currentPlayer.getRoom().geTransistor() != null && !currentPlayer.getRoom().geTransistor().getIsOn());
        }
        else{
            actualPlayer.setText("Unkown");
            remainingAction.setText("Unkown");
            moveButton.setEnabled(false);
            tranJumpButton.setEnabled(false);
            dropItemButton.setEnabled(false);
            useItemButton.setEnabled(false);
            turnOnTransButton.setEnabled(false);
        }

    }

    //input: -
    //method: Kirajzolja az egész képernyőt a pályával együtt
    //return: void
    public void drawMap(){
        this.updateHud();

        //mapView.draw();
    }

    public void drawMap(Student student){
        currentPlayer = student;
        drawMap();
    }

    //input: -
    //method: Inicializálja az egész képernyőt
    //return: void
    public void initFrame(){
        setTitle("SlideRule");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        setSize(frameWidth, frameHeight);



        initButtons();
        controllerPanel.setLayout(new GridLayout(0, 1));
        controllerPanel.add(moveButton);
        controllerPanel.add(tranJumpButton);
        controllerPanel.add(dropItemButton);
        controllerPanel.add(useItemButton);
        controllerPanel.add(turnOnTransButton);
        controllerPanel.add(idleButton);

        add(controllerPanel, BorderLayout.WEST);

        //mapView.initPanel();

        //pack();

        setLocationRelativeTo(null);
        setVisible(true);

        drawMap();
    }
}

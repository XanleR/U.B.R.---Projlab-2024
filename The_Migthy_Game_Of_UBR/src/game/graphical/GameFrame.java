package game.graphical;

import game.GameController;
import game.characters.Character;
import game.characters.Student;
import game.rooms.Room;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    private JPanel arrows = new JPanel();

    private JLayeredPane layeredPane = new JLayeredPane();

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

    public void setMapView(MapView mapView){
        this.mapView = mapView;
    }

    public MapView getMapView() {
        return mapView;
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
            actualPlayer.setText("Players name");
            actualPlayer.setForeground(new Color(255, 178, 102));
            actualPlayer.setFont(new Font("Segoe UI", Font.BOLD, 15));
            actualPlayer.setHorizontalAlignment(SwingConstants.CENTER);

            remainingAction.setText("Remaining Actions: XX");
            remainingAction.setHorizontalAlignment(SwingConstants.CENTER);
            remainingAction.setForeground(new Color(255, 178, 102));
            remainingAction.setFont(new Font("Segoe UI", Font.BOLD, 15));

            currentRound.setText("X. Round");
            currentRound.setHorizontalAlignment(SwingConstants.CENTER);
            currentRound.setForeground(new Color(255, 178, 102));
            currentRound.setFont(new Font("Segoe UI", Font.BOLD, 20));
            currentRound.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255, 178, 102)));

            moveButton.setEnabled(false);
            tranJumpButton.setEnabled(false);
            dropItemButton.setEnabled(false);
            useItemButton.setEnabled(false);
            turnOnTransButton.setEnabled(false);
        }

        moveButton.setBackground(new Color(255, 153, 51));
        moveButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        moveButton.setForeground(new Color(153, 76, 0));

        tranJumpButton.setBackground(new Color(255, 153, 51));
        tranJumpButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        tranJumpButton.setForeground(new Color(153, 76, 0));

        dropItemButton.setBackground(new Color(255, 153, 51));
        dropItemButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        dropItemButton.setForeground(new Color(153, 76, 0));

        useItemButton.setBackground(new Color(255, 153, 51));
        useItemButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        useItemButton.setForeground(new Color(153, 76, 0));

        turnOnTransButton.setBackground(new Color(255, 153, 51));
        turnOnTransButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        turnOnTransButton.setForeground(new Color(153, 76, 0));

        idleButton.setBackground(new Color(255, 153, 51));
        idleButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        idleButton.setForeground(new Color(153, 76, 0));


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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        setSize(frameWidth, frameHeight);



        initButtons();
        controllerPanel.setLayout(new GridLayout(0, 1));
        controllerPanel.add(currentRound);
        controllerPanel.add(actualPlayer);
        controllerPanel.add(remainingAction);
        controllerPanel.add(moveButton);
        controllerPanel.add(tranJumpButton);
        controllerPanel.add(dropItemButton);
        controllerPanel.add(useItemButton);
        controllerPanel.add(turnOnTransButton);
        controllerPanel.add(idleButton);

        controllerPanel.setBackground(new Color(153, 76, 0));
        controllerPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        add(controllerPanel, BorderLayout.WEST);


        mapView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println("Kattintás koordinátái: (" + x + ", " + y + ")");
            }
        });



        //mapView.setBackground(new Color(255, 0, 255));

        mapView.draw();





        mapView.setLayout(null);
        mapView.setBounds(0, 0, frameWidth- controllerPanel.getWidth(), frameHeight);
        //mapView.setBackground(new Color(0, 0, 0,0));
        mapView.setOpaque(false);


        arrows.setLayout(null);
        arrows.setBounds(0, 0, frameWidth- controllerPanel.getWidth(), frameHeight);
        arrows.setBackground(Color.WHITE);
        arrows.setOpaque(true);

        layeredPane.setBounds(0, 0, frameWidth - controllerPanel.getWidth(), frameHeight);
        layeredPane.add(arrows, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(mapView, JLayeredPane.PALETTE_LAYER);

        //getContentPane().add(layeredPane);

        add(layeredPane, BorderLayout.CENTER);

        //add(arrows, BorderLayout.CENTER);
        //add(mapView, BorderLayout.CENTER);



        //mapView.initPanel();

        setLocationRelativeTo(null);
        setVisible(true);

        drawMap();
    }

    public void addArrow(JLabel arrow){
        arrows.add(arrow);
    }

}

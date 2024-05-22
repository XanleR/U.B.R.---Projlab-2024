package game;

import game.characters.Character;
import game.characters.Cleaner;
import game.characters.Instructor;
import game.characters.Student;
import game.graphical.*;
import game.items.Item;
import game.rooms.Room;

import javax.swing.*;
import java.awt.*;
import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static game.GUI.gameFrame;

public class GameInitializer {

    //A palyak inicializalasa file-bol
    public static void initMaps(String from) throws IOException, ClassNotFoundException {
        /////////// GameController Init

        /////////// rooms

        // beolvasás
        FileInputStream mapStream = new FileInputStream(from + "_rooms.dat");
        //System.out.println("1 beolvasás ok");
        ObjectInputStream map = new ObjectInputStream(mapStream);
        //System.out.println("2 beolvasás ok");
        List<Room> rooms = (ArrayList<Room>) map.readObject();

        List<ElementView> roomViews = new ArrayList<>();
        //Szobák és itemeket valamint kinézeteik betöltése
        for (Room room : rooms) {
            room.setRoomView(room.getX(), room.getY());
            if(!room.getItems().isEmpty()) {
                for (Item item : room.getItems()) {
                    item.setView(item.getxCoord(), item.getyCoord());
                    roomViews.add(item.getItemView());
                }
            }
            roomViews.add(room.getView());

        }

        MapView mapView = new MapView(roomViews);

        GameFrame.getInstance().setMapView(mapView);

        //System.out.println("3 beolvasás ok");
        map.close();
        //System.out.println("4 beolvasás ok");

        //System.out.println("beolvasás ok");

        // feltöltés
        for (Room i : rooms) {
            GameController.getInstance().addRoom(i);
        }

        System.out.println("The load of the map was successful!");

    }

    //input: int count
    //method: Letrehoz, annyi Character-t, amennyi int erteke
    //return: void
    public static void initCharacters(int count) throws IOException, ClassNotFoundException{

        List<ElementView> elementViews = new ArrayList<>();

        //GameController.getInstance().setStudentCount(count);
        GameController.getInstance().setStudentCount(1);
        // tanulók
        for (int i = 0; i < 1 ; i++) {
            Student tmp = new Student(); tmp.setInventorySize(5);
            tmp.setUniqueName("Student" + i);
            GameController.getInstance().addCharacter(tmp);
            int tmpRoom;
            tmpRoom = 0;
            tmp.setCurrentRoom( GameController.getInstance().getRooms().get(tmpRoom) );
            GameController.getInstance().getRooms().get(tmpRoom).putCharacter(tmp);
            tmp.setView();
            elementViews.add(tmp.getView());

        }



        //tanárok
        for (int i = 0; i < 3; i++) {
        //for (int i = 0; i < 1; i++) {
                Instructor tmp = new Instructor();
                tmp.setUniqueName("Instructor" + i);
                GameController.getInstance().addCharacter(tmp);
                Random r = new Random();
                int tmpRoom;
                tmpRoom = r.nextInt(1, GameController.getInstance().getRooms().size());
                //tmpRoom = 8;
                tmp.setCurrentRoom( GameController.getInstance().getRooms().get(tmpRoom) );
                GameController.getInstance().getRooms().get(tmpRoom).putCharacter(tmp);

                tmp.setView();
                elementViews.add(tmp.getView());
        }



        //takarítók
        for (int i = 0; i < 1; i++) {
            Character tmp = new Cleaner();
            tmp.setUniqueName("Cleaner" + i);
            GameController.getInstance().addCharacter(tmp);
            Random r = new Random();
            int tmpRoom;
            tmpRoom = r.nextInt(2, GameController.getInstance().getRooms().size());
            tmp.setCurrentRoom( GameController.getInstance().getRooms().get(tmpRoom) );
            GameController.getInstance().getRooms().get(tmpRoom).putCharacter(tmp);

            tmp.setView();
            elementViews.add(tmp.getView());
        }

        gameFrame.getMapView().addViews(elementViews);


    }
}


package game;

import game.characters.Character;
import game.rooms.Room;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class GameInitializer {

    //A palyak inicializalasa file-bol
    public static void initMaps(String from) throws IOException, ClassNotFoundException {
        /////////// GameController Init

        /////////// rooms

        // beolvasás
        FileInputStream mapStream = new FileInputStream(from + "_rooms.dat");
        System.out.println("1 beolvasás ok");
        ObjectInputStream map = new ObjectInputStream(mapStream);
        System.out.println("2 beolvasás ok");
        List<Room> rooms = ( ArrayList<Room> ) map.readObject();
        System.out.println("3 beolvasás ok");
        map.close();
        System.out.println("4 beolvasás ok");

        System.out.println("beolvasás ok");

        // feltöltés
        for (Room i : rooms) {
            GameController.getInstance().addRoom(i);
        }

        //////////// players

        for (Room i : rooms) {
            for (Character j : i.getCharacters()) {
                GameController.getInstance().addCharacter(j);
            }
        }

    }

    //input: int count
    //method: Letrehoz, annyi Character-t, amennyi int erteke
    //return: void
    public static void initCharacters(int count) throws IOException, ClassNotFoundException{
        // TODO: Normálisan megcsinálni a Studentek hozzáadását, mert most a playersben van az összes npc és student is...
    }
}


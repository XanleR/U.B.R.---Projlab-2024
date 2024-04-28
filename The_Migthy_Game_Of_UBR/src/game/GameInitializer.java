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
        ObjectInputStream map = new ObjectInputStream(mapStream);
        List<Room> rooms = (ArrayList<Room>) map.readObject();
        map.close();

        // feltöltés
        for (Room i : rooms) {
            GameController.getInstance().addRoom(i);
        }

        //////////// players

        // beolvasás
        FileInputStream playersStream = new FileInputStream(from + "_players.dat");
        ObjectInputStream players = new ObjectInputStream(playersStream);
        List<Character> characters = (ArrayList<Character>) players.readObject();
        map.close();

        // feltöltés
        for (Character i : characters) {
            GameController.getInstance().addCharacter(i);
        }

    }

    //input: int count
    //method: Letrehoz, annyi Character-t, amennyi int erteke
    //return: void
    public static void initCharacters(int count) throws IOException, ClassNotFoundException{
        // TODO: Normálisan megcsinálni a Studentek hozzáadását, mert most a playersben van az összes npc és student is...
    }
}


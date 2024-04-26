package game;

import game.rooms.Room;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class GameInitializer {

    //A palyak inicializalasa file-bol
    public void initMaps(String from) throws IOException, ClassNotFoundException {
        // beolvasás
        FileInputStream mapStream = new FileInputStream(from);
        ObjectInputStream map = new ObjectInputStream(mapStream);
        List<Room> rooms = (ArrayList<Room>) map.readObject();
        map.close();

        // feltöltés
        for (Room i : rooms) {
            GameController.getInstance().addRoom(i);
        }
    }

    //input: int count
    //method: Letrehoz, annyi Character-t, amennyi int erteke
    //return: void
    public void initCharacters(int count) throws IOException, ClassNotFoundException{
        // TODO: Normálisan megcsinálni a Studentek hozzáadását, mert most a playersben van az összes npc és student is...
    }
}


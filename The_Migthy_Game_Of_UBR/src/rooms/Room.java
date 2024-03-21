package rooms;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    private Transistor transistor;
    private int maxCharacter;

    public abstract void onEntered(Character c1);
    public void addCharacter(Character c1) {}
    //TODO
    public boolean isAccessible(Room r1) {return false;}
    public List<Character> getCharacters() {return new ArrayList<>();}
    public void removeCharacter(Character c1) {}
    public void removeItem(Item i1) {}
    public void addItem(Item i1) {}
    public void addItems(List<Item> l1) {}
    public List<Item> getItems() { return new ArrayList<>();}
    public List<Room> getNeighbours() {return new ArrayList<>();}
    public void addNeighbours(List<Room> l1) {}
    public void removeNeighbours(List<Room> l1) {}
}
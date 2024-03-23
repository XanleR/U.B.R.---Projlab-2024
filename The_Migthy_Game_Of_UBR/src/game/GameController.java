package game;

import game.rooms.Room;

import java.util.ArrayList;
import java.util.List;
import game.characters.Character;

public class GameController {


    //Megadja, hogy hany kor van meg hatra
    private int remainingRounds;

    //Megadja, hogy hany felhasznalo jatszhat a programmal
    private int studentCount;

    //Eltarolja a jatekban resztvevo Charactereket
    private List<Character> listOfCharacters;

    //Eltarolja a jatekban letezo szobakat
    private List<Room> rooms;

    public GameController(){
        listOfCharacters = new ArrayList<>();
        rooms = new ArrayList<>();
        studentCount = 0;
    }

    //input: List<Character> characetrs, List<Room> rooms
    //method: Letrehoz egy jatekot a megadott szobakkal es tanulokkal
    //return: -
    public GameController(List<Character> characters, List<Room> rooms){
        listOfCharacters = characters;
        this.rooms = rooms;
        studentCount = listOfCharacters.size();
    }

    //input: -
    //method: Kezeli azt az esemenyt, amikor egy Student felveszi a SlideRule targyat
    //return: void
    public void slideRulePickedUp(){}

    //input: Room slipt
    //method: A kapott szobat 2 masik szobara osztja
    //return: void
    public void slpitRoom(Room split){}

    //input: Room m1, Room m2
    //method: A kapott 2 szobabol 1 uj szobat hoz letre
    //return: void
    public void mergeRooms(Room m1, Room m2){}

    //input: Room newR
    //method: A kapott Room-ot felveszi a jatek szobai koze
    //return: void
    public void addRoom(Room newR){}

    //input: Room remove
    //method: A kapott szobat kitorli a jatek szobai kozul
    //return: void
    public void removeRoom(Room remove){}

    //input: -
    //method: Elindit egy uj kort
    //return: void
    public void newRound(){}

    //input: -
    //method: Kezeli azt az esemnyt, amikor a jateknak vege van
    //return: void
    public void endGame(){}

    //input: Character remove
    //method: A kapott Character-t kitorli a jatekban levo Characterek kozul
    //return: void
    public void removeCharacter(Character remove){}

    //input: -
    //method: Elinditja a jatekmenetet
    //return: void
    public void play(){}

    //input: -
    //method: Egy veletlenszeru egesz szamot general az 1-től 6-ig terjedo zart intervallumon.
    //return: int
    public int rollDice(){ return 0;}
}

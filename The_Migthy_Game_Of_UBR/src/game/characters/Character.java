package game.characters;

import game.graphical.CharacterView;
import game.graphical.ElementView;
import game.graphical.CharacterView;
import game.items.Item;
import game.rooms.RegularRoom;
import game.rooms.Room;

import java.io.Serializable;

//Git test

// A karaktereket megvalosito abstarct ososztaly.
// A Student es az Instructor ebbol szarmazik le.
public abstract class Character implements Serializable {

    //Megadja, hogy hany action-je van hatra a peldanynak
    protected int remainingactions;


    public int getxCoord() {
        return currentRoom.getX();
    }

    public int getyCoord() {
        return currentRoom.getY();
    }


    protected transient CharacterView characterView;

    public ElementView getView(){
        return characterView;
    }

    //Megajda azt a szobat, ahol a peldany jelenleg all
    protected Room currentRoom;

    public int getStunnedRounds() {
        return stunnedRounds;
    }

    //Megadja, hogy hany korbol marad ki a peldany
    protected int stunnedRounds;

    protected String uniqueName;

    public int getRemainingactions(){
        return remainingactions;
    }

    public void setUniqueName(String name){
        uniqueName = name;
    }

    public String getUniqueName(){
        return uniqueName;
    }

    //Getter: Visszaadja a szobat, amelyben a karakter all
    public Room getRoom(){
        return this.currentRoom;
    }

    public void setCurrentRoom(Room newRoom){
        currentRoom = newRoom;
    }


    //Setter: A parameterkent kapott int-re beallitja a stunnedRounds
    public abstract void stun(int stun);

    //input: Room from, Room to
    //method: A karaktert athelyezi az egyik bemenetkent adott szobabol a masikba
    //return: void
    public abstract void move(Room from, Room to);

    //input: Item newI
    //method: A parameterkent megadott Item-et Student eseten berkaja a Student List<item>-ebe, Instructor eseten kitorli
    //        az Item-et a jatekbol
    //return: void
    public abstract void pickUpItem(Item newI);

    //input: -
    //method: vegrehajtja a felhasznalo altal kivalasztott action-t
    //return: void
    public abstract void action();

    //input: Character character
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy másik Character-el kerul egy mezore
    //return: void
    public abstract void meet(Character character);

    //input: Student student
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Student-el kerul egy mezore
    //return: void
    public abstract void meetStudent(Student student);

    //input: Instructor instructor
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Instructor-el kerul egy mezore
    //return: void
    public abstract void meetInstructor(Instructor instructor);

    //input: Cleaner cleaner
    //method: Végrehajtja azt az eseményt, amikor a példány egy Cleaner-el kerül egy mezőre
    //return: void
    public abstract void meetCleaner(Cleaner cleaner);

    //input: -
    //method: Elindítja a játékos körét, és meghívja a paraméterként kapott számmal az ‘action’ függvényt
    //return: void
    public abstract void startRound(int in);

    //input: -
    //method: A karaktert átmozgatja erőszakosan egy szomszédos szobába
    //return: void
    public abstract void forceMove();


    public abstract void setView(int x, int y);
}



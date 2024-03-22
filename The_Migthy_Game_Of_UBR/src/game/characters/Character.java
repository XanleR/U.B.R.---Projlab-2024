package game.characters;

import game.items.Item;
import game.rooms.RegularRoom;
import game.rooms.Room;

//Git test

// A karaktereket megvalosito abstarct ososztaly.
// A Student es az Instructor ebbol szarmazik le.
public abstract class Character {

    //Megadja, hogy hany action-je van hatra a peldanynak
    private int remainingactions;

    //Megajda azt a szobat, ahol a peldany jelenleg all
    protected Room currentRoom = new RegularRoom();

    //Megadja, hogy hany korbol marad ki a peldany
    private int stunnedRounds;

    //Getter: Visszaadja a szobat, amelyben a karakter all
    public Room getRoom(){
        return this.currentRoom;
    }

    //Setter: A parameterkent kapott int-re beallitja a stunnedRounds
    public void stun(int stun){
        this.stunnedRounds = stun;
    }

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

    //input: -
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Student-el kerul egy mezore
    //return: void
    public abstract void meetStudent();

    //input: -
    //method: Vegrehajtja azt az esemenyt, amikor a pedany egy Instructor-el kerul egy mezore
    //return: void
    public abstract void meetInstructor();

    //input: -
    //method: Elindítja a játékos körét, és meghívja a paraméterként kapott számmal az ‘action’ függvényt
    //return: void
    public abstract void startRound(int in);
}



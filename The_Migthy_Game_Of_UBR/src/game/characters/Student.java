package game.characters;

import game.items.Item;
import game.items.TVSZ;
import game.items.Transistor;
import game.rooms.Room;

import java.util.List;

public class Student extends Character{

    //Megadja, hogy a peldany vedelem alatt all-e
    private boolean isProtected;

    //Megadja, hogy hany kor van meg hatra az FFP2 targy felhasznalasabol
    private int maskedRounds;

    //Eltarolja a Student altal felvett targyakat;
    private List<Item> inventory;

    //Eltarolja a Student-nel levo Transistorokat
    private List<Transistor> transistorList;

    //TODO comment here
    private Transistor transistor;

    //Megadja, hogy a Student, hany Item-et vehet-fel
    private int inventorySize;

    //input: Room from, Room to
    //method: A karaktert athelyezi az egyik bemenetkent adott szobabol a masikba
    //return: void
    @Override
    public void move(Room from, Room to){}

    //input: Item newI
    //method: A parameterkent megadott Item-et Student eseten berkaja a Student List<item>-ebe, Instructor eseten kitorli
    //        az Item-et a jatekbol
    //return: void
    @Override
    public void pickUpItem(Item newI){}

    //input: -
    //method: vegrehajtja a felhasznalo altal kivalasztott action-t
    //return: void
    @Override
    public void action() {}

    //input: -
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Student-el kerul egy mezore
    //return: void
    @Override
    public void meetStudent() {}

    //input: -
    //method: Vegrehajtja azt az esemenyt, amikor a pedany egy Instructor-el kerul egy mezore
    //return: void
    @Override
    public void meetInstructor() {}

    //input: -
    //method: Elindítja a játékos körét, és meghívja a paraméterként kapott számmal az ‘action’ függvényt
    //return: void
    @Override
    public void startRound(int in) {}

    //input: Item dropped
    //method: Kitorli a targyat a Student inventory-jabol es hozzaadja a szoba targyakat tarolo attributumahoz
    //return: void
    public void dropItem(Item dropped){}

    //input: Item used
    //method: Egy tárgy alkalmazását megvalósító metódus
    //return: void
    public void useItem(Item used){}

    //input: -
    //method: Egy véletlenszerű egész számot generál az 1-től 6-ig terjedő zárt intervallumon.
    //return: int
    public int rollDice(){ return 0;}

    //input: -
    //method: A tranzisztorral való utazást megvalósító függvén
    //return: void
    public void transistorJump(){}

    //intput: Transistor newT
    //method: A tranzisztorok listájába beleteszi a paraméterként kapott tranzisztort
    //return: void
    public void addTransistor(Transistor newT){}

    //input: int index
    //method:  Visszaadja a tranzisztorok listájából az indexedik tranzisztort
    //return: Transistor
    public Transistor getTransistor(int index){
        return null;
    }

    //input: int plus
    //method: TODO here, method
    //return: void
    public void addRounds(int plus){}

    //input: int plusMask
    //method: Hozzaadja a bemenetkent kapott int-et a maskedRounds attributumhoz
    //return: void
    public void addMaskedRounds(int plusMask){
        maskedRounds += plusMask;
    }

    //TODO here method comments
    public TVSZ getTVSZ(){ return null;}

    //TODO here method comments
    public void setTVSZ(){}

    //input: Item removed
    //method: TODO here
    //return: void
    public void removeItem(Item removed){}
}

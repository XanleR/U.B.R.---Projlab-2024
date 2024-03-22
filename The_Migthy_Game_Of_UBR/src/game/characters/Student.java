package game.characters;

import game.items.Item;
import game.items.TVSZ;
import game.items.Transistor;
import game.rooms.RegularRoom;
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

    //Megadja, hogy a Student, hany Item-et vehet-fel
    private int inventorySize;

    //A hallgatonal csak 1 db tvsz lehet, ez a valtozo eppen ezt tarolja el
    private TVSZ tvsz;

    //input: Room from, Room to
    //method: A karaktert athelyezi az egyik bemenetkent adott szobabol a masikba
    //return: void
    @Override
    public void move(Room from, Room to){
        System.out.println("\t--> (testR2: Room).addCharacter(testS1: Student)");
        to.addCharacter(this);
    }

    //input: Item newI
    //method: A parameterkent megadott Item-et Student eseten berkaja a Student List<item>-ebe, Instructor eseten kitorli
    //        az Item-et a jatekbol
    //return: void
    @Override
    public void pickUpItem(Item newI){
        System.out.println("\t--> (this.currentRoom: Room).removeItem(newI: Item)");
        this.currentRoom.removeItem(newI);
        System.out.println("\t<--");

        System.out.println("\t--> (newI: Item).onPickedUp()");
        newI.onPickedUp();
        System.out.println("\t<--");
    }

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
    public void dropItem(Item dropped){
        System.out.println("\t -->(currentRoom: Room).addItem(dropped)");
        this.currentRoom = new RegularRoom();
        this.currentRoom.addItem(dropped);
        System.out.println("\t <--");
    }

    //input: Item used
    //method: Egy targy alkalmazasat megvalosito metodus
    //return: void
    public void useItem(Item used){
        System.out.println("\t --> (used: Item).use(this: Student)");
        used.use(this);
        System.out.println("\t <--");
    }

    //input: -
    //method: Egy veletlenszeru egesz szamot generál az 1-től 6-ig terjedo zart intervallumon.
    //return: int
    public int rollDice(){ return 0;}

    //input: -
    //method: A tranzisztorral valo utazast megvalosíto fuggveny
    //return: void
    //TODO ez honnan tudja hogy hova ugrik stb, igy kb hasznalhatatlan ez a fgv.
    public void transistorJump(){}

    //intput: Transistor newT
    //method: A tranzisztorok listájába beleteszi a paraméterként kapott tranzisztort
    //return: void
    public void addTransistor(Transistor newT){}

    //input: int index
    //method:  Visszaadja a tranzisztorok listajabol az indexedik tranzisztort
    //return: Transistor
    public Transistor getTransistor(int index){
        return null;
    }

    //input: int plus
    //method: A hallgato koreihez ad meg a parameterben kapott erteknyit
    //return: void
    public void addRounds(int plus){}

    //input: int plusMask
    //method: Hozzaadja a bemenetkent kapott int-et a maskedRounds attributumhoz
    //return: void
    public void addMaskedRounds(int plusMask){
        maskedRounds += plusMask;
    }

    //input_ TVSZ _tvsz
    //method: Beallitja a hallgatonal levo TVSZ-t a parameterkent megadottra
    //return: void
    public void setTVSZ(TVSZ _tvsz){}

    //input: Item removed
    //method: Kiveszi a parameterkent kapott targyat a hallgato inventory-jából
    //return: void
    public void removeItem(Item removed){}
}

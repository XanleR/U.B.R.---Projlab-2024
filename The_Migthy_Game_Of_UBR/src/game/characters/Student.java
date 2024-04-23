package game.characters;

import game.GameController;
import game.items.*;
import game.rooms.RegularRoom;
import game.rooms.Room;

import java.awt.font.TransformAttribute;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Student extends Character {

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
        to.addCharacter(this);
    }

    //input: Item newI
    //method: A parameterkent megadott Item-et Student eseten berkaja a Student List<item>-ebe, Instructor eseten kitorli
    //        az Item-et a jatekbol
    //return: void
    @Override
    public void pickUpItem(Item newI){
        
    }

    //input: -
    //method: vegrehajtja a felhasznalo altal kivalasztott action-t
    //return: void
    @Override
    public void action() {}

    public void idle(){
        System.out.println("--> (testS1: Student).idle()");
        System.out.println("<--");
    }

    //input: Character character
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy másik Character-el kerul egy mezore
    //return: void
    @Override
    public void meet(Character character){
        System.out.println("--> (testS1: Student).meet(testI1: Character)");
        character.meetStudent(this);

        System.out.println("<--");
    }

    //input: Student student
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Student-el kerul egy mezore
    //return: void
    @Override
    public void meetStudent(Student student) {
        System.out.println("\t\t\t--> (s1: Student).meetStudent(testS1: Student)");

        System.out.println("\t\t\t<--");
    }

    //input: Instructor instuctor
    //method: Vegrehajtja azt az esemenyt, amikor a pedany egy Instructor-el kerul egy mezore
    //return: void
    @Override
    public void meetInstructor(Instructor instructor) {
        System.out.println("\t--> (testS1: Student).meetInstructor(testI1: Instructor)");

        this.die(instructor);

        System.out.println("\t<--");
    }

    //input: -
    //method: Elindítja a játékos körét, és meghívja a paraméterként kapott számmal az ‘action’ függvényt
    //return: void
    @Override
    public void startRound(int in) {}

    //input: Item dropped
    //method: Kitorli a targyat a Student inventory-jabol es hozzaadja a szoba targyakat tarolo attributumahoz
    //return: void
    public void dropItem(Item dropped){
        System.out.println("\t -->(currentRoom: Room).addItem(dropped: item)");
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
    public void transistorJump(){
        System.out.println("-->(testS1: Student).transistorJump()");
        Room r1 = new RegularRoom();
        r1.geTransistor();

        Transistor t1 = new Transistor();
        t1.getPairsRoom();

        r1.removeCharacter(this);

        Room r2 = new RegularRoom();
        System.out.println("\t--> (testR2: Room).addCharacter(testS1: Student)");
        r2.addCharacter(this);

        System.out.println("<--");
    }

    //input: Transistor newT
    //method: A tranzisztorok listájába beleteszi a paraméterként kapott tranzisztort
    //return: void
    public void addTransistor(Transistor newT){
        System.out.println("\t\t\t--> (testS1: Student).addTransistor(testT1: Transistor)");

        System.out.println("\t\t\t<--");
    }

    //input: -
    //method: A hallgatonal levo legutolso 2-nek felvett tranzisztort parositja
    //return: void
    public void pairLastTwoTransistor(){
        System.out.println("\t\t\t--> (testS1: Student).pairLastTwoTransistor()");
        Transistor t1 = new Transistor();
        Transistor t2 = new Transistor();

        this.getTransistor(0);
        this.getTransistor(0);

        t1.pairing(t2);
        t2.pairing(t1);


        System.out.println("\t\t\t<--");
    }

    //input: int index
    //method:  Visszaadja a tranzisztorok listajabol az indexedik tranzisztort
    //return: Transistor
    public Transistor getTransistor(int index){
        System.out.println("\t\t\t\t--> (testS1: Student).getTransistor(index: int)");

        System.out.println("\t\t\t\t<-- transistor: Transistor");
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

    //input: TVSZ _tvsz
    //method: Beallitja a hallgatonal levo TVSZ-t a parameterkent megadottra
    //return: void
    public void setTVSZ(TVSZ _tvsz){
        System.out.println("\t\t\t--> (testS1: Student).setTVSZ(testTVSZ: TVSZ)");

        System.out.println("\t\t\t<--");
    }

    //input: -
    //method: visszaadja a hallgatonal levo tvsz-t
    //return: TVSZ
    public TVSZ getTVSZ(){
        System.out.println("\t\t--> (testS1: Student).getTVSZ()");

        System.out.println("\t\t<-- t1: TVSZ");
        return null;
    }

    //input: Item removed
    //method: Kiveszi a parameterkent kapott targyat a hallgato inventory-jából
    //return: void
    public void removeItem(Item removed){
        System.out.println("\t\t\t\t--> (testS1: Stuednt).removeItem(removed: Item)");

        System.out.println("\t\t\t\t<--");
    }

    //input: Instructor instructor
    //method: A hallgatot megtamadtak, amennyiben a nincs vedelme, a hallgato meghal
    //return void
    public void die(Instructor instructor){
        System.out.println("\t\t--> (testS1: Student).die(testI1: Instructor)");
        TVSZ tvsz1 = new TVSZ();
        GlassOfBeer glassOfBeer = new GlassOfBeer();
        WetRag wetRag = new WetRag();

        tvsz1.onAttacked(this, instructor);
        glassOfBeer.onAttacked(this, instructor);
        wetRag.onAttacked(this, instructor);

        System.out.println("\t\t-?- Sikerult-e megvedeni a hallgatot? (y/n): ");
        Scanner dieScanner = new Scanner(System.in);
        String dieAnswer = dieScanner.next();
        if(dieAnswer.equals("n")){
            GameController gameController = new GameController();
            gameController.removeCharacter(this);
        }



        System.out.println("\t\t<--");
    }

    public void stun(int stun){

    }
}

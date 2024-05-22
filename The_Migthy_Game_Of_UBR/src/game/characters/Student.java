package game.characters;

import game.GameController;
import game.graphical.GameFrame;
import game.graphical.StudentView;
import game.items.*;
import game.rooms.Room;

import javax.swing.*;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static game.GUI.gameController;
import static game.GUI.gameFrame;

public class Student extends Character implements Serializable {

    public int getMaskedRounds() {
        return maskedRounds;
    }

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

    private boolean alive = true;

    public List<Item> getInventory(){
        return inventory;
    }

    public boolean isAlive() {
        return alive;
    }

    //input: -
    //method: Konstruktora a Student classnak, mely inicializálja a listákat
    //return: -
    public Student(){
        inventory = new ArrayList<>();
        transistorList = new ArrayList<>();
    }


    //input: int iSize
    //method: beállítja a karakter inventoryának méretét
    //return: void
    public void setInventorySize(int iSize){
        inventorySize = iSize;
    }

    //input: Room from, Room to
    //method: A karaktert athelyezi az egyik bemenetkent adott szobabol a masikba
    //return: void
    @Override
    public void move(Room from, Room to){
        if(stunnedRounds <= 0){
            to.addCharacter(this);
            remainingactions--;
            gameFrame.drawMap(this);

            if(remainingactions == 0){
                gameController.stepCharacter();
            }
        }
        else{
            System.out.println("The Student could not move to the "+to.getUniqueName()+"...");
        }


    }

    //Hozzaad egy Item-et az inventory-hoz
    public void addItem(Item newItem){
        this.inventory.add(newItem);
    }

    //input: Item newI
    //method: A parameterkent megadott Item-et Student eseten berkaja a Student List<item>-ebe, Instructor eseten kitorli
    //        az Item-et a jatekbol
    //return: void
    @Override
    public void pickUpItem(Item newI){
        this.currentRoom.pickUp(newI, this);
    }

    public void removeTransistor(Transistor in){
        this.transistorList.remove(in);
    }

    //input: -
    //method: vegrehajtja a felhasznalo altal kivalasztott action-t
    //return: void
    @Override
    public void action(String command) {
        if(stunnedRounds != 0){
            GameController.getInstance().stepCharacter();
        }

        //GameFrame.getInstance().drawMap(this);

        String[] slicedCommand = command.split(" ");


        //a command első szavának vizsgálata
        switch (slicedCommand[0]){
            case "StudentMove":
                if(slicedCommand.length == 3){
                    switch (slicedCommand[1]){
                        case "simpleMove":
                            for(Room room : currentRoom.getNeighbours()){
                                if(room.getUniqueName().equals(slicedCommand[2])){
                                    move(this.currentRoom, room);
                                    break;
                                }
                            }
                            break;
                        case "transistorJump":
                            if(
                                    this.currentRoom.geTransistor() != null
                                    && this.currentRoom.geTransistor().getPairsRoom() != null
                                    //&& this.currentRoom.geTransistor().getPairsRoom().getUniqueName().equals(slicedCommand[2])
                            ){
                                this.transistorJump();
                                idle();
                            }
                            break;
                    }
                }

                break;
            case "dropItem":
                if(slicedCommand.length == 2){
                    for(Item item : this.inventory){
                        if(item.getUniqueName().equals(slicedCommand[1])){
                            dropItem(item);
                            break;
                        }
                    }
                }
                break;
            case "useItem":
                if(slicedCommand.length == 2){
                    for(Item item : this.inventory){
                        if(item.getUniqueName().equals(slicedCommand[1])){
                            this.useItem(item);
                            break;
                        }
                    }
                }
                break;
            case "pickUpItem":
                if(slicedCommand.length == 2){
                    for(Item item : this.currentRoom.getItems()){
                        if(item.getUniqueName().equals(slicedCommand[1])){
                            pickUpItem(item);
                            idle();
                            break;
                        }
                    }
                }
                break;
            case "turnOnTransistor":
                if(currentRoom.geTransistor() != null){
                    currentRoom.geTransistor().powerOn();
                    idle();
                }
                break;
            case "idle":
                idle();
                break;
            default:
                break;
        }

        if(stunnedRounds != 0 || !alive){
            GameController.getInstance().stepCharacter();

        }

    }

    //input: -
    //method: A hallgató tétlen akciója
    //return: void
    public void idle(){
        remainingactions--;
        gameFrame.drawMap(this);

        if(remainingactions == 0){
            gameController.stepCharacter();
        }
    }

    //Megadja, hogy tele van-e az ineventory
    public boolean canPickUp(){
        if(this.inventorySize <= this.inventory.size()){
            return false;
        }
        return true;
    }

    //input: Character character
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy másik Character-el kerul egy mezore
    //return: void
    @Override
    public void meet(Character character){
        //A karakter találkozik a hallgatóval
        character.meetStudent(this);
    }

    //input: Student student
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Student-el kerul egy mezore
    //return: void
    @Override
    public void meetStudent(Student student) {
    }

    //input: Instructor instuctor
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Instructor-el kerul egy mezore
    //return: void
    @Override
    public void meetInstructor(Instructor instructor) {
        this.die(instructor);
    }

    //input: Cleaner cleaner
    //method: Végrehajtja azt az eseményt, amikor a példány egy Cleaner-el kerül egy mezőre
    //return: void
    @Override
    public void meetCleaner(Cleaner cleaner) {
        this.forceMove();
    }


    //input: -
    //method: Elindítja a játékos körét, és meghívja a paraméterként kapott számmal az ‘action’ függvényt
    //return: void
    @Override
    public void startRound(int in) {

        if(maskedRounds > 0){
            maskedRounds--;
        }
        if(stunnedRounds != 0){
            stunnedRounds--;
            GameController.getInstance().stepCharacter();
        }
        else{
            remainingactions = in;
            gameFrame.drawMap(this);

//            while (remainingactions > 0 && stunnedRounds == 0 && alive){
//                System.out.println("---------");
//                System.out.println("The "+uniqueName+" has " + remainingactions + " action");
//
//                action();
//                remainingactions--;
//
//                //endgamecheck
//                if (!GameController.getInstance().isActive()) {
//                    return;
//                }
//            }
        }
        //remainingactions = 0;
    }

    //input: -
    //method: Az adott hallgató mozgásra kényszerült, ez a függvény átteszi őt egy szomszédos szobába
    //return: void
    @Override
    public void forceMove() {
        if(stunnedRounds == 0){
            for(Room room: currentRoom.getNeighbours()) {
                if (room.isAccessible(currentRoom)) {
                    room.addCharacter(this);
                    System.out.println("The character was forced to move to another room...");
                    break;
                }
            }
        }

    }

    @Override
    public void setView() {
        ImageIcon icon = new ImageIcon("Assets/Student.png");
        this.characterView = new StudentView(icon, this);
    }

    //input: Item dropped
    //method: Kitorli a targyat a Student inventory-jabol es hozzaadja a szoba targyakat tarolo attributumahoz
    //return: void
    public void dropItem(Item dropped){
        if(this.currentRoom.addItem(dropped)){
            removeItem(dropped);
            dropped.setXY(currentRoom.getX()+2, currentRoom.getY()+2);
            dropped.setView(currentRoom.getX()+2, currentRoom.getY()+2);
            gameFrame.getMapView().addViews(dropped.getItemView());
            idle();
            gameFrame.drawMap(this);
            System.out.println("The "+dropped.getUniqueName()+" drop was successful!");
        }

    }

    //input: Item used
    //method: Egy targy alkalmazasat megvalosito metodus
    //return: void
    public void useItem(Item used){
        used.use(this);
        idle();
        gameFrame.drawMap(this);
        System.out.println("The "+used.getUniqueName()+" was used!");
    }

    //input: -
    //method: Egy veletlenszeru egesz szamot generál az 1-től 6-ig terjedo zart intervallumon.
    //return: int
    public int rollDice(){
        Random random = new Random();
        return random.nextInt(6) + 1; //Azért +1, mert ez 0 és 5 között sorsol értéket
    }

    //input: -
    //method: A tranzisztorral valo utazast megvalosíto fuggveny
    //return: void
    public void transistorJump(){

        // Check, hogy van-e mindkét szobában tranzisztor
        if(currentRoom.geTransistor() != null && currentRoom.geTransistor().getPairsRoom() != null){
            Room to = currentRoom.geTransistor().getPairsRoom();
            to.addCharacter(this);
        }
        else{
            System.out.println("Invalid movement...");
        }
    }

    //input: Transistor newT
    //method: A tranzisztorok listájába beleteszi a paraméterként kapott tranzisztort
    //return: void
    public void addTransistor(Transistor newT){
        transistorList.add(newT);
        //Ha páros tranzisztor lett nálunk, akkor az utolsó kettőt párosítjuk
        if(transistorList.size() % 2 == 0){
            pairLastTwoTransistor();
        }
    }

    //input: -
    //method: A hallgatonal levo legutolso 2-nek felvett tranzisztort parositja
    //return: void
    public void pairLastTwoTransistor(){
        Transistor t1 = getTransistor(transistorList.size()-1);
        Transistor t2 = getTransistor(transistorList.size()-2);

        t1.pairing(t2);
        t2.pairing(t1);
    }

    //input: int index
    //method:  Visszaadja a tranzisztorok listajabol az indexedik tranzisztort
    //return: Transistor
    public Transistor getTransistor(int index){
        return transistorList.get(index);
    }

    //input: int plus
    //method: A hallgato koreihez ad meg a parameterben kapott erteknyit
    //return: void
    public void addRounds(int plus){
        remainingactions += plus;
    }

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
        if(tvsz == null){
            System.out.println("The "+uniqueName+"'s TVSZ was set!");
            this.tvsz = _tvsz;
            return;
        }
        System.out.println("The "+uniqueName+"'s TVSZ was updated!");
        tvsz.addProtection(_tvsz.getRemainingProtection());
    }

    //input: -
    //method: visszaadja a hallgatonal levo tvsz-t
    //return: TVSZ
    public TVSZ getTVSZ(){
        return tvsz;
    }

    //input: -
    //method: eltávolítja a hallgató tvsz-ét
    //return: -
    public void removeTVSZ(){
        tvsz = null;
    }

    //input: Item removed
    //method: Kiveszi a parameterkent kapott targyat a hallgato inventory-jából
    //return: void
    public void removeItem(Item removed){
        inventory.remove(removed);
    }

    //input: Instructor instructor
    //method: A hallgatot megtamadtak, amennyiben a nincs vedelme, a hallgato meghal
    //return void
    public void die(Instructor instructor){
        boolean studentSaved = false;
        alive = false;

        if(this.tvsz != null && this.tvsz.onAttacked(this, instructor)){
            studentSaved = true;
        }
        else{
            for(Item item : inventory){
                if(item.onAttacked(this, instructor)){
                    studentSaved = true;
                    break;
                }
            }
        }


        if(!studentSaved){
            GameController.getInstance().removeCharacter(this);
            alive = false;
            System.out.println("The "+uniqueName+" died...");
        }
    }

    //input: int stunnedFor
    //method: A hallgatót elkábítja a paraméterként kapott kör idejére
    //return: void
    public void stun(int stunnedFor){
        if(maskedRounds > 0){
            System.out.println("The "+uniqueName+" was protected by the FFP2 mask!");
            return;
        }
        stunnedRounds += stunnedFor;
        for(Item item : inventory){
            dropItem(item);
        }
        System.out.println("The "+uniqueName+" is stunned!");
    }

    //input: -
    //method: A hallgató eldob egy véletlenszerűen választott tárgyat a szobába
    //return: void
    public void dropRandomItem(){
        Random random = new Random();
        int index = random.nextInt(inventory.size());
        dropItem(inventory.get(index));
    }
}

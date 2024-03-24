package game.items;

import game.rooms.RegularRoom;
import game.rooms.Room;
import game.characters.Instructor;
import game.characters.Student;

public class Transistor extends Item{

    //Megadja, hogy a Transistor be van-e kapcsolva
    private boolean isOn;

    //Megajda, hogy a Transistor ossze van-e kapcsolva egy masik Transistorral
    private boolean isPaired;

    //Eltarolja azt a Transistort, amellyel oarban vannak
    private Transistor pair;

    //input: Transistor fPair
    //method: A kapott Transistort eltarolja a sajat parjakent,
    //        es sajat magat eltarolja a kapott Transistor parjkakent
    //return: void
    public void pairing(Transistor fPair){}

    //input: -
    //method: Visszaadja azt a Room-ot, ahol a parja van
    //return: Room
    public Room getPairsRoom(){
        System.out.println("\t-->(t1: Transistor).getPairsRoom()");

        System.out.printf("\t<-- r2: Room");
        return null;
    }

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){
        System.out.println("\t\t -->(user: Student).getRoom()");
        Room userRoom = user.getRoom();
        userRoom = new RegularRoom();
        System.out.println("\t\t <--userRoom: Room");
        System.out.println("\t\t -->(userRoom: Room).addTransistor(this)");
        userRoom.addTransistor(this);
        System.out.println("\t\t <--");
    }

    //input: -
    //Megadja, hogy az Intructor felveheti-e a targyat
    //return: boolean
    @Override
    public boolean canInstructorPickUp(){ return false; }

    //input: -
    //method: Azt az esemenyt kezeli, amikor egy tanulo felveszi a targyat
    //return: void
    @Override
    public void onPickedUp(){}

    //input: -
    //method: Elvegzi a kor elejen szukseges modositasokat a palyan
    //return: void
    @Override
    public void onRoundStart(){}

    //input: Student attacked, Instructor attacker
    //method: Azt az esemenyt kezeli, amikor egy hallgato talalkozik egy oktatoval, tehat egy mezore kerulnek
    //return: boolean
    @Override
    public boolean onAttacked(Student attacked, Instructor attacker){ return false; }
}

package game.items;

import game.rooms.RegularRoom;
import game.rooms.Room;
import game.characters.Instructor;
import game.characters.Student;

import java.io.Serializable;
import java.util.Scanner;

public class Transistor extends Item  implements Serializable {

    //Megadja, hogy a Transistor be van-e kapcsolva
    private boolean isOn = false;

    //Megajda, hogy a Transistor ossze van-e kapcsolva egy masik Transistorral
    private boolean isPaired = false;

    //Eltarolja azt a Transistort, amellyel oarban vannak
    private Transistor pair;

    private Room currentRoom;

    //input: Transistor fPair
    //method: A kapott Transistort eltarolja a sajat parjakent,
    //        es sajat magat eltarolja a kapott Transistor parjkakent
    //return: void
    public void pairing(Transistor fPair){
        this.pair = fPair;
        this.isPaired = true;
        this.pair.isPaired = true;
    }

    public boolean getIsOn(){
        return isOn;
    }

    public void powerOn(){
        if(this.isPaired) {
            this.isOn = true;
            this.pair.isOn = true;
        }
    }

    public void powerOf(){
        if(this.isPaired){
            this.isOn =false;
            this.pair.isOn = false;
        }
    }

    //input: -
    //method: Visszaadja azt a Room-ot, ahol a parja van
    //return: Room
    public Room getPairsRoom(){
        return this.pair.getRoom();
    }

    public Room getRoom(){
        return this.currentRoom;
    }

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){
       if(this.isPaired) {
           user.removeItem(this);
           user.removeTransistor(this);
           user.getRoom().addTransistor(this);
           this.currentRoom = user.getRoom();
           System.out.println("The student placed the transistor in the room!");
       }
    }

    //input: -
    //Megadja, hogy az Intructor felveheti-e a targyat
    //return: boolean
    @Override
    public boolean canInstructorPickUp(){ return true; }

    //input: Student student
    //method: Azt az esemenyt kezeli, amikor egy tanulo felveszi a targyat
    //return: void
    @Override
    public void onPickedUp(Student student){
        student.addTransistor(this);
        student.addItem(this);
    }

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

    public void setCurrentRoom(Room cRoom){
        this.currentRoom = cRoom;
    }
}

package game.items;

import game.GameController;
import game.characters.Instructor;
import game.characters.Student;
import game.graphical.ItemView;
import game.rooms.GasRoom;
import game.rooms.Room;

import javax.swing.*;
import java.io.Serializable;


public class Camambert extends Item implements Serializable {

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){
        Room newGasRoom = new GasRoom();
        user.getRoom().copyToRoom(newGasRoom);
        GameController.getInstance().removeRoom(user.getRoom());
        GameController.getInstance().addRoom(newGasRoom);
        System.out.println("The room became a gas room!");
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
        student.addItem(this);
    }

    @Override
    public void setView(int x, int y) {
        ImageIcon icon = new ImageIcon("Assets/Camambert.png");
        this.itemView = new ItemView(icon, x, y);
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
    public boolean onAttacked(Student attacked, Instructor attacker){ return false;}
}

package game.items;

import game.characters.Instructor;
import game.characters.Student;
import game.graphical.WetRagView;
import game.rooms.RegularRoom;
import game.rooms.Room;

import javax.swing.*;
import java.io.Serializable;
import java.util.Scanner;

public class WetRag extends Item  implements Serializable {

    //Megadja, hogy hany korig lehet meg felhasznalni a WetRag-et
    private int wetness = 3;

    //input: -
    //method: Visszaadja a Wetness erteket
    //return: int
    public int getWetness(){
        return this.wetness;
    }
    public void setWetness(int wetness) {this.wetness = wetness;}


    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){
        user.getRoom().addWetRag(this);
        user.removeItem(this);
        System.out.println("The student placed a wet rag in the room!");
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
    public void onPickedUp(Student student){}

    @Override
    public void setView(int x, int y) {
        ImageIcon icon = new ImageIcon("Assets/WetRag.png");
        this.itemView = new WetRagView(icon, x, y, this.wetness);
    }

    //input: -
    //method: Elvegzi a kor elejen szukseges modositasokat a palyan
    //return: void
    @Override
    public void onRoundStart(){
        wetness--;
    }

    //input: Student attacked, Instructor attacker
    //method: Azt az esemenyt kezeli, amikor egy hallgato talalkozik egy oktatoval, tehat egy mezore kerulnek
    //return: boolean
    @Override
    public boolean onAttacked(Student attacked, Instructor attacker){
        if(this.wetness > 0){
            this.use(attacked);
            System.out.println("The student was protected by the Wet Rag!");
            return true;
        }
        return false;
    }

}

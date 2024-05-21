package game.items;

import game.characters.Instructor;
import game.characters.Student;
import game.graphical.FFP2View;

import javax.swing.*;
import java.io.Serializable;

public class FFP2 extends Item  implements Serializable {

    //Megadja, hogy hanyszor ved meg meg az FFP2
    private int durability = 2;

    // Setter
    public void setDurability(int durability) {
        this.durability = durability;
    }

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){
        user.addMaskedRounds(durability);
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
        ImageIcon icon = new ImageIcon("Assets/FFP2.png");
        this.itemView = new FFP2View(icon, x, y, this.durability);
    }

    //input: -
    //method: Elvegzi a kor elejen szukseges modositasokat a palyan
    //return: void
    @Override
    public void onRoundStart(){
        if(durability > 0) {
            durability--;
        }
    }

    //input: Student attacked, Instructor attacker
    //method: Azt az esemenyt kezeli, amikor egy hallgato talalkozik egy oktatoval, tehat egy mezore kerulnek
    //return: boolean
    @Override
    public boolean onAttacked(Student attacked, Instructor attacker){ return false;}
}

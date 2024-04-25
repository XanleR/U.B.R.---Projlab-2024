package game.items;

import game.characters.Instructor;
import game.characters.Student;

import java.util.Scanner;

public class TVSZ extends Item{

    //Megadja, hogy hanyszor ved meg meg a TVSZ
    private int remainingProtection = 3;

    //input: int plus
    //method: Hozzaadja a kapott int-et a vedelmek szamahoz
    //return: void
    public void addProtection(int plus){
        this.remainingProtection += plus;
    }

    //input: -
    //method: Visszaadja a vedelmek szamat
    //return: int
    public int getRemainingProtection(){
        return this.remainingProtection;
    }

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){}

    //input: -
    //Megadja, hogy az Intructor felveheti-e a targyat
    //return: boolean
    @Override
    public boolean canInstructorPickUp(){ return true;}

    //input: Student student
    //method: Azt az esemenyt kezeli, amikor egy tanulo felveszi a targyat
    //return: void
    @Override
    public void onPickedUp(Student student){
        if(student.getTVSZ() == null){
            student.setTVSZ(this);
        }else{
            if(student.getTVSZ().getRemainingProtection() == 2){
                student.getTVSZ().addProtection(1);
            }else if(student.getTVSZ().getRemainingProtection() == 1){
                student.getTVSZ().addProtection(2);
            }
        }
    }


    //input: -
    //method: Elvegzi a kor elejen szukseges modositasokat a palyan
    //return: void
    @Override
    public void onRoundStart(){
        this.remainingProtection--;
    }

    //input: Student attacked, Instructor attacker
    //method: Azt az esemenyt kezeli, amikor egy hallgato talalkozik egy oktatoval, tehat egy mezore kerulnek
    //return: boolean
    @Override
    public boolean onAttacked(Student attacked, Instructor attacker){
        return this.remainingProtection > 0;
    }

}

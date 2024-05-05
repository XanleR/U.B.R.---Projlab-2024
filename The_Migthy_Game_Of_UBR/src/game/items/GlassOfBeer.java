package game.items;

import game.characters.Instructor;
import game.characters.Student;

import java.io.Serializable;
import java.util.Scanner;

public class GlassOfBeer extends Item  implements Serializable {

    private boolean activated = false;
    private int activeRounds;

    private boolean activatedOnce = false;

    //input: -
    //method: Aktivalja a GlassOfBeer-t
    //return: boolean
    public void activate(){
        if(!activatedOnce){
            activatedOnce = true;
            activated = true;
            activeRounds = 3;
        }
    }

    //input: -
    //method: Visszaadja, hogy aktivalva van-e a GlassOfBeer
    //return: boolean
    public boolean getActivated(){
        return this.activated;
    }

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){
        this.activate();
        user.dropRandomItem();
    }

    //input: -
    //Megadja, hogy az Intructor felveheti-e a targyat
    //return: boolean
    @Override
    public boolean canInstructorPickUp(){ return true; }

    //input: Stduent student
    //method: Azt az esemenyt kezeli, amikor egy tanulo felveszi a targyat
    //return: void
    @Override
    public void onPickedUp(Student student){
        student.addItem(this);
    }

    //input: -
    //method: Elvegzi a kor elejen szukseges modositasokat a palyan
    //return: void
    @Override
    public void onRoundStart(){
        if(this.activeRounds > 0){
            this.activeRounds--;
        }
    }

    //input: Student attacked, Instructor attacker
    //method: Azt az esemenyt kezeli, amikor egy hallgato talalkozik egy oktatoval, tehat egy mezore kerulnek
    //return: boolean
    @Override
    public boolean onAttacked(Student attacked, Instructor attacker){
        if(this.activeRounds > 0){
            if(this.activated){
                System.out.println("The student was protected by the Glass Of Beer!");
                return true;
            }else{
                this.activate();
                System.out.println("The student was protected by the Glass Of Beer!");
                return true;
            }
        }else{
            return false;
        }
    }



}

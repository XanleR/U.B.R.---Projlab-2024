package game.items;

import game.characters.Instructor;
import game.characters.Student;

public class GlassOfBeer extends Item {

    private boolean activated;

    //input: -
    //method: Aktivalja a GlassOfBeer-t
    //return: boolean
    public boolean activate(){ return false; }

    //input: -
    //method: Visszaadja, hogy aktivalva van-e a GlassOfBeer
    //return: boolean
    public boolean getActivated(){ return this.activated;}

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){
        System.out.println("\t\t -->(this: GlassOfBeer).activate()");
        this.activate();
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
    public boolean onAttacked(Student attacked, Instructor attacker){ return false;}



}

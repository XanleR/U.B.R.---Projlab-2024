package game.items;

import game.characters.Instructor;
import game.characters.Student;

public class Dice extends Item{

    //Megadja a legutobbi dobott erteket
    private int currentValue;

    //input: -
    //method: A currentValue-t beallitja egy 1-6 kozotti random ertekre
    //return: void
    public void throwDice(){}

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){
        System.out.println("\t\t -->(this: Dice).throw()");
        this.throwDice();
        System.out.println("\t\t <--");
        System.out.println("\t\t -->(user: Student).addRounds(currentvalue: int)");
        user.addRounds(currentValue);
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

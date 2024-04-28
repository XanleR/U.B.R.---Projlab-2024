package game.items;

import game.characters.Instructor;
import game.characters.Student;

import java.util.Random;

public class Dice extends Item{

    //Megadja a legutobbi dobott erteket
    private int currentValue;

    //input: -
    //method: A currentValue-t beallitja egy 1-6 kozotti random ertekre
    //return: void
    public void throwDice(){
        Random rd = new Random();
        this.currentValue = rd.nextInt(1, 6);
        System.out.println("You rolled "+currentValue+" with the Dice");
    }

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){
        this.throwDice();
        user.addRounds(this.getCurrentValue());
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

    public int getCurrentValue() {
        return currentValue;
    }
}

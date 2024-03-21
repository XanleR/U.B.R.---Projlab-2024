package game.items;

import game.characters.Instructor;
import game.characters.Student;

public abstract class Item {

    //Megadja a targy leirasat
    private String desc;

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    public abstract void use(Student user);

    //input: -
    //Megadja, hogy az Intructor felveheti-e a targyat
    //return: boolean
    public abstract boolean canInstructorPickUp();

    //input: -
    //method: Azt az esemenyt kezeli, amikor egy tanulo felveszi a targyat
    //return: void
    public abstract void onPickedUp();

    //input: -
    //method: Elvegzi a kor elejen szukseges modositasokat a palyan
    //return: void
    public abstract void onRoundStart();

    //input: Student attacked, Instructor attacker
    //method: Azt az esemenyt kezeli, amikor egy hallgato talalkozik egy oktatoval, tehat egy mezore kerulnek
    //return: boolean
    public abstract boolean onAttacked(Student attacked, Instructor attacker);


}

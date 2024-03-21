package game.items;

import game.characters.Instructor;
import game.characters.Student;

public class TVSZ extends Item{

    //Megadja, hogy hanyszor ved meg meg a TVSZ
    private int remainingProtection;

    //input: int plus
    //method: Hozzaadja a kapott int-et a vedelmek szamahoz
    //return: void
    public void addProtection(int plus){}

    //input: -
    //method: Visszaadja a vedelmek szamat
    //return: int
    public int getRemainingProtection(){ return this.remainingProtection; }

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){}

    //input: -
    //Megadja, hogy az Intructor felveheti-e a targyat
    //return: boolean
    @Override
    public boolean canInstructorPickUp(){ return false;}

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
    public boolean onAttacked(Student attacked, Instructor attacker){return false;}

}

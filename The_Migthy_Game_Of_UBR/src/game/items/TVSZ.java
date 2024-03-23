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
        System.out.println("\t\t\t\t--> (tvsz1: TVSZ).addProtection("+plus+": int)");

        System.out.println("\t\t\t\t<--");
    }

    //input: -
    //method: Visszaadja a vedelmek szamat
    //return: int
    public int getRemainingProtection(){
        System.out.println("\t\t\t\t--> (tvsz1: TVSZ).getRemainingProtection()");

        System.out.println("\t\t\t\t<-- remainingProtection: int");
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
    public boolean onAttacked(Student attacked, Instructor attacker){
        System.out.println("\t\t\t--> (tvsz1: TVSZ).onAttacked(testS1: Student, testI1: Instructor)");

        int r = this.getRemainingProtection();
        System.out.println("\t\t\t-?- Nagyobb-e, mint 0 a maradek vedelem? (y/n): ");
        Scanner attackedScanner = new Scanner(System.in);
        String attackedAnswer = attackedScanner.next();
        if(attackedAnswer.equals("y")){
            this.addProtection(-1);
            r = this.getRemainingProtection();
            System.out.println("\t\t\t-?- Elfogyott a vedelem? (y/n): ");
            attackedAnswer = attackedScanner.next();
            if(attackedAnswer.equals("y")){
                attacked.removeItem(this);
            }
            System.out.println("\t\t\t<-- true: boolean");
            return true;
        }


        System.out.println("\t\t\t<-- false: boolean");
        return false;
    }

}

package game.items;

import game.characters.Instructor;
import game.characters.Student;
import game.rooms.RegularRoom;
import game.rooms.Room;

import java.util.Scanner;

public class WetRag extends Item{

    //Megadja, hogy hany korig lehet meg felhasznalni a WetRag-et
    private int wetness;

    //input: -
    //method: Visszaadja a Wetness erteket
    //return: int
    public int getWetness(){
        System.out.println("\t\t\t\t--> (wetRag: WetRag).getWetness()");

        System.out.println("\t\t\t\t<-- wetness: int");

        return this.wetness;
    }


    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){
        System.out.println("\t\t -->(user: Student).getRoom()");
        Room userRoom = user.getRoom();
        userRoom = new RegularRoom();
        System.out.println("\t\t <--userRoom: Room");
        System.out.println("\t\t -->(userRoom: Room).addWetRag(this)");
        userRoom.addWetRag(this);
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
    public boolean onAttacked(Student attacked, Instructor attacker){
        System.out.println("\t\t\t--> (wetRag: WetRag).onAttacked(testS1: Student, testI1: Instructor)");

        int r = this.getWetness();
        System.out.println("\t\t\t-?- Meg nedves a rongy? (y/n): ");

        Scanner scanner = new Scanner(System.in);
        String wetnessAnswer = scanner.next();

        if(wetnessAnswer.equals("y")){
            System.out.println("\t\t\t--> (wetRag: WetRag).use(testS1: Student)");
            this.use(attacked);
            System.out.println("\t\t\t<--");

            attacker.stun(1);

            System.out.println("<-- true: boolean");
            return true;

        }


        System.out.println("<-- false: boolean");
        return false;
    }
}

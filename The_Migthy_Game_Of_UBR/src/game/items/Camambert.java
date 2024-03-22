package game.items;

import game.GameController;
import game.Skeleton;
import game.characters.Instructor;
import game.characters.Student;
import game.rooms.GasRoom;
import game.rooms.RegularRoom;
import game.rooms.Room;

import static game.Skeleton.gameController;

public class Camambert extends Item{

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    @Override
    public void use(Student user){
        System.out.println("\t\t -->(user: Student).getRoom()");
        Room userRoom = user.getRoom();
        userRoom = new RegularRoom();
        System.out.println("\t\t <--userRoom: Room");
        System.out.println("\t\t -->(newGas: GasRoom).new()");
        GasRoom newGas = new GasRoom();
        System.out.println("\t\t <--");
        System.out.println("\t\t -->(userRoom: Room).copyToRoom(newGas: GasRoom)");
        userRoom.copyToRoom(newGas);
        System.out.println("\t\t <--");
        System.out.println("\t\t -->(gameController: GameController).addRoom(newGas)");
        gameController.addRoom(newGas);
        System.out.println("\t\t <--");
        System.out.println("\t\t -->(gameController: GameController).removeRoom(userRoom)");
        gameController.removeRoom(userRoom);
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

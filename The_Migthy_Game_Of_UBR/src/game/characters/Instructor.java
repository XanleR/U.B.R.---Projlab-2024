package game.characters;

import game.items.Item;
import game.rooms.Room;

import java.util.Scanner;

public class Instructor extends Character{
    //input: Room from, Room to
    //method: A karaktert athelyezi az egyik bemenetkent adott szobabol a masikba
    //return: void
    @Override
    public void move(Room from, Room to) {
        System.out.println("\t--> (testR2: Room).addCharacter(testI1: Instructor)");
        to.addCharacter(this);
    }

    //input: Item newI
    //method: A parameterkent megadott Item-et Student eseten berkaja a Student List<item>-ebe, Instructor eseten kitorli
    //        az Item-et a jatekbol
    //return: void
    @Override
    public void pickUpItem(Item newI){}

    //input: -
    //method: vegrehajtja a felhasznalo altal kivalasztott action-t
    //return: void
    @Override
    public void action() {}

    //input: Character character
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy másik Character-el kerul egy mezore
    //return: void
    @Override
    public void meet(Character character){}

    //input: Student student
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Student-el kerul egy mezore
    //return: void
    @Override
    public void meetStudent(Student student) {
        System.out.printf("\t--> (testI1: Instructor).meetStudent(testS1: Student)");

        student.die(this);

        System.out.println("\t<--");
    }

    //input: Instructor instructor
    //method: Vegrehajtja azt az esemenyt, amikor a pedany egy Instructor-el kerul egy mezore
    //return: void
    @Override
    public void meetInstructor(Instructor instructor) {}

    //input: -
    //method: Elindítja a játékos körét, és meghívja a paraméterként kapott számmal az ‘action’ függvényt
    //return: void
    @Override
    public void startRound(int in) {}
}

package game.characters;

import game.items.Item;
import game.rooms.Room;


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
    public void meet(Character character){
        System.out.println("--> (testI1: Instructor).meet(testS1: Character)");
        character.meetInstructor(this);

        System.out.println("<--");
    }

    //input: Student student
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Student-el kerul egy mezore
    //return: void
    @Override
    public void meetStudent(Student student) {
        System.out.println("\t--> (testI1: Instructor).meetStudent(testS1: Student)");

        student.die(this);

        System.out.println("\t<--");
    }

    //input: Instructor instructor
    //method: Vegrehajtja azt az esemenyt, amikor a pedany egy Instructor-el kerul egy mezore
    //return: void
    @Override
    public void meetInstructor(Instructor instructor) {
        System.out.println("\t\t\t--> (i1: Instructor).meetInstructor(testI1)");

        System.out.println("\t\t\t<--");
    }

    @Override
    public void droppAllItems() {

    }

    //input: -
    //method: Elindítja a játékos körét, és meghívja a paraméterként kapott számmal az ‘action’ függvényt
    //return: void
    @Override
    public void startRound(int in) {}

    //input: int stunned
    //method: Az adott tanár elkábul a paraméterként kapott körre
    //return: void
    public void stun(int stunned){}
}

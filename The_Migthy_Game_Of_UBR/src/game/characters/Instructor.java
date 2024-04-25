package game.characters;

import game.items.Item;
import game.rooms.Room;

import java.util.Random;


public class Instructor extends Character{
    //input: Room from, Room to
    //method: A karaktert athelyezi az egyik bemenetkent adott szobabol a masikba
    //return: void
    @Override
    public void move(Room from, Room to) {
        if(stunnedRounds <= 0){
            to.addCharacter(this);
        }
        else{
            System.out.println("The Instructor could not move to the "+to.getUniqueName());
        }
    }

    //input: Item newI
    //method: A parameterkent megadott Item-et Student eseten berkaja a Student List<item>-ebe, Instructor eseten kitorli
    //        az Item-et a jatekbol
    //return: void
    @Override
    public void pickUpItem(Item newI){
        this.currentRoom.removeItem(newI);
    }

    //input: -
    //method: vegrehajtja a felhasznalo altal kivalasztott action-t
    //return: void
    @Override
    public void action() {
        Random random = new Random();
        int index = random.nextInt(currentRoom.getNeighbours().size());
        move(currentRoom, currentRoom.getNeighbours().get(index));
    }

    //input: Character character
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy másik Character-el kerul egy mezore
    //return: void
    @Override
    public void meet(Character character){
        character.meetInstructor(this);
    }

    //input: Student student
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Student-el kerul egy mezore
    //return: void
    @Override
    public void meetStudent(Student student) {
        student.die(this);
    }

    //input: Instructor instructor
    //method: Vegrehajtja azt az esemenyt, amikor a pedany egy Instructor-el kerul egy mezore
    //return: void
    @Override
    public void meetInstructor(Instructor instructor) {

    }

    @Override
    public void meetCleaner(Cleaner cleaner) {
        this.forceMove();
    }

    //input: -
    //method: Elindítja a játékos körét, és meghívja a paraméterként kapott számmal az ‘action’ függvényt
    //return: void
    @Override
    public void startRound(int in) {
        if(stunnedRounds != 0){
            System.out.println("The cleaner is stunned, no actions for this round...");
            stunnedRounds--;
            return;
        }
        Random random = new Random();
        remainingactions = random.nextInt(6)+1;
        while(remainingactions > 0 && stunnedRounds == 0){
            action();
            remainingactions--;
        }
        remainingactions = 0;
    }

    @Override
    public void forceMove() {
        for(Room room : currentRoom.getNeighbours()){
            if(room.isAccessible(currentRoom)){
                room.addCharacter(this);
            }
        }
    }

    //input: int stunned
    //method: Az adott tanár elkábul a paraméterként kapott körre
    //return: void
    public void stun(int stunned){
        stunnedRounds += stunned;
    }
}

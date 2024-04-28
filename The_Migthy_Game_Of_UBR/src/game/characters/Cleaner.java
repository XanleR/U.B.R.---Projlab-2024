package game.characters;

import game.GameController;
import game.items.*;
import game.rooms.RegularRoom;
import game.rooms.Room;

import java.io.Serializable;
import java.util.Random;

public class Cleaner extends Character implements Serializable {

    //input: int stunned
    //method: Az adott takarító elkábul a paraméterként kapott körre
    //return: void
    @Override
    public void stun(int stunned) {
        stunnedRounds += stunned;
    }

    //input: Room from, Room to
    //method: A karaktert athelyezi az egyik bemenetkent adott szobabol a masikba
    //return: void
    @Override
    public void move(Room from, Room to) {
        if(stunnedRounds <= 0){
            RegularRoom regularRoom = new RegularRoom();
            currentRoom.copyToRoom(regularRoom);
            GameController.getInstance().removeRoom(currentRoom);
            GameController.getInstance().addRoom(regularRoom);
            to.addCharacter(this);
            System.out.println("The room was cleaned");
        }
        else{
            System.out.println("The Cleaner could not move to the "+to.getUniqueName());
        }
    }

    //input: Item newI
    //method: A paraméterként megadott Item-et, mikor a takarító felveszi, kitörli a játékból.
    //return: void
    @Override
    public void pickUpItem(Item newI) {
        this.currentRoom.removeItem(newI);
    }

    //input: void
    //Végrehajtja a tanár egyik akcióját
    //return: void
    @Override
    public void action() {
        if(!currentRoom.getItems().isEmpty()){
            pickUpItem(currentRoom.getItems().get(0));
            return;
        }

        Random random = new Random();
        int index = random.nextInt(currentRoom.getNeighbours().size());
        move(currentRoom, currentRoom.getNeighbours().get(index));
    }

    //input: Character character
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy másik Character-el kerul egy mezore
    //return: void
    @Override
    public void meet(Character character) {
        character.meetCleaner(this);
    }

    //input: Student student
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Student-el kerul egy mezore
    //return: void
    @Override
    public void meetStudent(Student student) {
        student.forceMove();
    }

    //input: Instructor instructor
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Instructor-el kerul egy mezore
    //return: void
    @Override
    public void meetInstructor(Instructor instructor) {
        instructor.forceMove();
    }

    //input: Cleaner cleaner
    //method: Végrehajtja azt az esemlnyt, amikor a példány egy Cleaner-el kerül egy mezőre
    //return: void
    @Override
    public void meetCleaner(Cleaner cleaner) {

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

    //input: -
    //method: Az adott tanár mozgásra kényszerült, ez a függvény átteszi őt egy szomszédos szobába
    //return: void
    @Override
    public void forceMove() {
        if(stunnedRounds == 0){
            for(Room room: currentRoom.getNeighbours()) {
                if (room.isAccessible(currentRoom)) {
                    room.addCharacter(this);
                    System.out.println("The character was forced to move to another room...");
                    break;
                }
            }
        }
    }
}

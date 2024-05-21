package game.characters;

import game.graphical.CharacterView;
import game.items.Item;
import game.rooms.Room;

import javax.swing.*;
import java.io.Serializable;
import java.util.Random;


public class Instructor extends Character implements Serializable {
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
    //method: A parameterként megadott Item-et, mikor a tanár felveszi, kitörli a játékból
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
        if(!currentRoom.getItems().isEmpty()){
            pickUpItem(currentRoom.getItems().get(0));
            return;
        }

        Random random = new Random();
        if(currentRoom.getNeighbours().isEmpty()){
            System.out.println("The "+uniqueName+" cannot move anywhere...");
            return;
        }
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
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Instructor-el kerul egy mezore
    //return: void
    @Override
    public void meetInstructor(Instructor instructor) {

    }

    //input: Cleaner cleaner
    //method: Végrehajtja azt az esemlnyt, amikor a példány egy Cleaner-el kerül egy mezőre
    //return: void
    @Override
    public void meetCleaner(Cleaner cleaner) {
        this.forceMove();
    }

    //input: -
    //method: Elindítja a játékos körét, és meghívja a paraméterként kapott számmal az ‘action’ függvényt
    //return: void
    @Override
    public void startRound(int in) {
        System.out.println("---------------------------------------");
        System.out.println("New round for "+uniqueName);
        if(stunnedRounds != 0){
            System.out.println("The "+uniqueName+" is stunned, no actions for this round...");
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


    @Override
    public void setView() {
        ImageIcon icon = new ImageIcon("Assets/Instructor.png");
        this.characterView = new CharacterView(icon,this);
    }


    //input: int stunned
    //method: Az adott tanár elkábul a paraméterként kapott körre
    //return: void
    public void stun(int stunned){
        stunnedRounds += stunned;
    }
}

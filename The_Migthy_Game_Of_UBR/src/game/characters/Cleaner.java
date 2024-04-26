package game.characters;

import game.GameController;
import game.items.*;
import game.rooms.Room;

import java.util.Random;

public class Cleaner extends Character{
    @Override
    public void stun(int stunned) {
        stunnedRounds += stunned;
    }

    @Override
    public void move(Room from, Room to) {
        if(stunnedRounds <= 0){
            to.addCharacter(this);
        }
        else{
            System.out.println("The Student could not move to the "+to.getUniqueName());
        }
    }

    @Override
    public void pickUpItem(Item newI) {
        this.currentRoom.removeItem(newI);
    }

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

    @Override
    public void meet(Character character) {
        character.meetCleaner(this);
    }

    @Override
    public void meetStudent(Student student) {
        student.forceMove();
    }

    @Override
    public void meetInstructor(Instructor instructor) {
        instructor.forceMove();
    }

    @Override
    public void meetCleaner(Cleaner cleaner) {

    }

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
        for(Room room: currentRoom.getNeighbours()){
            if(room.isAccessible(currentRoom)){
                room.addCharacter(this);
            }
        }
    }
}

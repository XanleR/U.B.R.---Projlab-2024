package game.characters;

import game.GameController;
import game.items.*;
import game.rooms.Room;

public class Cleaner extends Character{
    @Override
    public void stun(int stun) {
        stunnedRounds += stun;
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

    }

    @Override
    public void action() {

    }

    @Override
    public void meet(Character character) {

    }

    @Override
    public void meetStudent(Student student) {

    }

    @Override
    public void meetInstructor(Instructor instructor) {

    }

    @Override
    public void meetCleaner(Cleaner cleaner) {

    }

    @Override
    public void startRound(int in) {

    }

    @Override
    public void forceMove() {

    }
}

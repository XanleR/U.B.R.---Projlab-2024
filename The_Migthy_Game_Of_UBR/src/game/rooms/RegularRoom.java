package game.rooms;

import game.GameController;
import game.characters.Character;
import game.graphical.RoomView;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class RegularRoom extends Room  implements Serializable {


    private int stepCount=0;
    private final int maxStepCount = 10;

    //input: Character c1
    //method: Azt az esemenyt kezeli, amikor egy karakter a szobaba lep
    //return: void
    @Override
    public void onEntered(Character c1) {
        this.putCharacter(c1);

        stepCount++;

        //Ha eléri a belépések száma a limitet, létrehzunk egy új ragacsos szobát
        if(stepCount == maxStepCount){
            StickyRoom stickyRoom = new StickyRoom();
            this.copyToRoom(stickyRoom);
            GameController.getInstance().removeRoom(this);
            GameController.getInstance().addRoom(stickyRoom);
            System.out.println("The room became sticky!");
        }
        else{
            List<Character> chList = new ArrayList<>(this.getCharacters());
            for(Character ch : chList){

                ch.meet(c1);
            }
        }
    }

    @Override
    public String imageLocation() {
        return "Assets/Room.png";
    }

    //input: int stepCount
    //method: Beállítja a szoba stepCount változóját
    //return: void
    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }
}

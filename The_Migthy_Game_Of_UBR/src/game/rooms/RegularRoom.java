package game.rooms;

import game.GameController;
import game.characters.Character;

public class RegularRoom extends Room {

    private int stepCount=0;
    private final int maxStepCount = 10;

    //input: Character c1
    //method: Azt az esemenyt kezeli, amikor egy karakter a szobaba lep
    //return: void
    @Override
    public void onEntered(Character c1) {
        stepCount++;

        //Ha eléri a belépések száma a limitet, létrehzunk egy új ragacsos szobát
        if(stepCount == maxStepCount){
            StickyRoom stickyRoom = new StickyRoom();
            this.copyToRoom(stickyRoom);
            GameController.getInstance().removeRoom(this);
            GameController.getInstance().addRoom(stickyRoom);
        }
        else{
            for(Character ch : this.getCharacters()){
                ch.meet(c1);
            }
        }

    }
}

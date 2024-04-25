package game.rooms;

import game.characters.Character;
import game.characters.Student;
import game.items.Item;

public class StickyRoom extends Room{
    @Override
    public void onEntered(Character c1) {
        for(Character ch : this.getCharacters()){
            ch.meet(c1);
        }
    }
    
    @Override
    public void pickUp(Item i, Student ch){}
}

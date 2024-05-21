package game.rooms;

import game.characters.Character;
import game.characters.Student;
import game.items.Item;

import java.io.Serializable;

public class StickyRoom extends Room  implements Serializable {
    @Override
    public void onEntered(Character c1) {
        for(Character ch : this.getCharacters()){
            ch.meet(c1);
        }
    }
    
    @Override
    public void pickUp(Item i, Student ch){}

    @Override
<<<<<<< Updated upstream
=======
    public void setRoomView(int x, int y) {
        ImageIcon icon = new ImageIcon(this.imageLocation());
        this.roomView = new RoomView(icon, x, y, this);
    }

    @Override
>>>>>>> Stashed changes
    public String imageLocation() {
        return "Assets/StickyRoom.png";
    }
}

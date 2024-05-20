package game.items;

import game.characters.Character;
import game.characters.Instructor;
import game.characters.Student;
import game.graphical.ItemView;
import game.rooms.RegularRoom;
import game.rooms.Room;

import javax.swing.*;
import java.io.Serializable;

import static game.GUI.gameController;

public class AirFreshener extends Item  implements Serializable {



    @Override
    public void use(Student user) {
        Room from = user.getRoom();
        Room newFreshRoom = new RegularRoom();
        user.getRoom().copyToRoom(newFreshRoom);
        gameController.addRoom(newFreshRoom);
        for (Character ch : user.getRoom().getCharacters()) {
            ch.move(from, newFreshRoom);
        }
        gameController.removeRoom(from);
    }

    @Override
    public boolean canInstructorPickUp() {
        return true;
    }

    @Override
    public void onPickedUp(Student student) {}

    @Override
    public void setView(int x, int y) {
        ImageIcon icon = new ImageIcon("Assetes/AirFreshener.png");
        this.itemView = new ItemView(icon, x, y);
    }

    @Override
    public void onRoundStart() {}

    @Override
    public boolean onAttacked(Student attacked, Instructor attacker) {
        return false;
    }

}

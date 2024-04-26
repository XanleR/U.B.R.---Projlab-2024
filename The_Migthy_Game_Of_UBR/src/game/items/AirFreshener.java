package game.items;

import game.characters.Character;
import game.characters.Instructor;
import game.characters.Student;
import game.rooms.RegularRoom;
import game.rooms.Room;

import static game.Prototype.gameController;

public class AirFreshener extends Item{
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
    public void onRoundStart() {}

    @Override
    public boolean onAttacked(Student attacked, Instructor attacker) {
        return false;
    }
}

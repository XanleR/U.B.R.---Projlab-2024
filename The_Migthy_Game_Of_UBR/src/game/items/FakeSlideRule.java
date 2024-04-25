package game.items;

import game.characters.Student;

import static game.Skeleton.gameController;

public class FakeSlideRule extends SlideRule{
    //input: Student student
    //method: Azt az esemenyt kezeli, amikor egy tanulo felveszi a targyat
    //return: void
    @Override
    public void onPickedUp(Student student){
        student.addItem(this);
    }
}

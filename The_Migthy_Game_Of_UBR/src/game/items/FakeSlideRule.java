package game.items;

import game.characters.Student;
import game.graphical.ItemView;


import javax.swing.*;
import java.io.Serializable;


public class FakeSlideRule extends SlideRule  implements Serializable {

    //input: Student student
    //method: Azt az esemenyt kezeli, amikor egy tanulo felveszi a targyat
    //return: void
    @Override
    public void onPickedUp(Student student) {
        student.addItem(this);
    }
}

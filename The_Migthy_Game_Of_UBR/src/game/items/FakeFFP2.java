package game.items;

import game.characters.Instructor;
import game.characters.Student;

import java.io.Serializable;

public class FakeFFP2 extends FFP2  implements Serializable {
    public void use(Student user){}

    //input: -
    //method: Elvegzi a kor elejen szukseges modositasokat a palyan
    //return: void
    @Override
    public void onRoundStart(){}

}

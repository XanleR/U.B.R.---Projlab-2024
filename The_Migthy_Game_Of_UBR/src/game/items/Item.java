package game.items;

import game.characters.Instructor;
import game.characters.Student;

import java.io.Serializable;

public abstract class Item  implements Serializable {

    //Megadja a targy leirasat
    private String desc;

    private String uniqueName;

    // Getter
    public String getDesc() { return desc;}

    // Setter
    public void setDesc(String desc) {this.desc = desc;}

    // Setter
    public void setUniqueName(String uniqueName) {this.uniqueName = uniqueName;}

    public String getUniqueName() {
        return uniqueName;
    }

    //input: Student user
    //method: Megvalositja a targyak felhasznalasat
    //return: void
    public abstract void use(Student user);

    //input: -
    //Megadja, hogy az Intructor felveheti-e a targyat
    //return: boolean
    public abstract boolean canInstructorPickUp();

    //input: Student student
    //method: Azt az esemenyt kezeli, amikor egy tanulo felveszi a targyat
    //return: void
    public abstract void onPickedUp(Student student);

    //input: -
    //method: Elvegzi a kor elejen szukseges modositasokat a palyan
    //return: void
    public abstract void onRoundStart();

    //input: Student attacked, Instructor attacker
    //method: Azt az esemenyt kezeli, amikor egy hallgato talalkozik egy oktatoval, tehat egy mezore kerulnek
    //return: boolean
    public abstract boolean onAttacked(Student attacked, Instructor attacker);


    public abstract String getImageLocation();
}

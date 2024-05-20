package game.items;

import game.characters.Instructor;
import game.characters.Student;
import game.graphical.ItemView;

import java.io.Serializable;

public abstract class Item  implements Serializable {

    //Megadja a targy leirasat
    private String desc;

    public ItemView getItemView() {
        return itemView;
    }

    protected ItemView itemView;

    private String uniqueName;

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    private int xCoord;
    private int yCoord;

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

    public abstract void setView(int x, int y);

    //input: -
    //method: Elvegzi a kor elejen szukseges modositasokat a palyan
    //return: void
    public abstract void onRoundStart();

    //input: Student attacked, Instructor attacker
    //method: Azt az esemenyt kezeli, amikor egy hallgato talalkozik egy oktatoval, tehat egy mezore kerulnek
    //return: boolean
    public abstract boolean onAttacked(Student attacked, Instructor attacker);

    public void setXY(int x, int y){
        this.xCoord = x;
        this.yCoord = y;
    }

    //public abstract String getImageLocation();

    //public abstract ItemView getView();

}

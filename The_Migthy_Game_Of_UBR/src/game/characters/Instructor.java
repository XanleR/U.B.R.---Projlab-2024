package game.characters;

public class Instructor extends Character{
    //input: Room from, Room to
    //method: A karaktert athelyezi az egyik bemenetkent adott szobabol a masikba
    //return: void
    @Override
    public void move(Room from, Room to) {}

    //input: Item newI
    //method: A parameterkent megadott Item-et Student eseten berkaja a Student List<item>-ebe, Instructor eseten kitorli
    //        az Item-et a jatekbol
    //return: void
    @Override
    public void pickUpItem(Item newI){}

    //input: -
    //method: vegrehajtja a felhasznalo altal kivalasztott action-t
    //return: void
    @Override
    public void action() {}

    //input: -
    //method: Vegrehajtja azt az esemenyt, amikor a peldany egy Student-el kerul egy mezore
    //return: void
    @Override
    public void meetStudent() {}

    //input: -
    //method: Vegrehajtja azt az esemenyt, amikor a pedany egy Instructor-el kerul egy mezore
    //return: void
    @Override
    public void meetInstructor() {}

    //input: -
    //method: Elindítja a játékos körét, és meghívja a paraméterként kapott számmal az ‘action’ függvényt
    //return: void
    @Override
    public void startRound(int in) {}
}

package game;

import game.characters.Student;
import game.rooms.RegularRoom;
import game.rooms.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import game.characters.Character;

public class GameController {

    private static GameController instance;

    public static GameController getInstance(){
        if(instance == null){
            instance = new GameController();
        }
        return instance;
    }

    //Megadja, hogy hany kor van meg hatra
    private int remainingRounds;

    //Megadja, hogy hany felhasznalo jatszhat a programmal
    private int studentCount;

    //Eltarolja a jatekban resztvevo Charactereket
    private List<Character> listOfCharacters;

    //Eltarolja a jatekban letezo szobakat
    private List<Room> rooms;

    private GameController(){
        listOfCharacters = new ArrayList<>();
        rooms = new ArrayList<>();
        studentCount = 0;
    }

    //input: List<Character> characetrs, List<Room> rooms
    //method: Letrehoz egy jatekot a megadott szobakkal es tanulokkal
    //return: -
    public GameController(List<Character> characters, List<Room> rooms){
        listOfCharacters = characters;
        this.rooms = rooms;
        studentCount = listOfCharacters.size();
    }

    //input: -
    //method: Kezeli azt az esemenyt, amikor egy Student felveszi a SlideRule targyat
    //return: void
    public void slideRulePickedUp(){
        System.out.println("\t\t\t--> (gameController: GameController).slideRulePickedUp()");

        this.endGame();

        System.out.println("\t\t\t<--");
    }

    //input: Room slipt
    //method: A kapott szobat 2 masik szobara osztja
    //return: void
    public void slpitRoom(Room split){
        System.out.println("--> (gameController: GameController).splitRoom(testR1)");
        Room splittable = new RegularRoom();
        split.splitTo(splittable);

        Student s1 = new Student();
        Student s2 = new Student();

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(s1);
        studentList.add(s2);

        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<studentList.size();i++){
            System.out.println("\t-?- Szeretned, hogy az s" + (i+1) +" hallgato atkeruljon az uj szobaba? (y/n):");
            String answer = scanner.next();

            if(answer.equals("y")){
                System.out.println("\t--> (testR2: Room).addCharacter(testS1: Student)");
                splittable.addCharacter(studentList.get(i));
                //System.out.println("\t\t<--");

                System.out.println("\t\t--> (testR1: Room).removeCharacter(s"+(i+1)+": Character)");
                split.removeCharacter(studentList.get(i));
                System.out.println("\t\t<--");


            }
        }

        System.out.println("<--");
    }

    //input: Room m1, Room m2
    //method: A kapott 2 szobabol 1 uj szobat hoz letre
    //return: void
    public void mergeRooms(Room m1, Room m2){
        System.out.println("--> (gameController: GameController).mergeRooms(testR1: Room, testR2: Room)");
        m1.mergeTo(m2);

        System.out.println("<--");
    }

    //input: Room newR
    //method: A kapott Room-ot felveszi a jatek szobai koze
    //return: void
    public void addRoom(Room newR){}

    //input: Room remove
    //method: A kapott szobat kitorli a jatek szobai kozul
    //return: void
    public void removeRoom(Room remove){}

    //input: -
    //method: Elindit egy uj kort
    //return: void
    public void newRound(){}

    //input: -
    //method: Kezeli azt az esemnyt, amikor a jateknak vege van
    //return: void
    public void endGame(){
        System.out.println("\t\t\t\t--> (gameController: GameController).endGame()");

        System.out.println("\t\t\t\t<--");
    }

    //input: Character removeable
    //method: A kapott Character-t kitorli a jatekban levo Characterek kozul
    //return: void
    public void removeCharacter(Character removeable){
        System.out.println("\t\t\t--> (gameController: GameController).removeCharacter(removeable: Character)");

        System.out.println("\t\t\t<--");
    }

    //input: -
    //method: Elinditja a jatekmenetet
    //return: void
    public void play(){}

    //input: -
    //method: Egy veletlenszeru egesz szamot general az 1-től 6-ig terjedo zart intervallumon.
    //return: int
    public int rollDice(){ return 0;}
}

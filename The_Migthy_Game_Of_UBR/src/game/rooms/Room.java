package game.rooms;

import game.characters.Character;
import game.characters.Instructor;
import game.characters.Student;
import game.items.Item;
import game.items.Transistor;
import game.items.WetRag;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Room {

    //A szobaban levo rongyok listaja
    private List<WetRag> wetRags;

    //A szobaban levo tranzisztor
    private Transistor transistor;

    //Megadja, hogy maximum hany db karakter lehet a szobaban egyszerre
    private int maxCharacter;

    //A szobaban levo jatekosok listaja
    private List<Character> listOfCharacters = new ArrayList<>();

    private String uniqueName;

    public String getUniqueName() {
        return uniqueName;
    }

    //input: Character c1
    //method: Azt az esemenyt kezeli, amikor egy karakter a szobaba lep
    //return: void
    public abstract void onEntered(Character c1);

    //input: Character c1
    //method: Hozzaadja az parameterkent kapott karaktert a szobahoz
    //return: void
    public void addCharacter(Character c1) {
        System.out.println("\t\t--> (testI1: Character).getRoom()");
        Room from = c1.getRoom();
        from = new RegularRoom();
        System.out.println("\t\t<-- from: Room");

        this.isAccessible(from);

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("\t\t-?- At lehet menni az uj szobaba? (y/n): ");
        String answer2 = scanner2.next();

        if (answer2.equals("y")){

            System.out.println("\t\t--> (testR1: Room).removeCharacter(testI1: Character)");
            from.removeCharacter(c1);
            System.out.println("\t\t<--");

            System.out.println("\t\t--> (testR2: Room).onEntered(testI1: Character)");
            this.onEntered(c1);
            System.out.println("\t\t<--");


            Scanner scanner = new Scanner(System.in);

            System.out.println("\t\t-?- Talalkozott az uj szobaba lepett karakter hallgatoval? (y/n): ");
            String answer = scanner.next();

            if(answer.equals("y")){
                Student s1 = new Student();
                s1.meet(c1);
            }

            System.out.println("\t\t-?- Talalkozott az uj szobaba lepett karakter tanarral? (y/n): ");
            answer = scanner.next();

            if(answer.equals("y")){
                Instructor i1 = new Instructor();
                i1.meet(c1);
            }
        }
    }


    public boolean isAccessible(Room r1) {
        System.out.println("\t\t--> (TestR2: Room).isAccessible(TestR1: Room)");

        System.out.println("\t\t<-- accessible: boolean");
        return true;
    }

    //input: -
    //method: Visszaadja a szobaban talalhato karaktereket
    //return: List<Character>
    public List<Character> getCharacters() {return new ArrayList<>();}

    //input: Character c1
    //method: Kitorli a parameterkent kapott karaktert a szobabol
    //return: void
    public void removeCharacter(Character c1) {
        System.out.println("\t--> (r1: Room).removeCharacter(testS1: Character)");

        System.out.println("\t<--");
    }

    //input: Item i1
    //method: Kitörli a parameterkent kapott Itemet a szobabol
    //return: void
    public void removeItem(Item i1) {}

    //input: Item i1
    //method: Hozzaadja a parameterkent kapott Item-et a szobahoz
    //return: void
    public void addItem(Item i1) {}

    //input: List<Item> l1
    //method: Hozzaadja a szobahoz a parameterkent kapott targyakat
    //return: void
    public void addItems(List<Item> l1) {}

    //input: -
    //method: Visszadja a szobaban talalhato targyakat
    //return: List<Item>
    public List<Item> getItems() { return new ArrayList<>();}

    //input: -
    //method: Visszaadja a szomszedos szobakat
    //return: List<Item>
    public List<Room> getNeighbours() {return new ArrayList<>();}

    //input: List<Item> l1
    //method: A parameterkent kapott lista tagjait hozzaadja a szoba szomszedaihoz
    //return: void
    public void addNeighbours(List<Room> l1) {}

    //input: List<Item> l1
    //method: Kitorli a szoba szomszedai kozul a parameterkent kapottakat
    //return: void
    public void removeNeighbours(List<Room> l1) {}

    //input: -
    //method: Visszaadja a szobaban elhelyezett tranzisztort
    //return: Transistor
    public Transistor geTransistor(){
        System.out.println("\t-->(r1: Room).getTransistor()");

        System.out.println("\t<-- t1: Transistor");
        return null;
    }

    //input: Room other
    //method: Atadja az r2-vel jelolt szobanak az adott szoba targyainak, es a szomszedos szobainak a felet. Igy valosul meg az osztodas
    //return: void
    public void splitTo(Room other){
        System.out.println("\t--> (testR1: Room).splitTo(splittable: Room)");
        System.out.println("\t<--");
    }

    //input: Room other
    //method: Atadja az r2-vel jelolt szobanak az adott szoba osszes szomszedjat, es targyat. Igy valosul meg a szobak osszevonasa
    //return: void
    public void mergeTo(Room other){
        System.out.println("\t--> (testR1: Room).mergeTo(testR2: Room)");

        System.out.println("\t<--");
    }

    //input: -
    //method: Atmasolja az r2-vel jelolt szobaba az adott szoba szomszedjait, targyait, es jatekosait
    //return: void
    public void copyToRoom(Room r2){}

    //input: Transistor added
    //method: Hozzaadja a parameterkent kapott tranzisztort a szobahoz
    //return: void
    public void addTransistor(Transistor added){}

    //input: WetRag added
    //method: Hozzaadja a parameterkent kapott rongyot a szobahoz.
    //return: void
    public void addWetRag(WetRag added){}

    //input: Item i, Character ch
    //method: Megvalósítja azt az eseményt, amikor a fel szeretnének venni egy itemet a szobából. (StickyRoom leszármazott pl nem engedi)
    //return: void
    public void pickUp(Item i, Character ch){}
}

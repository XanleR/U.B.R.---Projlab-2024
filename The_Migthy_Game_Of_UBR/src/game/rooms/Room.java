package game.rooms;

import game.characters.Character;
import game.characters.Student;
import game.items.Item;
import game.items.Transistor;
import game.items.WetRag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
*Class Done
*/
public abstract class Room  implements Serializable {

    //A szobaban levo rongyok listaja
    private List<WetRag> wetRags;

    //A szobaban levo tranzisztor
    private Transistor transistor;

    //Megadja, hogy maximum hany db karakter lehet a szobaban egyszerre
    private int maxCharacter;

    //A szobaban levo jatekosok listaja
    private List<Character> listOfCharacters = new ArrayList<>();

    private List<Item> listOfItems = new ArrayList<>();
    private List<Room> listOfNeighbours = new ArrayList<>();
    private String uniqueName;

    public String getUniqueName() {
        return uniqueName;
    }

    public void addCharacterCapacity(int plus){
        maxCharacter += plus;
    }

    //input: Character c1
    //method: Azt az esemenyt kezeli, amikor egy karakter a szobaba lep
    //return: void
    public abstract void onEntered(Character c1);

    //input: Character c1
    //method: Hozzaadja az parameterkent kapott karaktert a szobahoz
    //return: void
    public void addCharacter(Character c1) {
        this.onEntered(c1);
    }

    public void setCharacters(List<Character> newCharacters){
        this.listOfCharacters = newCharacters;
    }

    public void setWetRags(List<WetRag> newWetRags){
        this.wetRags = newWetRags;
    }

    public void setMaxCharacter(int newMax){
        this.maxCharacter = newMax;
    }

    public void setListOfItems(List<Item> newItems){
        this.listOfItems = newItems;
    }

    public void setListOfNeighbours(List<Room> newRooms){
        this.listOfNeighbours = newRooms;
    }

    public boolean isAccessible(Room r1) {
        //Ha tele van nem adhatunk hozza
        if(this.listOfCharacters.size() == maxCharacter){
            return false;
        }
        //Ha van transistorjump akkor elerheto
        if(this.transistor != null && this.transistor.getPairsRoom().getUniqueName().equals(r1.getUniqueName())){
            return true;
        }
        //Ha szomszedok akkor is elerheto
        for (Room neighbour : this.listOfNeighbours) {
            if (this.uniqueName.equals(neighbour.uniqueName)) {
                return true;
            }
        }
        return false;
    }

    //input: -
    //method: Visszaadja a szobaban talalhato karaktereket
    //return: List<Character>
    public List<Character> getCharacters(){return this.listOfCharacters;}

    //input: Character c1
    //method: Kitorli a parameterkent kapott karaktert a szobabol
    //return: void
    public void removeCharacter(Character c1) {
        this.listOfCharacters.remove(c1);
    }

    //input: Item i1
    //method: Kitörli a parameterkent kapott Itemet a szobabol
    //return: void
    public void removeItem(Item i1) {
        this.listOfItems.remove(i1);
    }

    //input: Item i1
    //method: Hozzaadja a parameterkent kapott Item-et a szobahoz
    //return: boolean
    public boolean addItem(Item i1) {
        if(this.maxCharacter != this.listOfItems.size()) {
            this.listOfItems.add(i1);
            return true;
        }
        return false;
    }

    //input: List<Item> l1
    //method: Hozzaadja a szobahoz a parameterkent kapott targyakat
    //return: void
    public void addItems(List<Item> l1) {
        this.listOfItems.addAll(l1);
    }

    public List<WetRag> getWetRags(){
        return this.wetRags;
    }

    //input: -
    //method: Visszadja a szobaban talalhato targyakat
    //return: List<Item>
    public List<Item> getItems() { return this.listOfItems;}

    //input: -
    //method: Visszaadja a szomszedos szobakat
    //return: List<Item>
    public List<Room> getNeighbours() {return this.listOfNeighbours;}

    //input: List<Item> l1
    //method: A parameterkent kapott lista tagjait hozzaadja a szoba szomszedaihoz
    //return: void
    public void addNeighbours(List<Room> l1) {
        this.listOfNeighbours.addAll(l1);
    }

    // add neighbour room
    public void addNeighbour(Room room) {
        this.listOfNeighbours.add(room);
    }

    //input: List<Item> l1
    //method: Kitorli a szoba szomszedai kozul a parameterkent kapottakat
    //return: void
    public void removeNeighbours(List<Room> l1) {
        this.listOfNeighbours.removeAll(l1);
    }

    //input: -
    //method: Visszaadja a szobaban elhelyezett tranzisztort
    //return: Transistor
    public Transistor geTransistor(){
        return this.transistor;
    }

    //input: Room other
    //method: Atadja az r2-vel jelolt szobanak az adott szoba targyainak, es a szomszedos szobainak a felet. Igy valosul meg az osztodas
    //return: void
    public void splitTo(Room other){
        Random rd = new Random();
        other.addCharacterCapacity(this.maxCharacter);

        //Ez a szomszedok elosztasa
        if((this.listOfNeighbours.size()%2) == 0){
            while(other.getNeighbours().size() <= this.listOfNeighbours.size()/2){
                int j = rd.nextInt(0 , this.listOfNeighbours.size()-1);
                other.getNeighbours().add(this.listOfNeighbours.get(j));
                this.listOfNeighbours.remove(this.listOfNeighbours.get(j));
            }
        }else{
            while(other.getNeighbours().size() <= (this.listOfNeighbours.size()-1)/2){
                int j = rd.nextInt(0 , this.listOfNeighbours.size()-1);
                other.getNeighbours().add(this.listOfNeighbours.get(j));
                this.listOfNeighbours.remove(this.listOfNeighbours.get(j));
            }
        }

        //Ez az itemek elosztasa
        if((this.listOfItems.size()%2) == 0){
            while(other.getItems().size() <= this.listOfItems.size()/2){
                int j = rd.nextInt(0 , this.listOfItems.size()-1);
                other.getItems().add(this.listOfItems.get(j));
                this.removeItem(this.listOfItems.get(j));
            }
        }else{
            while(other.getItems().size() <= (this.listOfItems.size()-1)/2){
                int j = rd.nextInt(0 , this.listOfItems.size()-1);
                other.getItems().add(this.listOfItems.get(j));
                this.removeItem(this.listOfItems.get(j));
            }
        }

        //Karakterek elosztasa
        if((this.listOfCharacters.size()%2) == 0){
            while(other.getCharacters().size() <= this.listOfCharacters.size()/2){
                int j = rd.nextInt(0 , this.listOfCharacters.size()-1);
                other.addCharacter(this.listOfCharacters.get(j));
                this.listOfCharacters.remove(this.listOfCharacters.get(j));
            }
        }else{
            while(other.getCharacters().size() <= (this.listOfCharacters.size()-1)/2){
                int j = rd.nextInt(0 , this.listOfCharacters.size()-1);
                other.addCharacter(this.listOfCharacters.get(j));
                this.listOfCharacters.remove(this.listOfCharacters.get(j));
            }
        }

        //WetRag-ek kette osztasa
        if((this.wetRags.size()%2)==0){
            while(other.getWetRags().size() <= this.wetRags.size()/2){
                int j = rd.nextInt(0, this.wetRags.size()-1);
                other.addWetRag(this.wetRags.get(j));
                this.wetRags.remove(this.wetRags.get(j));
            }
        }else{
            while(other.getWetRags().size() <= (this.wetRags.size()-1)/2){
                int j = rd.nextInt(0, this.wetRags.size()-1);
                other.addWetRag(this.wetRags.get(j));
                this.wetRags.remove(this.wetRags.get(j));
            }
        }
    }

    //input: Room other
    //method: Atadja az r2-vel jelolt szobanak az adott szoba osszes szomszedjat, es targyat. Igy valosul meg a szobak osszevonasa
    //return: void
    public void mergeTo(Room other){
        other.addCharacterCapacity(this.maxCharacter);
        other.addItems(this.listOfItems);
        other.addNeighbours(this.listOfNeighbours);
        other.getCharacters().addAll(this.listOfCharacters);
        other.addTransistor(this.transistor);
        other.getWetRags().addAll(this.wetRags);
    }

    //input: -
    //method: Atmasolja az r2-vel jelolt szobaba az adott szoba szomszedjait, targyait, es jatekosait
    //return: void
    public void copyToRoom(Room r2){
        r2.setMaxCharacter(this.maxCharacter);
        r2.setCharacters(this.listOfCharacters);
        r2.setListOfItems(this.listOfItems);
        r2.setWetRags(this.wetRags);
        r2.setListOfNeighbours(this.listOfNeighbours);
        r2.addTransistor(this.transistor);
    }

    //input: Transistor added
    //method: Hozzaadja a parameterkent kapott tranzisztort a szobahoz
    //return: void
    public void addTransistor(Transistor added){
        this.transistor = added;
    }

    //input: WetRag added
    //method: Hozzaadja a parameterkent kapott rongyot a szobahoz.
    //return: void
    public void addWetRag(WetRag added){
        this.wetRags.add(added);
    }

    //input: Item i, Student ch
    //method: Megvalósítja azt az eseményt, amikor a fel szeretnének venni egy itemet a szobából. (StickyRoom leszármazott pl nem engedi)
    //return: void
    public void pickUp(Item i, Student ch){
        if(ch.canPickUp()) {
            i.onPickedUp(ch);
            this.removeItem(i);
        }
    }
}

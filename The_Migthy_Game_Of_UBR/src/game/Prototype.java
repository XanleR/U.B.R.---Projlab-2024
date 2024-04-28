package game;

import game.characters.Character;
import game.characters.Cleaner;
import game.characters.Instructor;
import game.characters.Student;
import game.items.*;
import game.rooms.GasRoom;
import game.rooms.RegularRoom;
import game.rooms.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prototype {

    public static GameController gameController;
    public static GameInitializer gameInitializer;

    public static String testInput;

    private static int playerNumber;

    // Game mode: java game.Prototype playerNumber
    // Pl:        java game.Prototype 4

    // Test mode: java game.Prototype -test
    public static void main(String[] args){

        gameController = GameController.getInstance();
        gameInitializer = new GameInitializer();

        if(args.length != 1){
            System.out.println("Invalid parameters...");
            return;
        }
        if(args[0].equals("-test")){
            //TODO Tesztek

            boolean exit = false;
            while(!exit){
                //printTestOptions();
                System.out.print("\nPick a Test: ");

                Scanner scanner = new Scanner(System.in);
                int answer = Integer.parseInt(scanner.next());

                // Teszt szobák létrehozása
                RegularRoom regularRoom1 = new RegularRoom();
                RegularRoom regularRoom2 = new RegularRoom();
                RegularRoom regularRoom3 = new RegularRoom();
                GasRoom gasRoom = new GasRoom();

                // Teszt tárgyak létrehozása
                Dice dice = new Dice();
                Transistor transistor1 = new Transistor();
                Transistor transistor2 = new Transistor();
                transistor1.pairing(transistor2);
                transistor2.pairing(transistor1);

                WetRag wetRag = new WetRag();
                Camambert camambert = new Camambert();
                FFP2 ffp2 = new FFP2();
                TVSZ tvsz1 = new TVSZ();
                TVSZ tvsz2 = new TVSZ();
                GlassOfBeer glassOfBeer = new GlassOfBeer();

                // Teszt karakterek létrehozása
                Student student = new Student();
                Instructor instructor = new Instructor();
                Cleaner cleaner = new Cleaner();

                List<Room> regularRoomList = new ArrayList<>();
                List<Character> characterList = new ArrayList<>();

                switch (answer){
                    case 0:
                        exit = true;
                        break;
                    case 1:
                        System.out.println("Input: studentMove simpleMove room1");
                        //Student Move
                        regularRoomList.add(regularRoom2);
                        regularRoom1.addNeighbours(regularRoomList);

                        student.setCurrentRoom(regularRoom1);
                        student.move(regularRoom1, regularRoom2);

                        System.out.println("Input studentMove transistorJump room1");
                        regularRoom1.addTransistor(transistor1);
                        regularRoom2.addTransistor(transistor1);
                        student.setCurrentRoom(regularRoom1);
                        transistor1.setCurrentRoom(regularRoom1);
                        transistor2.setCurrentRoom(regularRoom2);
                        student.transistorJump();

                        break;

                    case 2:
                        //Instructor Move
                        System.out.println("Input: teacherMove room1");
                        regularRoomList.add(regularRoom2);
                        regularRoom1.addNeighbours(regularRoomList);

                        instructor.setCurrentRoom(regularRoom1);
                        instructor.move(regularRoom1, regularRoom2);
                        break;

                    case 3:
                        //Cleaner Move
                        System.out.println("Input: cleanerMove room1");
                        regularRoomList.add(regularRoom2);
                        regularRoom1.addNeighbours(regularRoomList);

                        cleaner.setCurrentRoom(regularRoom1);
                        cleaner.move(regularRoom1, regularRoom2);
                        break;

                    case 4:
                        System.out.println("Input: dropItem item1");
                        //Drop Item
                        student.addItem(dice);
                        student.setCurrentRoom(regularRoom1);
                        regularRoom1.setMaxCharacter(5);
                        student.dropItem(dice);
                        break;

                    case 5:
                        //Pick Up Item
                        System.out.println("Input: pickUpItem item1");
                        regularRoom1.setMaxCharacter(5);
                        regularRoom1.addItem(dice);
                        student.setCurrentRoom(regularRoom1);
                        student.setInventorySize(5);
                        student.pickUpItem(dice);
                        break;

                    case 6:
                        //Use Dice
                        System.out.println("Input: useItem dice1");
                        student.setInventorySize(5);
                        student.addItem(dice);
                        student.useItem(dice);
                        break;

                    case 7:
                        //Use Transistor
                        System.out.println("Input: useItem transistor1");
                        student.setCurrentRoom(regularRoom1);
                        student.addItem(transistor1);
                        student.useItem(transistor1);
                        break;

                    case 8:
                        //Use WetRag
                        System.out.println("Input: useItem wetRag1");
                        student.setCurrentRoom(regularRoom1);
                        student.addItem(wetRag);
                        student.useItem(wetRag);
                        break;

                    case 9:
                        //Use Camambert
                        System.out.println("Input: useItem camambert1");
                        student.setCurrentRoom(regularRoom1);
                        student.addItem(camambert);
                        student.useItem(camambert);
                        break;

                    case 10:
                        //Student Enters Gas Room
                        System.out.println("Input: studentMove simpleMove gasRoom room1");
                        student.setCurrentRoom(regularRoom1);
                        regularRoomList.add(gasRoom);
                        student.move(regularRoom1, gasRoom);

                        System.out.println("Input studentMove transistorJump room1");
                        regularRoom1.addTransistor(transistor1);
                        gasRoom.addTransistor(transistor1);
                        student.setCurrentRoom(regularRoom1);
                        transistor1.setCurrentRoom(regularRoom1);
                        transistor2.setCurrentRoom(gasRoom);
                        student.transistorJump();
                        break;

                    case 11:
                        //Student Enters Gas Room with FFP2
                        System.out.println("Input: studentMove simpleMove gasRoom room1");
                        student.setCurrentRoom(regularRoom1);
                        student.addMaskedRounds(2);
                        regularRoomList.add(gasRoom);
                        student.move(regularRoom1, gasRoom);

                        System.out.println("Input studentMove transistorJump room1");
                        regularRoom1.addTransistor(transistor1);
                        gasRoom.addTransistor(transistor1);
                        student.setCurrentRoom(regularRoom1);
                        transistor1.setCurrentRoom(regularRoom1);
                        transistor2.setCurrentRoom(gasRoom);
                        student.transistorJump();
                        break;

                    case 12:
                        //Split Room
                        System.out.println("Input: splitRoom room1");
                        regularRoom1.splitTo(regularRoom2);
                        break;

                    case 13:
                        //Merge Room
                        System.out.println("Input: mergeRooms room1, room2");
                        regularRoom1.mergeTo(regularRoom2);
                        break;

                    case 14:
                        characterList.add(student);
                        characterList.add(instructor);
                        student.setCurrentRoom(regularRoom1);
                        instructor.setCurrentRoom(regularRoom1);
                        regularRoom1.setCharacters(characterList);

                        cleaner.setCurrentRoom(regularRoom2);
                        regularRoomList.add(regularRoom1);
                        regularRoom2.setListOfNeighbours(regularRoomList);
                        regularRoomList.clear();
                        regularRoomList.add(regularRoom2);
                        regularRoom1.setListOfNeighbours(regularRoomList);

                        cleaner.move(regularRoom2, regularRoom1);

                }

            }

        }
        else{
            try {
                playerNumber = Integer.parseInt(args[0]);

                //TODO játék elkezdése
                //gameInitializer.initCharacters(playerNumber);
                //gameInitializer.initMaps();

            }
            catch (NumberFormatException nfe){
                System.out.println("Invalid parameters...");
                return;
            }
        }
    }

    private static void printTestOptions(){
        System.out.println("\n0 - Exit");
        System.out.println("1 - Student Move");
        System.out.println("2 - Instructor Move");
        System.out.println("3 - Cleaner Move");
        System.out.println("4 - Drop Item");
        System.out.println("5 - Pick Up Item");
        System.out.println("6 - Use Dice");
        System.out.println("7 - Use Transistor");
        System.out.println("8 - Use WetRag");
        System.out.println("9 - Use Camambert");
        System.out.println("10 - Student Enters Gas Room");
        System.out.println("11 - Student Enters Gas Room With FFP2");
        System.out.println("12 - Split Room");
        System.out.println("13 - Merge Room");
        System.out.println("14 - Cleaner Enters a Room with a Student and a Stunned Instructor");
        System.out.println("15 - Cleaner Enters Gas Room");
        System.out.println("16 - Student Enters a Room that Becomes Sticky");
        System.out.println("17 - SlideRule Pick Up");
        System.out.println("18 - Student Enters a Room that has a Teacher in it, and does not have Items");
        System.out.println("19 - Student Enters a Room that has a Teacher in it, and the TVSZ protects him");
        System.out.println("20 - Student Enters a Room that has a Teacher in it, and the GlassOfBeer protects him");
        System.out.println("21 - Student Enters a Room that has a Teacher in it, and the WetRag protects him");
        System.out.println("22 - Load Map");
        System.out.println("23 - Student's idle action");
        System.out.println("24 - Pick Up TVSZ");
        System.out.println("25 - Pick Up TVSZ, but the Student already has a TVSZ");

    }
}
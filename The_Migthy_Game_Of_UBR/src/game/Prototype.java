package game;

import game.characters.Character;
import game.characters.Cleaner;
import game.characters.Instructor;
import game.characters.Student;
import game.items.*;
import game.rooms.GasRoom;
import game.rooms.RegularRoom;
import game.rooms.Room;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.DigestException;
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

        if(args.length != 1){
            System.out.println("Invalid parameters...");
            return;
        }
        if(args[0].equals("-test")){
            //TODO Tesztek

            boolean exit = false;
            while(!exit){
                printTestOptions();
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
                        //Drop Item
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
                        //Cleaner Enters a Room with a Student and Stunned Instructor
                        System.out.println("Input: cleanerMove room1");
                        characterList.add(student);
                        characterList.add(instructor);
                        student.setCurrentRoom(regularRoom1);
                        instructor.setCurrentRoom(regularRoom1);
                        instructor.stun(2);
                        regularRoom1.setCharacters(characterList);

                        cleaner.setCurrentRoom(regularRoom2);
                        regularRoomList.add(regularRoom1);
                        regularRoom2.setListOfNeighbours(regularRoomList);
                        regularRoomList.clear();
                        regularRoomList.add(regularRoom2);
                        regularRoom1.setListOfNeighbours(regularRoomList);

                        regularRoom1.setMaxCharacter(5);
                        regularRoom1.setUniqueName("regularRoom1");
                        regularRoom2.setUniqueName("regularRoom2");
                        regularRoom2.setMaxCharacter(5);

                        cleaner.move(regularRoom2, regularRoom1);

                        break;

                    case 15:
                        //Cleaner Move
                        System.out.println("Input: cleanerMove gasRoom1");
                        regularRoomList.add(gasRoom);
                        regularRoom1.addNeighbours(regularRoomList);

                        cleaner.setCurrentRoom(regularRoom1);
                        cleaner.move(regularRoom1, gasRoom);
                        break;

                    case 16:
                        //Student Enters a Room that Becomes Sticky
                        System.out.println("Input: studentMove simpleMove room1");
                        regularRoom2.setStepCount(9);
                        //Student Move
                        regularRoomList.add(regularRoom2);
                        regularRoom1.addNeighbours(regularRoomList);

                        student.setCurrentRoom(regularRoom1);
                        student.move(regularRoom1, regularRoom2);

                        System.out.println("Input studentMove transistorJump room1");
                        regularRoom2.setStepCount(9);
                        regularRoom1.addTransistor(transistor1);
                        regularRoom2.addTransistor(transistor1);
                        student.setCurrentRoom(regularRoom1);
                        transistor1.setCurrentRoom(regularRoom1);
                        transistor2.setCurrentRoom(regularRoom2);
                        student.transistorJump();

                        break;

                    case 17:
                        //SlideRulePickUp
                        //TODO
                        break;

                    case 18:
                        //Student Enters a Room that has a Teacher in it, and does not have Items
                        System.out.println("Input: studentMove simpleMove room1");
                        instructor.setCurrentRoom(regularRoom2);
                        characterList.add(instructor);
                        regularRoom2.setCharacters(characterList);

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

                    case 19:
                        //Student Enters a Room that has a Teacher in it, and the TVSZ protects him
                        System.out.println("Input: studentMove simpleMove room1");
                        instructor.setCurrentRoom(regularRoom2);
                        characterList.add(instructor);
                        regularRoom2.setCharacters(characterList);

                        regularRoomList.add(regularRoom2);
                        regularRoom1.addNeighbours(regularRoomList);

                        student.setTVSZ(tvsz1);

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

                    case 20:
                        //Student Enters a Room that has a Teacher in it, and the GlassOfBeer protects him
                        System.out.println("Input: studentMove simpleMove room1");
                        instructor.setCurrentRoom(regularRoom2);
                        characterList.add(instructor);
                        regularRoom2.setCharacters(characterList);

                        regularRoomList.add(regularRoom2);
                        regularRoom1.addNeighbours(regularRoomList);

                        student.addItem(glassOfBeer);
                        glassOfBeer.activate();

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

                    case 21:
                        //Student Enters a Room that has a Teacher in it, and the WetRag protects him
                        System.out.println("Input: studentMove simpleMove room1");
                        instructor.setCurrentRoom(regularRoom2);
                        characterList.add(instructor);
                        regularRoom2.setCharacters(characterList);

                        regularRoomList.add(regularRoom2);
                        regularRoom1.addNeighbours(regularRoomList);

                        student.addItem(wetRag);

                        student.setCurrentRoom(regularRoom1);
                        student.move(regularRoom1, regularRoom2);

                        System.out.println("Input studentMove transistorJump room1");

                        student.addItem(wetRag);

                        regularRoom1.addTransistor(transistor1);
                        regularRoom2.addTransistor(transistor1);
                        student.setCurrentRoom(regularRoom1);
                        transistor1.setCurrentRoom(regularRoom1);
                        transistor2.setCurrentRoom(regularRoom2);
                        student.transistorJump();
                        break;

                    case 22:
                        //Load Map
                        //TODO

                        break;

                    case 23:
                        //Student's idle action

                        System.out.println("Input: idle");

                        student.idle();

                        break;

                    case 24:
                        //Pick Up TVSZ

                        System.out.println("Input: pickUpItem tvsz1");
                        regularRoom1.setMaxCharacter(5);
                        regularRoom1.addItem(tvsz1);
                        student.setCurrentRoom(regularRoom1);
                        student.setInventorySize(5);
                        student.pickUpItem(tvsz1);

                        break;

                    case 25:
                        //Pick Up TVSZ, but the Student already has a TVSZ

                        System.out.println("Input: pickUpItem tvsz1");
                        regularRoom1.setMaxCharacter(5);
                        regularRoom1.addItem(tvsz1);
                        student.setCurrentRoom(regularRoom1);
                        student.setInventorySize(5);

                        System.out.println("(For testing you have to add a TVSZ first, resulting in an extra line of output...)");
                        student.setTVSZ(tvsz2);

                        student.pickUpItem(tvsz1);


                }

            }

        }
        else{
            try {
                playerNumber = Integer.parseInt(args[0]);

                GameInitializer.initMaps("NEWMAP");
                System.out.println("Fileok Betöltve");

                GameInitializer.initCharacters(playerNumber);
                System.out.println("karakterek létrehozva");

                testPrint();

                gameController.play();

            }
            catch (NumberFormatException nfe){
                System.out.println("Invalid parameters...");
                return;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
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


    public static void testPrint() {
        for (Room i : gameController.getRooms()) {
            System.out.println(i.toString());
            for (Room j : i.getNeighbours()) {
                System.out.println("\t" + j.toString());
            }
            for (Item k : i.getItems()) {
                System.out.println("\t\t" + k.toString());
            }
            for (Character l : i.getCharacters()) {
                System.out.println("--- \t" + l.toString());
            }
        }
        System.out.println("\n\n");
        for (Character i : gameController.getListOfCharacters()) {
            System.out.println("+++");
            System.out.println(i.toString());
            System.out.println(i.getRoom().toString());
        }
    }

    public static void testPlay(int asd) {

        if (asd == 1 || asd == 69) {
            try {
                GameInitializer.initMaps("TESTMAP");
            } catch (IOException e) {
                System.out.println("Valami probléma van a fileokkal...");
            } catch (ClassNotFoundException e) {
                System.out.println("Hibás fileok...");
            }
            System.out.println("Beolvasás vége");
        } else if (asd == 0) {
            try {
                testMapBuilder(1);
            } catch (IOException e) {
                System.out.println("Hibás valami...");
            }
        }


        if (asd == 1 || asd == 69) {
            for (Room i : gameController.getRooms()) {
                System.out.println(i.toString());
                for (Room j : i.getNeighbours()) {
                    System.out.println("\t" + j.toString());
                }
                for (Item k : i.getItems()) {
                    System.out.println("\t\t" + k.toString());
                }
                for (Character l : i.getCharacters()) {
                    System.out.println("--- \t" + l.toString());
                }
            }
            System.out.println("\n\n");
            for (Character i : gameController.getListOfCharacters()) {
                System.out.println("+++");
                System.out.println(i.toString());
                System.out.println(i.getRoom().toString());
            }
        }


        if (asd == 69) {
            System.out.println("Play");
            gameController.play();
        }
    }

    public static void newMapBuilder(int mode) throws IOException {

        ////////// ROOMS INIT

        // Room1
        Room r1 = new RegularRoom();
        r1.setMaxCharacter(3);
        r1.setUniqueName("Room1");
        Item r1i1 = new TVSZ();
        r1i1.setUniqueName("tvsz1");
        r1i1.setDesc("TVSZ");
        r1.addItem(r1i1);

        // Room2
        Room r2 = new RegularRoom();
        r2.setUniqueName("Room2");

        // Room3
        Room r3 = new RegularRoom();
        r3.setUniqueName("Room3");
        Item r3i1 = new FakeFFP2();
        r3i1.setUniqueName("FakeTVSZ1");
        r3.addItem(r3i1);

        // Room4
        Room r4 = new RegularRoom();
        r4.setUniqueName("Room4");
        Item r4i1 = new FFP2();
        Item r4i2 = new Dice();
        r4i1.setUniqueName("FFP2_1");
        r4i2.setUniqueName("Dice1");
        r4.addItem(r4i1);
        r4.addItem(r4i2);

        // Room5
        Room r5 = new RegularRoom();
        r5.setUniqueName("Room5");
        Item r5i1 = new FakeSlideRule();
        r5i1.setUniqueName("FakeSideRuler1");
        r5.addItem(r5i1);

        // Room6
        Room r6 = new RegularRoom();
        r6.setUniqueName("Room6");
        Item r6i1 = new TVSZ();
        Item r6i2 = new FakeTVSZ();
        r6i1.setUniqueName("FakeTVSZ2");
        r6i2.setUniqueName("TVSZ2");
        r6.addItem(r6i1);
        r6.addItem(r6i2);

        // Room7
        Room r7 = new RegularRoom();
        r7.setUniqueName("Room7");
        Item r7i1 = new WetRag();
        Item r7i2 = new Camambert();
        r7i1.setUniqueName("WetRag1");
        r7i2.setUniqueName("Camambert1");
        r7.addItem(r7i1);
        r7.addItem(r7i2);

        // Room8
        Room r8 = new RegularRoom();
        r8.setUniqueName("Room8");
        Item r8i1 = new SlideRule();
        r8i1.setUniqueName("SideRuler");
        r8.addItem(r8i1);
        
        // Room9
        Room r9 = new RegularRoom();
        r9.setUniqueName("Room9");


        // Room10
        Room r10 = new RegularRoom();
        r10.setUniqueName("Room10");
        Item r10i1 = new GlassOfBeer();
        r10i1.setUniqueName("GlassOfBeer1");
        r10.addItem(r10i1);

        // Room11
        Room r11 = new RegularRoom();
        r11.setUniqueName("Room11");
        Item r11i1 = new AirFreshener();
        r11i1.setUniqueName("AirFreshener1");
        r11.addItem(r11i1);

        // Room12
        Room r12 = new RegularRoom();
        r12.setUniqueName("Room12");
        Item r12i1 = new Transistor();
        r12i1.setUniqueName("Transistor1");
        r12.addItem(r12i1);

        // Room13
        Room r13 = new RegularRoom();
        r13.setUniqueName("Room13");
        Item r13i1 = new Camambert();
        r13i1.setUniqueName("Camambert2");
        r13.addItem(r13i1);

        // Room14
        Room r14 = new RegularRoom();
        r14.setUniqueName("Room14");
        Item r14i1 = new Dice();
        r14i1.setUniqueName("Dice2");
        r14.addItem(r14i1);

        // Room15
        Room r15 = new RegularRoom();
        r15.setUniqueName("Room15");
        Item r15i1 = new Transistor();
        r15i1.setUniqueName("Transistor2");
        r15.addItem(r15i1);

        ////////// mapping
        r1.addNeighbour(r3);
        r1.addNeighbour(r9);
        r2.addNeighbour(r1);
        r2.addNeighbour(r6);
        r3.addNeighbour(r4);
        r3.addNeighbour(r6);
        r3.addNeighbour(r7);
        r4.addNeighbour(r3);
        r4.addNeighbour(r5);
        r5.addNeighbour(r4);
        r6.addNeighbour(r2);
        r7.addNeighbour(r11);
        r7.addNeighbour(r12);
        r8.addNeighbour(r15);
        r9.addNeighbour(r6);
        r9.addNeighbour(r10);
        r9.addNeighbour(r13);
        r10.addNeighbour(r6);
        r10.addNeighbour(r13);
        r10.addNeighbour(r11);
        r11.addNeighbour(r7);
        r11.addNeighbour(r12);
        r12.addNeighbour(r7);
        r12.addNeighbour(r8);
        r12.addNeighbour(r11);
        r12.addNeighbour(r14);
        r13.addNeighbour(r9);
        r14.addNeighbour(r11);
        r14.addNeighbour(r12);
        r15.addNeighbour(r8);
        r15.addNeighbour(r12);

        /////// Final list

        ArrayList<Room> finalList = new ArrayList<>();
        finalList.add(r1);
        finalList.add(r2);
        finalList.add(r3);
        finalList.add(r4);
        finalList.add(r5);
        finalList.add(r6);
        finalList.add(r7);
        finalList.add(r8);
        finalList.add(r9);
        finalList.add(r10);
        finalList.add(r11);
        finalList.add(r12);
        finalList.add(r13);
        finalList.add(r14);
        finalList.add(r15);


        /// Fileba írás
        System.out.println("Fileok");
        // generate files
        FileOutputStream mapFile = new FileOutputStream("NEWMAP_rooms.dat");
        ObjectOutputStream map = new ObjectOutputStream(mapFile);
        map.writeObject(finalList);
        map.flush();
        map.close();
    }

    // 10. beadáshoz test map
    // leírás: 2 játékos, 1 teacher, 1 cleaner, 7 szoba
    // Kiírja a mapot a TESTMAP_rooms.dat és TESTMAP_players.dat állományba
    public static void testMapBuilder(int mode) throws IOException {

        // játékosok:
        Student s1 = new Student();
        Student s2 = new Student();

        // NPC-k:
        Character npc1 = new Instructor();
        Character npc2 = new Cleaner();

        // startRoom:
        Room rs = new RegularRoom(); rs.setMaxCharacter(2);
        rs.setUniqueName("StartRoom");
        rs.putCharacter(s1);
        rs.putCharacter(s2);
        s1.setCurrentRoom(rs);
        s2.setCurrentRoom(rs);

        // Room1
        Room r1 = new RegularRoom(); r1.setMaxCharacter(4);
        r1.setUniqueName("Room1");
        TVSZ r1i1 = new TVSZ();  r1.addItem(r1i1);
        WetRag r1i2 = new WetRag(); r1i2.setWetness(3); r1.addItem(r1i2);

        // Room2
        Room r2 = new RegularRoom(); r2.setMaxCharacter(3);
        r2.setUniqueName("Room2");
        r2.putCharacter(npc1);
        npc1.setCurrentRoom(r2);

        // Room3
        Room r3 = new RegularRoom(); r3.setMaxCharacter(3);
        r3.setUniqueName("Room3");
        Camambert r3i1 = new Camambert(); r3.addItem(r3i1);
        GlassOfBeer r3i2 = new GlassOfBeer(); r3.addItem(r3i2);

        // Room4
        Room r4 = new RegularRoom(); r4.setMaxCharacter(3);
        r4.setUniqueName("Room4");
        r4.putCharacter(npc2);
        npc2.setCurrentRoom(r4);

        // Room5
        Room r5 = new RegularRoom(); r5.setMaxCharacter(3);
        r5.setUniqueName("Room5");
        FFP2 r5i1 = new FFP2(); r5i1.setDurability(3); r5.addItem(r5i1);

        // Room6
        Room r6 = new RegularRoom(); r6.setMaxCharacter(3);
        r6.setUniqueName("Room6");
        SlideRule r6i1 = new SlideRule(); r6.addItem(r6i1);

        // Mapping
        rs.addNeighbour(r1);
        r1.addNeighbour(r2);
        r1.addNeighbour(r3);
        r1.addNeighbour(r4);
        r2.addNeighbour(r1);
        r2.addNeighbour(r3);
        r4.addNeighbour(r1);
        r4.addNeighbour(r5);
        r5.addNeighbour(r4);
        r5.addNeighbour(r6);

        // generate finals
        ArrayList<Room> finalRooms = new ArrayList<>();
        ArrayList<Character> finalCharacters = new ArrayList<>();
        finalRooms.add(rs);
        finalRooms.add(r1);
        finalRooms.add(r2);
        finalRooms.add(r3);
        finalRooms.add(r4);
        finalRooms.add(r5);
        finalRooms.add(r6);
        finalCharacters.add(s1);
        finalCharacters.add(s2);
        finalCharacters.add(npc1);
        finalCharacters.add(npc2);

        if (mode == 1) {
            System.out.println("Fileok");
            // generate files
            FileOutputStream mapFile = new FileOutputStream("TESTMAP_rooms.dat");
            FileOutputStream charFile = new FileOutputStream("TESTMAP_players.dat");
            ObjectOutputStream map = new ObjectOutputStream(mapFile);
            ObjectOutputStream chars = new ObjectOutputStream(charFile);
            map.writeObject(finalRooms);
            map.flush();
            map.close();
            chars.writeObject(finalCharacters);
            chars.flush();
            chars.close();
        } else if (mode == 0) {
            for (Room i : finalRooms) {
                gameController.addRoom(i);
            }
            for (Character i : finalCharacters) {
                gameController.addCharacter(i);
            }
        }


    }

    // előző beadásokhoz test esetek kiírása
    public static void tests() {
        boolean end = false;

        //Students
        Student testS1 = new Student();
        Student testS2 = new Student();
        Student testS3 = new Student();

        //Instructors
        Instructor testI1 = new Instructor();
        Instructor testI2 = new Instructor();
        Instructor testI3 = new Instructor();
        Instructor testI4 = new Instructor();

        //Rooms
        Room testR1 = new RegularRoom();
        Room testR2 = new RegularRoom();
        Room testR3 = new RegularRoom();

        //Items
        Camambert testCam = new Camambert();
        Dice testDice = new Dice();
        FFP2 testFFP = new FFP2();
        GlassOfBeer testGOB = new GlassOfBeer();
        SlideRule testSR = new SlideRule();
        Transistor testT1 = new Transistor();
        Transistor testT2 = new Transistor();
        TVSZ testTVSZ = new TVSZ();
        WetRag testWR = new WetRag();

        while(!end){
            System.out.println("1-Move");
            System.out.println("2-Character Goes To Character");
            System.out.println("3-Drop Item");
            System.out.println("4-Use Item");
            System.out.println("5-Pick Up Item");
            System.out.println("6-Idle Action");
            System.out.println("7-Merge Rooms");
            System.out.println("8-Split Room");
            System.out.println("9-Attack Item Effect");
            System.out.println("0-Exit\n");
            System.out.println("Valassz egy menupontot: ");
            int selectedMain;
            Scanner sc = new Scanner(System.in);
            selectedMain = Integer.parseInt(sc.next());

            //Main select
            switch (selectedMain){

                //Exit
                case 0:{
                    end = true;
                    continue;
                }

                //Move
                case 1:{
                    System.out.println("1-Student Move");
                    System.out.println("2-Instructor Move\n");
                    System.out.println("Valassz egy al-menupontot: ");
                    int selectedMove1;
                    Scanner sc2 = new Scanner(System.in);
                    selectedMove1 = Integer.parseInt(sc2.next());

                    //Select move1
                    switch (selectedMove1){

                        //Student Move
                        case 1:{
                            System.out.println("1-Transistor Jump");
                            System.out.println("2-Simple Move\n");
                            System.out.println("Valassz egy al-al-menupontot: ");
                            int selectedMove2;
                            Scanner sc3 = new Scanner(System.in);
                            selectedMove2 = Integer.parseInt(sc3.next());

                            //Select move2
                            switch(selectedMove2){

                                //Transistor Jump
                                case 1:{
                                    testS1.transistorJump();
                                    break;
                                }

                                //Simple move
                                case 2:{
                                    System.out.println("--> (testS1: Student).move(testR1: Room, testR2: Room)");
                                    testS1.move(testR1, testR2);
                                    System.out.println("<--");
                                    break;
                                }
                            }
                            break;
                        }

                        //Instructor move
                        case 2:{
                            System.out.println("--> (testI1: Instructor).move(testR1: Room, testR2: Room)");
                            testI1.move(testR1, testR2);
                            System.out.println("<--");
                            break;
                        }
                    }
                    break;
                }

                //Character Goes To Character
                case 2:{
                    System.out.println("1-Instructor Goes To Student");
                    System.out.println("2-Student Goes To Instructor\n");
                    System.out.println("Valassz egy al-menupontot: ");
                    int selectedCGTC;
                    Scanner sc4 = new Scanner(System.in);
                    selectedCGTC = Integer.parseInt(sc4.next());

                    //Select Character Goes To Character
                    switch (selectedCGTC){

                        //Instructor Goes To Student
                        case 1:{
                            testS1.meet(testI1);
                            break;
                        }

                        //Student Goes To Student
                        case 2:{
                            testI1.meet(testS1);
                            break;
                        }

                    }
                    break;
                }

                //Drop Item
                case 3:{
                    System.out.println("1-Drop GlassOfBeer");
                    System.out.println("2-Drop Dice");
                    System.out.println("3-Drop FFP2");
                    System.out.println("4-Drop TVSZ");
                    System.out.println("5-Drop Transistor");
                    System.out.println("6-Drop WetRag");
                    System.out.println("7-Drop Camambert\n");
                    System.out.println("Valassz egy menupontot: ");
                    int selectedItemToDrop;
                    Scanner sc5 = new Scanner(System.in);
                    selectedItemToDrop = Integer.parseInt(sc5.next());

                    //Select Item
                    switch(selectedItemToDrop){

                        //GlassOfBeer
                        case 1:{
                            System.out.println("-->(testS1: Student).dropItem(testGOB)");
                            testS1.dropItem(testGOB);
                            System.out.println("<--");
                            break;
                        }

                        //Dice
                        case 2:{
                            System.out.println("-->(testS1: Student).dropItem(testDice)");
                            testS1.dropItem(testDice);
                            System.out.println("<--");
                            break;
                        }

                        //FFP2
                        case 3:{
                            System.out.println("-->(testS1: Student).dropItem(testFFP)");
                            testS1.dropItem(testFFP);
                            System.out.println("<--");
                            break;
                        }

                        //TVSZ
                        case 4:{
                            System.out.println("-->(testS1: Student).dropItem(testTVSZ)");
                            testS1.dropItem(testGOB);
                            System.out.println("<--");
                            break;
                        }

                        //Transistor
                        case 5:{
                            System.out.println("-->(testS1: Student).dropItem(testT)");
                            testS1.dropItem(testT1);
                            System.out.println("<--");
                            break;
                        }

                        //WetRag
                        case 6:{
                            System.out.println("-->(testS1: Student).dropItem(testWR)");
                            testS1.dropItem(testWR);
                            System.out.println("<--");
                            break;
                        }

                        //Camambert
                        case 7:{
                            System.out.println("-->(testS1: Student).dropItem(testCam)");
                            testS1.dropItem(testCam);
                            System.out.println("<--");
                            break;
                        }

                    }
                    break;
                }

                //Use Item
                case 4:{
                    System.out.println("1-Use GlassOfBeer");
                    System.out.println("2-Use Dice");
                    System.out.println("3-Use FFP2");
                    System.out.println("4-Use Transistor");
                    System.out.println("5-Use WetRag");
                    System.out.println("6-Use Camambert\n");
                    System.out.println("Valassz egy menupontot: ");
                    int selectedItemToUse;
                    Scanner sc6 = new Scanner(System.in);
                    selectedItemToUse = Integer.parseInt(sc6.next());

                    //Select Item
                    switch(selectedItemToUse){

                        //GlassOfBeer
                        case 1:{
                            System.out.println("--> (testS1: Student).useItem(testGOB: GlassOfBeer)");
                            testS1.useItem(testGOB);
                            System.out.println("<--");
                            break;
                        }

                        //Dice
                        case 2:{
                            System.out.println("--> (testS1: Student).useItem(testDice: Dice)");
                            testS1.useItem(testDice);
                            System.out.println("<--");
                            break;
                        }

                        //FFP2
                        case 3:{
                            System.out.println("--> (testS1: Student).useItem(testFFP: FFP2)");
                            testS1.useItem(testFFP);
                            System.out.println("<--");
                            break;
                        }

                        //Transistor
                        case 4:{
                            System.out.println("--> (testS1: Student).useItem(testT1: Transistor)");
                            testS1.useItem(testT1);
                            System.out.println("<--");
                            break;
                        }

                        //WetRag
                        case 5:{
                            System.out.println("--> (testS1: Student).useItem(testWR: WetRag)");
                            testS1.useItem(testWR);
                            System.out.println("<--");
                            break;
                        }

                        //Camambert
                        case 6:{
                            System.out.println("--> (testS1: Student).useItem(testCam: Camambert)");
                            testS1.useItem(testCam);
                            System.out.println("<--");
                            break;
                        }

                    }
                    break;
                }

                //Pick Up Item
                case 5:{
                    System.out.println("1-Pick Up GlassOfBeer");
                    System.out.println("2-Pick Up Dice");
                    System.out.println("3-Pick Up FFP2");
                    System.out.println("4-Pick Up TVSZ");
                    System.out.println("5-Pick Up SlideRule");
                    System.out.println("6-Pick Up Transistor");
                    System.out.println("7-Pick Up WetRag");
                    System.out.println("8-Pick Up Camambert");
                    System.out.println("Valassz egy menupontot: ");
                    int selectedItemToPickUp;
                    Scanner sc7 = new Scanner(System.in);
                    selectedItemToPickUp = Integer.parseInt(sc7.next());

                    //Select Item
                    switch(selectedItemToPickUp) {

                        //GlassOfBeer
                        case 1: {
                            System.out.println("--> (testS1: Student).pickUpItem(testGOB: GlassOfBeer)");
                            testS1.pickUpItem(testGOB);
                            System.out.println("<--");
                            break;
                        }

                        //Dice
                        case 2: {
                            System.out.println("--> (testS1: Student).pickUpItem(testDice: Dice)");
                            testS1.pickUpItem(testDice);
                            System.out.println("<--");
                            break;
                        }

                        //FFP2
                        case 3: {
                            System.out.println("--> (testS1: Student).pickUpItem(testFFP: FFP2)");
                            testS1.pickUpItem(testFFP);
                            System.out.println("<--");
                            break;
                        }

                        //TVSZ
                        case 4: {


                            System.out.println("--> (testS1: Student).pickUpItem(testTVSZ: TVSZ)");
                            testS1.pickUpItem(testTVSZ);
                            System.out.println("<--");

                            break;
                        }

                        //SlideRule
                        case 5: {

                            System.out.println("--> (testS1: Student).pickUpItem(testSR: SlideRule)");
                            testS1.pickUpItem(testSR);
                            System.out.println("<--");

                            break;
                        }

                        //Transistor
                        case 6: {
                            System.out.println("--> (testS1: Student).pickUpItem(testT1: Transistor)");
                            testS1.pickUpItem(testT1);
                            System.out.println("<--");

                            break;
                        }

                        //WetRag
                        case 7: {
                            System.out.println("--> (testS1: Student).pickUpItem(testWR: WetRag)");
                            testS1.pickUpItem(testWR);
                            System.out.println("<--");
                            break;
                        }

                        //Camambert
                        case 8:{
                            System.out.println("--> (testS1: Student).pickUpItem(testCam: Camambert)");
                            testS1.pickUpItem(testCam);
                            System.out.println("<--");
                            break;
                        }
                    }
                    break;
                }

                //Idle Action
                case 6:{
                    testS1.idle();
                    break;
                }

                //Merge Rooms
                case 7:{
                    gameController.mergeRooms(testR1, testR2);
                    break;
                }

                //Split Room
                case 8:{
                    gameController.slpitRoom(testR1);
                    break;
                }

                //AttackItem
                case 9:{
                    System.out.println("1-Attack TVSZ Effect");
                    System.out.println("2-Attack WetRag Effect");
                    System.out.println("3-Attack GlassOfBeer Effect\n");
                    System.out.println("Valassz egy menupontot: ");
                    int selectedAttack;
                    Scanner sc8 = new Scanner(System.in);
                    selectedAttack = Integer.parseInt(sc8.next());

                    //Pick Item
                    switch (selectedAttack){

                        //TVSZ Attack Effect
                        case 1: {
                            testTVSZ.onAttacked(testS1, testI1);
                            break;
                        }

                        //WetRag Attack Effect
                        case 2: {
                            testWR.onAttacked(testS1, testI2);
                            break;
                        }

                        //GlassOfBeer Attack Effect
                        case 3: {
                            testGOB.onAttacked(testS1, testI1);
                            break;
                        }
                    }

                    break;
                }
            }
            System.out.println("Press enter to continue..");
            Scanner con = new Scanner(System.in);
            if(con.hasNextLine()){
                continue;
            }
        }
    }
}
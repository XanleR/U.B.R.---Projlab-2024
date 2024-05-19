package game;

import game.characters.Character;
import game.characters.Cleaner;
import game.characters.Instructor;
import game.characters.Student;
import game.graphical.GameFrame;
import game.graphical.ItemView;
import game.items.*;
import game.rooms.GasRoom;
import game.rooms.RegularRoom;
import game.rooms.Room;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GUI {

    public static GameController gameController;
    public static GameInitializer gameInitializer;
    public static GameFrame gameFrame = GameFrame.getInstance();

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

        try {
            playerNumber = Integer.parseInt(args[0]);
            if(playerNumber < 2 || playerNumber > 5){

                System.out.println("Invalid Input");
                return;
            }


//            try {
//                newMapBuilder();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            gameFrame.initFrame();


            try {
                GameInitializer.initMaps("NEWMAP");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            //System.out.println("Fileok Betöltve");

            try {
                GameInitializer.initCharacters(playerNumber);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            //System.out.println("karakterek létrehozva");

            //testPrint();

            //gameController.play();


        }
        catch (NumberFormatException nfe){
            System.out.println("Invalid parameters...");
            return;
        }
//        catch (IOException | ClassNotFoundException e){
//            throw new RuntimeException(e);
//        }
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
        int c = 0;
        for (Room i : gameController.getRooms()) {
            c++;
            System.out.println( c  + " - " + i.toString());
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

    public static void newMapBuilder() throws IOException {

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
        r2.setMaxCharacter(3);
        r2.setUniqueName("Room2");

        // Room3
        Room r3 = new RegularRoom();
        r3.setMaxCharacter(3);
        r3.setUniqueName("Room3");
        Item r3i1 = new FakeFFP2();
        r3i1.setUniqueName("FakeFFP2");
        r3.addItem(r3i1);

        // Room4
        Room r4 = new RegularRoom();
        r4.setMaxCharacter(3);
        r4.setUniqueName("Room4");
        Item r4i1 = new FFP2();
        Item r4i2 = new Dice();
        r4i1.setUniqueName("FFP2_1");
        r4i2.setUniqueName("Dice1");
        r4.addItem(r4i1);
        r4.addItem(r4i2);

        // Room5
        Room r5 = new RegularRoom();
        r5.setMaxCharacter(3);
        r5.setUniqueName("Room5");
        Item r5i1 = new FakeSlideRule();
        r5i1.setUniqueName("FakeSideRuler1");
        r5.addItem(r5i1);

        // Room6
        Room r6 = new RegularRoom();
        r6.setMaxCharacter(3);
        r6.setUniqueName("Room6");
        Item r6i1 = new TVSZ();
        Item r6i2 = new FakeTVSZ();
        r6i1.setUniqueName("FakeTVSZ2");
        r6i2.setUniqueName("TVSZ2");
        r6.addItem(r6i1);
        r6.addItem(r6i2);

        // Room7
        Room r7 = new RegularRoom();
        r7.setMaxCharacter(3);
        r7.setUniqueName("Room7");
        Item r7i1 = new WetRag();
        Item r7i2 = new Camambert();
        r7i1.setUniqueName("WetRag1");
        r7i2.setUniqueName("Camambert1");
        r7.addItem(r7i1);
        r7.addItem(r7i2);

        // Room8
        Room r8 = new RegularRoom();
        r8.setMaxCharacter(3);
        r8.setUniqueName("Room8");
        Item r8i1 = new SlideRule();
        r8i1.setUniqueName("SideRuler");
        r8.addItem(r8i1);
        
        // Room9
        Room r9 = new RegularRoom();
        r9.setMaxCharacter(3);
        r9.setUniqueName("Room9");


        // Room10
        Room r10 = new RegularRoom();
        r10.setMaxCharacter(3);
        r10.setUniqueName("Room10");
        Item r10i1 = new GlassOfBeer();
        r10i1.setUniqueName("GlassOfBeer1");
        r10.addItem(r10i1);

        // Room11
        Room r11 = new RegularRoom();
        r11.setMaxCharacter(3);
        r11.setUniqueName("Room11");
        Item r11i1 = new AirFreshener();
        r11i1.setUniqueName("AirFreshener1");
        r11.addItem(r11i1);

        // Room12
        Room r12 = new RegularRoom();
        r12.setMaxCharacter(3);
        r12.setUniqueName("Room12");
        Item r12i1 = new Transistor();
        r12i1.setUniqueName("Transistor1");
        r12.addItem(r12i1);

        // Room13
        Room r13 = new RegularRoom();
        r13.setMaxCharacter(3);
        r13.setUniqueName("Room13");
        Item r13i1 = new Camambert();
        r13i1.setUniqueName("Camambert2");
        r13.addItem(r13i1);

        // Room14
        Room r14 = new RegularRoom();
        r14.setMaxCharacter(3);
        r14.setUniqueName("Room14");
        Item r14i1 = new Dice();
        r14i1.setUniqueName("Dice2");
        r14.addItem(r14i1);

        // Room15
        Room r15 = new RegularRoom();
        r15.setMaxCharacter(3);
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
}
package game;

import game.characters.Instructor;
import game.characters.Student;
import game.items.*;
import game.rooms.RegularRoom;
import game.rooms.Room;

import java.io.IOException;
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

            printTestOptions();
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
        System.out.println("1 - Student Move");
        System.out.println("2 - Teacher Move");
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
package game;

import game.characters.Instructor;
import game.characters.Student;
import game.items.*;
import game.rooms.RegularRoom;
import game.rooms.Room;

import java.io.IOException;
import java.util.Scanner;

public class Skeleton {

    public static GameController gameController;

    public static void main(String[] args) throws IOException {

        boolean end = false;

        gameController = GameController.getInstance();
        GameController gameController2 = GameController.getInstance();

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
import model.*;
import java.util.Scanner;
import java.util.Random;

import java.util.ArrayList;

public class TestBots {
    private static boolean makeBot;
    private static boolean cloneBot;
    private ArrayList<Entity> entities=new ArrayList<>();
    private Scanner input;
    private int killerNum;
    private int wallNum;
    private int reproNum;
    private void getNumBots()
    {
        input = new Scanner(System.in);
        System.out.println("How many Killer Bot?");
        killerNum = input.nextInt();
        System.out.println("How many Wall Bot?");
        wallNum = input.nextInt();
        System.out.println("How many Reproduction Bot?");
        reproNum = input.nextInt();
    }
    private void createBots()
    {
        //killer
        for (int i = 0; i < killerNum; i++)
    }
        public static void main(String[] args) {




            entities.add(new KillerBot(new Location(0,3), 1, Movable.Directions.RIGHT, Movable.FAST_SPEED));
            entities.add(new WallMaker(new Location(0,4), 2, Movable.Directions.RIGHT, Movable.SLOW_SPEED));
            entities.add(new WallMaker(new Location(0,7), 3, Movable.Directions.RIGHT, Movable.SLOW_SPEED));

            // Reproduction Bot object
            entities.add(new ReproductionBot(new Location(6, 0), 8, Movable.Directions.RIGHT, Movable.SLOW_SPEED));

            System.out.println(entities);
            System.out.println(entities.size());

            Map m = new Map(entities);

            m.printMap();


            // KillerBot kb = (KillerBot) m.removeBotFromMap(((KillerBot) entities.get(3)));

//            f.move(m);
//            m.putBotOnMap(f);
//            m.printMap();

            // First move
//            ((FlexBot) entities.get(0)).move(m);
//            ((FlexBot) entities.get(1)).move(m);
            if(entities.size() >= 1) {
                if(((KillerBot) entities.get(0)).move(m)) {
                    System.out.println("1st moved");
                } else {
                    System.out.println("1st didn't move");
                    WallMaker wm = (WallMaker) m.removeBotFromMap(((WallMaker) entities.get(1)));
                    m.removeBotFromMap(wm);
                    entities.remove(wm);
                    ((KillerBot) entities.get(0)).move(m);

                }
            }

            if(entities.size() >= 2) {
                if(((WallMaker) entities.get(1)).move(m)) {
                    System.out.println("2nd moved");
                    makeBot = true;
                } else {
                    System.out.println("2nd didn't move");
                }
            }

            if(entities.size() >= 3) {
                if(((ReproductionBot) entities.get(2)).move(m)) {
                    System.out.println("3rd moved");

                } else {
                    System.out.println("3rd didn't move");
                    cloneBot = true;
                }
            }

//            ((WallBot) entities.get(4)).move(m);
//            ((WallMaker) entities.get(5)).move(m);

            if(makeBot) {
                entities.add(new WallBot(new Location(0, 7), 4, Movable.Directions.RIGHT));
                makeBot = false;
            }

            if(cloneBot) {
                entities.add(new WallBot(new Location(7, 0), 4, Movable.Directions.RIGHT));
                cloneBot = false;
            }

            m.updateMap();
            m.printMap();

            System.out.println(entities);
            System.out.println(entities.size());
        }
    }

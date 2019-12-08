package model;

import java.util.ArrayList;

public class BotMap {
    public static int NUM_ROWS=10, NUM_COLS=10;
    private int[][] map;
    ArrayList<Bot> botList;

    public BotMap(ArrayList<Bot> bots){
        map=new int[NUM_ROWS][NUM_COLS];
        botList=bots;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public ArrayList<Bot> getBotList() {
        return botList;
    }

    public void setBotList(ArrayList<Bot> botList) {
        this.botList = botList;
    }
}

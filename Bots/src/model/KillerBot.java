package model;

public class KillerBot extends FlexBot {
    public Location loc;
    public int id;
    public Directions dir;
    public int moveSpeed;

    public KillerBot(Location loc, int id, Directions dir, int moveSpeed) {
        super(loc, id, dir, moveSpeed);
        this.loc = loc;
        this.id = id;
        this.dir = dir;
        this.moveSpeed = moveSpeed;
    }

    @Override
    public boolean move(Map m) {
        // return super.move(m);

        boolean moved=super.move(m);

        if(!moved) {
            System.out.println("in Killer move here..");
            System.out.println(loc);
            System.out.println(id);
            return false;
        }
        return true;
    }

    public void killTheBot(Map m, Bot b) {
        Directions[] allDirs= Directions.values();
        Directions nextDir = allDirs[(dir.ordinal()+2) % allDirs.length];
        m.removeBotFromMap(b);
    }
}

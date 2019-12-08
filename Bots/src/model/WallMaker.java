package model;

public class WallMaker extends FlexBot {
    public WallMaker(Location loc, int id, Directions dir, int moveSpeed) {
        super(loc, id, dir, moveSpeed);
    }

    @Override
    public boolean move(Map m) {
        boolean moved=super.move(m);

        if(moved) {
            System.out.println("put wall bots");
            return true;
        }
        return false;
    }
}

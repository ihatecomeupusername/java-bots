package model;

public class ReproductionBot extends FlexBot {
    Location location;
    int i = 0;
    Movable.Directions right;
    int slowSpeed;

    public ReproductionBot(Location loc, int id, Movable.Directions dir, int moveSpeed) {
        super(loc, id, dir, moveSpeed);
        this.location = loc;
        this.i = id;
        this.right = dir;
        this.slowSpeed = moveSpeed;
    }

    @Override
    public boolean move(Map m) {
        return super.move(m);
    }
}

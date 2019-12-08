package model;

public class WallBot extends Bot {
    /**
     * initialize all instance variables.
     * The model.Bot has a model.Location, id, direction, and moveSpeed
     *
     * @param l
     * @param id
     * @param dir
     */
    public WallBot(Location l, int id, Directions dir) {
        super(l, id, dir);
    }

    @Override
    public void counterTurn() {

    }

    @Override
    public boolean move(Map m) {
        // wall bot don't move
        return false;
    }
}

package model;

public class FlexBot extends Bot{

    public FlexBot(Location loc, int id, Directions dir, int moveSpeed){
        super(loc, id, dir);
        setMoveSpeed(moveSpeed);
    }
    @Override
    public boolean move(Map m){
        boolean moved=super.move(m);
        int spacesToMove=getMoveSpeed();
        int turnCount=0;
        int distance=distanceToEntityOrEdge(m);
        System.out.println("DIstance: "+distance);
        //do flex move
        if(!moved){
            System.out.println("In flex move here");
            while(spacesToMove>0&&turnCount<4) {
                if(distance==0){
                    System.out.println("turned");
                    turn();
                    turnCount++;
                }//turned
                else{
                    if(spacesToMove>=distance){
                        moveNumSpaces(distance,m);
                        spacesToMove-=distance;
                        System.out.println("Moved: "+distance);
                    }
                    else{
                        moveNumSpaces(spacesToMove,m);
                        System.out.println("Moved: "+spacesToMove);
                        spacesToMove-=spacesToMove;
                    }
                    turnCount=0;
                }//moved
                distance=distanceToEntityOrEdge(m);
            }//end while
            moved=turnCount<4;
        }

        return moved;
    }


    public int distanceToEntityOrEdge(Map m){
        int distance=getMoveSpeed();
        int count=0;
        boolean pathClear=true;

        if(distance>=botDistanceFromEdge()){
            distance=botDistanceFromEdge();
        }
        while (pathClear && count < distance) {
            switch(getDirection()){
                case UP:{
                    if(validCell(m,getLoc().getRow() - count - 1,getLoc().getCol())){
                        System.out.println("counted: "+count);
                        count++;
                    }
                    else{
                        pathClear=false;
                    }
                    break;
                }
                case DOWN:{
                    if(validCell(m,getLoc().getRow() + count + 1,getLoc().getCol())){
                        System.out.println("counted: "+count);
                        count++;
                    }
                    else{
                        pathClear=false;
                    }
                    break;
                }
                case LEFT:{
                    if(validCell(m, getLoc().getRow(),getLoc().getCol() - count - 1)){
                        System.out.println("counted: "+count);
                        count++;
                    }
                    else{
                        pathClear=false;
                    }
                    break;
                }
                case RIGHT:{
                    if(validCell(m,getLoc().getRow(),getLoc().getCol() + count + 1)){
                        System.out.println("counted: "+count);
                        count++;
                    }
                    else{
                        pathClear=false;
                    }
                    break;
                }
            }
//
//            if (getDirection() == Directions.UP) {
//                pathClear = m.getBotMap()[getLoc().getRow() - count - 1][getLoc().getCol()] == null;
//                count++;
//            } else if (getDirection() == Directions.DOWN) {
//                pathClear = m.getBotMap()[getLoc().getRow() + count + 1][getLoc().getCol()] == null;
//                count++;
//            } else if (getDirection() == Directions.LEFT) {
//                pathClear = m.getBotMap()[getLoc().getRow()][getLoc().getCol() - count - 1] == null;
//                count++;
//            } else if (getDirection() == Directions.RIGHT) {
//                pathClear = m.getBotMap()[getLoc().getRow()][getLoc().getCol() + count + 1] == null;
//                count++;
//            }
        }//end while

        System.out.println("return des edge:" +count);
        return count;
    }

    private boolean validCell(Map m, int i, int col) {
        return false;
    }

    public void speedUp(int spdVal){
        setMoveSpeed(getMoveSpeed()+spdVal);
    }

    public void speedDown(int spdVal){
        if(getMoveSpeed()-spdVal<0){
            setMoveSpeed(0);
        }
        else {
            setMoveSpeed(getMoveSpeed() - spdVal);
        }
    }

    @Override
    public void counterTurn() {
        if(getDirection().compareTo(Directions.UP)>0){
            setDirection(Movable.getPreviousDirection(getDirection()));
        }
        else{
            setDirection(Directions.LEFT);
        }
    }
}
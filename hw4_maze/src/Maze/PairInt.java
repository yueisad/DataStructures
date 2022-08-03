package Maze;

public class PairInt {
    private int x;
    private int y;

    public PairInt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y; 
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(PairInt p) {
        if (p.getX() == this.x && p.getY() == this.y) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "("+x+","+y+")";    
    }

    public PairInt copy() {
        return new PairInt(x,y);
    }
}

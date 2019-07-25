
package character;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    

    public void updateX(int n) {
        x += n;
    }
    
    public void updateY(int n) {
        y += n;
    }
    
    public boolean isPosition(int x, int y) {
        return this.x == x && this.y == y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    
}

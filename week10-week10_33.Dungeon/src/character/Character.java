
package character;

public abstract class Character {

    private Position pos;
    private char symbol;

    public Character(Position position, char symbol) {
        this.pos = position;
        this.symbol = symbol;
    }

    public Position getPos() {
        return pos;
    }

    public char getSymbol() {
        return symbol;
    }
    
    public void setPos(Position position) {
        this.pos = position;
    }
    
    public abstract void move(int x, int y);
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        Character other = (Character) obj;
        return this.getPos().equals(other.getPos());
    }

    @Override
    public int hashCode() {
        return pos.hashCode();
    }
    
    @Override
    public String toString() {
        return symbol + " " + pos;
    }
   
}

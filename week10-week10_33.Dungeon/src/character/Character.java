
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
    
    @Override
    public String toString() {
        return symbol + " " + pos;
    }
   
}

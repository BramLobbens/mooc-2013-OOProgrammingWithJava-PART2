package character;

import character.Character;

public class Player extends Character {

    public Player(char symbol) {
        super(new Position(0, 0), symbol);
    }

    public void up() {
        super.getPos().updateY(-1);
    }
    
    public void down() {
        super.getPos().updateY(1);
    }
    
    public void left() {
        super.getPos().updateX(-1);
    }
    
    public void right() {
        super.getPos().updateX(1);
    }
}

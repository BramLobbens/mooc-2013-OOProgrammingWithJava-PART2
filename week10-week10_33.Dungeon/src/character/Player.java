package character;

import character.Character;

public class Player extends Character {

    public Player(char symbol) {
        super(new Position(0, 0), symbol);
    }
    
    @Override
    public void move(int x, int y) {
        super.getPos().setX(super.getPos().getX() + x);
        super.getPos().setY(super.getPos().getY() + y);
    }
}

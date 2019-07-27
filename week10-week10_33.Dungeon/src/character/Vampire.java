
package character;

import character.Position;
import character.Character;
import java.util.Random;

public class Vampire extends Character {

    public Vampire(int x, int y, char symbol) {
        // vampire cannot be at player start position
        super(new Position(new Random().nextInt(x - 1) + 1, new Random().nextInt(y - 1) + 1), symbol);
    }

    @Override
    public void move(int x, int y) {
        super.getPos().setX(new Random().nextInt(x - 1) + 1);
        super.getPos().setY(new Random().nextInt(y - 1) + 1);
    }
    
}

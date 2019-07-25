
package character;

import character.Position;
import character.Character;
import java.util.Random;

public class Vampire extends Character {

    public Vampire(int x, int y, char symbol) {
        // vampire cannot be at player start position
        super(new Position(new Random().nextInt(x - 1) + 1, new Random().nextInt(y - 1) + 1), symbol);
    }

    
}

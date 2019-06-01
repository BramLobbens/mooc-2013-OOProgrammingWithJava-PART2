package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

public class Packer {

    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();
        Box box = new Box(boxesVolume);

        for (Thing thing : things) {
            if (!box.addThing(thing)) {
                // if full: add box to list and make new box.
                // add thing to the new box
                boxes.add(box);
                box = new Box(boxesVolume);
                box.addThing(thing);
            }
        }
        // add final box that was not over capacity
        boxes.add(box);
        return boxes;
    }
}

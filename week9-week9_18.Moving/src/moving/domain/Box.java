package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing {

    private int maximumCapacity;
    private List<Thing> things;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.things = new ArrayList<Thing>();
    }

    @Override
    public int getVolume() {
        int volume = 0;
        for (Thing thing : things) {
            volume += thing.getVolume();
        }
        return volume;
    }

    public boolean addThing(Thing thing) {
        if (this.getVolume() + thing.getVolume() > this.maximumCapacity) {
            return false;
        } else {
            things.add(thing);
            return true;
        }
    }

    @Override
    public String toString() {
        String contains = "Box contains: ";
        for (Thing thing : things) {
            // no leading comma for first item
            if (thing.equals(things.get(0))) {
                contains += thing;
            }
            else {
                contains += ", " + thing;
            }
        }
        return contains;
    }
    
}

package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {

    private int maxWeight;
    private List<Thing> things;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        things = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        if (thing.getWeight() <= maxWeight) {
            things.add(thing);
            maxWeight -= thing.getWeight();
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if (thing == null) {
            return false;
        }
        return things.contains(thing);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Box contains:\n");
        for (Thing thing : things) {
            sb.append(thing + "\n");
        }
        return sb.toString();
    }
}

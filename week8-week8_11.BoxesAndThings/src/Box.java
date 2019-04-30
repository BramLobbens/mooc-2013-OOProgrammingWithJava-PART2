import java.util.ArrayList;
import java.util.List;

public class Box implements ToBeStored {

    private double maxWeight;
    private List<ToBeStored> things;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<ToBeStored>();
    }

    public void add(ToBeStored item) {
        if (this.weight() + item.weight() <= maxWeight) {
            things.add(item);
        }
    }

    @Override
    public double weight() {
        double weight = 0;
        for (ToBeStored thing : things) {
            weight += thing.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + things.size() + " things, total weight " + 
                this.weight() + " kg";
    }
    
    
}

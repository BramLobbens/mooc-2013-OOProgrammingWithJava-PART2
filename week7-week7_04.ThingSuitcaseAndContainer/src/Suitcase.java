import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Thing> things;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        things = new ArrayList<Thing>();
    }
    
    public int totalWeight() {
        int sum = 0;
        for (Thing thing : things) {
            sum += thing.getWeight();
        }
        return sum;
    }
    
    public void addThing(Thing thing) {
        if (thing.getWeight() <= maxWeight - totalWeight()) {
            things.add(thing);
        }
    }
    
    public void printThings() {
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }
    
    public Thing heaviestThing() {
        Thing heaviest = (!things.isEmpty()) ? things.get(0) : null;
        for (Thing thing : things) {
            if (thing.getWeight() > heaviest.getWeight()) {
                heaviest = thing;
            }
        }
        return heaviest;
    }

    @Override
    public String toString() {
        
        String numOf = "";
        switch (things.size()) {
            case 0:
                numOf = "empty";
                break;
            case 1:
                numOf = "" + things.size() + " thing";
                break;
            default:
                numOf = "" + things.size() + " things";
                break;
        }
        
        return  numOf + " (" + totalWeight() + " kg)";
    }
    
}

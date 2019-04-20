import java.util.ArrayList;

public class Container {

    private int maxWeight;
    private ArrayList<Suitcase> suitcases;

    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        suitcases = new ArrayList<Suitcase>();
    }
    
    public int totalWeight() {
        int sum = 0;
        for (Suitcase suitcase : suitcases) {
            sum += suitcase.totalWeight();
        }
        return sum;
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if (suitcase.totalWeight() <= maxWeight - totalWeight()) {
            suitcases.add(suitcase);
        }
    }
    
    public void printThings() {
        for (Suitcase suitcase : suitcases) {
            suitcase.printThings();
        }
    }

    @Override
    public String toString() {
        return suitcases.size() + " suitcases (" + totalWeight() + " kg)";
    }
    
}

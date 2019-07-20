
package containers;

public class ProductContainerRecorder extends ProductContainer {
    
    private ContainerHistory record;

    public ProductContainerRecorder(String productName, double tilavuus, double initialVolume) {
        super(productName, tilavuus);
        record = new ContainerHistory();
        this.addToTheContainer(initialVolume);
    }
    
    @Override
    public void addToTheContainer(double amount) {
        // Attention: you have to record the product volume in the container
        // after the addition, not the amount which was added! 
        super.addToTheContainer(amount);
        record.add(this.getVolume());
    }
    
    @Override
    public double takeFromTheContainer(double amount) {
        double taken = super.takeFromTheContainer(amount);
        record.add(this.getVolume());
        return taken;
    }
    
    public String history() {
        return record.toString();
    }
    
    public void printAnalysis() {
        System.out.println(
                "Product: " + this.getName() + "\n" +
                "History: " + this.history() + "\n" +
                "Greatest product amount: " + this.record.maxValue() + "\n" +
                "Smallest product amount: " + this.record.minValue() + "\n" +
                "Average: " + this.record.average() + "\n" +
                "Greatest change: " + this.record.greatestFluctuation() + "\n" +
                "Variance: " + this.record.variance()
        );
    }
}

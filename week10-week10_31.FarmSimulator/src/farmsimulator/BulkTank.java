
package farmsimulator;

public class BulkTank {

    private double capacity;
    private double volume;

    public BulkTank() {
        capacity = 2000.0;
        volume = 0.0;
    }

    public BulkTank(double capacity) {
        if (capacity > 0.0) {
            this.capacity = capacity;
        }
        else {
            this.capacity = 0.0;
        }
        volume = 0.0;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return volume;
    }
    
    public double howMuchFreeSpace() {
        return capacity - volume;
    }
    
    public void addToTank(double amount) {
        if (amount < 0.0) {
            return;
        }
        if (amount > howMuchFreeSpace()) {
            volume = capacity;
        }
        else {
            volume += amount;
        }
    }
    
    public double getFromTank(double amount) {
        if (amount < 0.0) {
            return 0.0;
        }
        if (amount > volume) {
            double getFromTank = volume;
            volume = 0.0;
            return getFromTank;
        }
        volume -= amount;
        return amount;
    }

    @Override
    public String toString() {
        return Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
    
    
}

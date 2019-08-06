
public class Calculator {

    private int value;
    
    public Calculator() {
        value = 0;
    }
    
    public void add(int val) {
        value += val;
    }
    
    public void subtract(int val) {
        value -= val;
    }

    public void reset() {
        value = 0;
    }

    public int getValue() {
        return value;
    }
    
    
}

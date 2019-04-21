import java.util.HashMap;

public class PromissoryNote {

    private HashMap<String, Double> notes;

    public PromissoryNote() {
        this.notes = new HashMap<String, Double>();
    }
    
    public void setLoan(String toWhom, double value) {
        this.notes.put(toWhom, value);
    }
    
    public double howMuchIsTheDebt(String whose) {
        if (this.notes.containsKey(whose)) {
            return this.notes.get(whose);
        }
        else {
            return 0.0;
        }
    }
}

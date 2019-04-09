import java.util.ArrayList;

public class Changer {

    private ArrayList<Change> changes;

    public Changer() {
        changes = new ArrayList<Change>();
    }
    
    public void addChange(Change change) {
        // add a new Change to Changer
        changes.add(change);
    }
    
    public String change(String characterString) {
        // execute all added Changes for the charstring
        // in the order of their adding
        // return the changed character string
        String changed = characterString;
        for (Change c : changes) {
            changed = c.change(changed);
        }
        return changed;
    }
}

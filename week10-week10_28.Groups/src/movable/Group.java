
package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {

    private List<Movable> members;

    public Group() {
        this.members = new ArrayList<Movable>();
    }
    
    public void addToGroup(Movable movable) {
        this.members.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable e : this.members) {
            e.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (Movable e : this.members) {
            output += e + "\n";
        }
        return output;
    }
    
}

package boxes;

public class BlackHoleBox extends Box {

    public BlackHoleBox() {
    }

    @Override
    public void add(Thing thing) {
        // adds to a black-hole box
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }

    @Override
    public String toString() {
        return "Box contains: nothing";
    }
}

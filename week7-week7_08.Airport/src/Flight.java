
public class Flight {

    private Airplane airplane;
    private String orig;
    private String dest;

    public Flight(Airplane airplane, String orig, String dest) {
        this.airplane = airplane;
        this.orig = orig;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return this.airplane.getId() + " (" + this.airplane.getCapacity() + 
                " ppl) (" + this.orig + "-" + this.dest + ")";
    }
}

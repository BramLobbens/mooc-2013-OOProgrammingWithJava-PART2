
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Participant implements Comparable<Participant> {

    private String name;
    private int points;
    private List<Integer> distances;

    public Participant(String name, int points) {
        this.name = name;
        this.points = points;
        this.distances = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
    
    public void givePoints(int score) {
        points += score;
    }

    public List<Integer> getDistances() {
        return distances;
    }
    
    public int jump() {
        Random rand = new Random();
        int min = 60;
        int max = 120;
        int distance = min + rand.nextInt(max - min);
        this.distances.add(distance);
        return distance;
    }
    
    public int getLastJump() {
        return distances.get(distances.size() - 1);
    }
    
    @Override
    public int compareTo(Participant o) {
        return this.points - o.points;
    }
    
    @Override
    public String toString() {
        return name + " (" + points + " points)";
    }
    
}

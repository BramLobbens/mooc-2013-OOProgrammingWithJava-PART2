
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {

    private Map<Bird, List<String>> observations;
    // unrequired code for exercise
//    private Map<Bird, Integer> observationCount;

    public RingingCentre() {
        this.observations = new HashMap<Bird, List<String>>();
        // unrequired code for exercise
//        this.observationCount = new HashMap<Bird, Integer>();
    }

    public void observe(Bird bird, String place) {

        this.observations.putIfAbsent(bird, new ArrayList<String>());
        this.observations.get(bird).add(place);

        // unrequired code for exercise
//        if (this.observationCount.containsKey(bird)) {
//            int numOccurrence = this.observationCount.get(bird);
//            // careful: use prefix increment operator!
//            this.observationCount.put(bird, ++numOccurrence);
//        }
//        else {
//            this.observationCount.putIfAbsent(bird, 1);
//        }

    }

    public void observations(Bird bird) {

        // unrequired code for exercise
//        System.out.print(bird + "observations: ");
//        if (this.observationCount.containsKey(bird)) {
//            System.out.println(this.observationCount.get(bird));
//        } else {
//            System.out.println("0");
//        }

        int observationCount = (this.observations.containsKey(bird)) ? this.observations.get(bird).size() : 0;
        System.out.println(bird + "observations: " + observationCount);

        if (!this.observations.containsKey(bird)) {
            return;
        }
        
        for (String place : this.observations.get(bird)) {
            System.out.println(place);
        }
    }
}

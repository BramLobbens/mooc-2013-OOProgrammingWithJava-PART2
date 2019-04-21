
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Records {

    private List<Flight> flights;
    private Map<String, Airplane> airplanes;
    
    public Records() {
        this.flights = new ArrayList<Flight>();
        this.airplanes = new HashMap<String, Airplane>();
    }
    
    public void addFlight(String plane, String orig, String dest) {
        Airplane p = this.airplanes.get(plane);
        Flight flight = new Flight(p, orig, dest);
        this.flights.add(flight);
    }
    
    public void addAirplane(String plane, int capacity) {
        Airplane p = new Airplane(plane, capacity);
        this.airplanes.put(p.getId(), p);
    }
    
    public void printFlights() {
        for (Flight flight : this.flights) {
            System.out.println(flight);
        }
    }
    
    public void printPlanes() {
        for (String key : this.airplanes.keySet()) {
            System.out.println(airplanes.get(key));
        }
    }
    
    public void printPlaneInfo(String airplane) {
        System.out.println(airplanes.get(airplane));
    }
}

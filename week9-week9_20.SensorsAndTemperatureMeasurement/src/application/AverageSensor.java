package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }
    
    @Override
    public void on() {
        // other sensors are turned on
        for (Sensor s : sensors) {
            s.on();
        }
    }

    @Override
    public void off() {
        // other sensors are turned off
        for (Sensor s : sensors) {
            s.off();
        }
    }

    @Override
    public boolean isOn() {
        // contains active sensors
        for (Sensor s : sensors) {
            if (s.isOn()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int measure() {
        // Average sensor is on and added sensors exist
        if (sensors.size() > 0) {
            int measurements = 0;
            for (Sensor s : sensors) {
                measurements += s.measure();
            }
            int avg = measurements / sensors.size();
            readings.add(avg);
            return avg;
        }
        else {
            throw new IllegalArgumentException("Average sensor is off, or no sensors available");
        }
    }
    
    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }
    
    public List<Integer> readings() {
        return readings;
    }
}

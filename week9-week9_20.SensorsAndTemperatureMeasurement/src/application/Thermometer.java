package application;

import java.util.Random;

public class Thermometer implements Sensor {

    private boolean onState;

    public Thermometer() {
        onState = false;
    }
    
    @Override
    public void on() {
        onState = true;
    }

    @Override
    public void off() {
        onState = false;
    }

    @Override
    public boolean isOn() {
        return onState;
    }

    @Override
    public int measure() {
        if (isOn()) {
            return new Random().nextInt(60) - 30;
        }
        else {
            throw new IllegalStateException("Thermometer is turned off");
        }
    }

}

package application;

public class ConstantSensor implements Sensor {

    private int number;

    public ConstantSensor(int number) {
        this.number = number;
    }

    // cannot be turned off
    @Override
    public void on() {
    }

    @Override
    public void off() {
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public int measure() {
        return number;
    }

}

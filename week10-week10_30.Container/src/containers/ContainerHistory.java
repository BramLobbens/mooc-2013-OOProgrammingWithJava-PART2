package containers;

import java.util.ArrayList;
import java.util.List;

public class ContainerHistory {

    private List<Double> record;

    public ContainerHistory() {
        record = new ArrayList<Double>();
    }

    // adds the parameter situation to the end of the container history
    public void add(double situation) {
        record.add(situation);
    }

    //it deletes the container history records
    public void reset() {
        record.clear();
    }

    // returns the greatest value in the container history. 
    // If the history is empty, the method returns 0.
    public double maxValue() {
        if (record.isEmpty()) {
            return 0.0;
        }
        double max = record.get(0);
        for (double e : record) {
            if (e > max) {
                max = e;
            }
        }
        return max;
    }

    // returns the smallest value in the container history. 
    // If the history is empty, the method returns 0.
    public double minValue() {
        if (record.isEmpty()) {
            return 0.0;
        }
        double min = record.get(0);
        for (double e : record) {
            if (e < min) {
                min = e;
            }
        }
        return min;
    }

    // returns the average of the values in the container history. 
    // If the history is empty, the method returns 0.
    public double average() {
        if (record.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (double e : record) {
            sum += e;
        }
        return sum / record.size();
    }

    // returns the absolute value of the single greatest fluctuation in the
    // container history (attention: a fluctuation of -5 is greater than 4)
    public double greatestFluctuation() {
        if (record.size() <= 1) {
            return 0.0;
        }
        double previousRecord = record.get(0);
        double biggest = 0.0;
        for (double e : record) {
            double difference = Math.abs(previousRecord - e);
            if (difference > biggest) {
                biggest = difference;
            }
            previousRecord = e;
        }
        return biggest;
    }

    // returns the sample variance of the container history values
    public double variance() {
        if (record.size() <= 1) {
            return 0.0;
        }
        double variance = 0.0;
        for (double e : record) {
            variance += Math.pow(e - average(), 2);
        }
        return variance / (record.size() - 1);
    }

    // returns the container history in the form of a String. The String form 
    // given by the ArrayList class is fine and doesn't have to be modified.
    @Override
    public String toString() {
        if (record.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        for (Double situation : record) {
            sb.append(situation.toString()).append(", ");
        }
        // delete final comma
        return "[" + sb.deleteCharAt(sb.length() - 2).toString().trim() + "]";
    }

}

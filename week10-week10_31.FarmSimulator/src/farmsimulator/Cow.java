package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive {

    private String name;
    private double capacity;
    private double amount;

    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this(NAMES[new Random().nextInt(NAMES.length)]);
    }

    public Cow(String name) {
        this.name = name;
        capacity = 15 + new Random().nextInt(26);
        amount = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public double milk() {
        double takeAll = amount;
        amount = 0.0;
        return takeAll;
    }

    // We simulate this by producing 0.7-2 litres every hour
    @Override
    public void liveHour() {
        double produced = 0.7 + (2.0 - 0.7) * new Random().nextDouble();
        if (amount + produced > capacity) {
            amount += (capacity - amount);
            return;
        }
        amount += produced;
    }

    @Override
    public String toString() {
        return name + " " + Math.ceil(amount) + "/" + Math.ceil(capacity);
    }

}

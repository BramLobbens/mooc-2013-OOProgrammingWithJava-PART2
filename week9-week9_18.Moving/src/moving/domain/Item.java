package moving.domain;

public class Item implements Thing, Comparable<Item> {
    private String name;
    private int volume;

    public Item(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.volume + " dm^3)";
    }

    /*@Override
    public int compareTo(Thing o) {
        return this.getVolume() - o.getVolume();
    }*/
    
    public int compareTo(Item o) {
        return this.getVolume() - o.getVolume();
    }
    
}

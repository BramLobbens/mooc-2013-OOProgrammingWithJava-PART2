
public class Main {
    
    public static void addSuitcasesFullOfBricks(Container container) {

        for (int i = 0; i < 100; i++) {
            Thing brick = new Thing("brick", i + 1);
            Suitcase suitcase = new Suitcase(100);
            suitcase.addThing(brick);
            container.addSuitcase(suitcase);
        }
    }
    
    public static void main(String[] args) {

        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }

}

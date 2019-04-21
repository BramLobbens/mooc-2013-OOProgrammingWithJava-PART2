import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        String input = "1\n" + "AY-123\n" + "108\n" + 
                "x\n" + "1\n" + "x\n";
        
        Scanner reader = new Scanner(input);
        Records database = new Records();
        
        TextUserInterface ui = new TextUserInterface(reader, database);
        ui.start();
    }
}

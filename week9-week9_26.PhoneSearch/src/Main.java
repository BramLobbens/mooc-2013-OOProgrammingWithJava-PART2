import java.util.Scanner;
import phonebook.Phonebook;
import ui.TextUserInterface;
import ui.UserInterface;

public class Main {

    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        Phonebook phonebook = new Phonebook();
        UserInterface ui = new TextUserInterface(reader, phonebook);
        
        ui.start();
    }
}

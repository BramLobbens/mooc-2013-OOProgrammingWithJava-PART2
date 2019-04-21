
import java.util.Scanner;

public class TextUserInterface {

    private Scanner reader;
    private Dictionary dict;

    public TextUserInterface(Scanner reader, Dictionary dict) {
        this.reader = reader;
        this.dict = dict;
    }

    public void start() {

        System.out.println("Statement: ");
        System.out.println("\tadd - adds a word pair to the dictionary");
        System.out.println("\ttranslate - asks a word and prints its translation");
        System.out.println("\tquit - quit the text user interface");
        System.out.println("");

        while (true) {
            System.out.print("Statement: ");
            String input = this.reader.nextLine();

            if (input.toLowerCase().equals("quit")) {
                break;
            }

            handleStatement(input);
            System.out.println("");
        }
        
        System.out.println("Cheers!");
    }

    private void handleStatement(String statement) {

        if (statement.toLowerCase().equals("add")) {
            add();
        } else if (statement.toLowerCase().equals("translate")) {
            translate();
        } else {
            System.out.println("Unknown statement");
        }
    }

    private void add() {
        System.out.print("In Finnish: ");
        String word = this.reader.nextLine();
        System.out.print("Translation: ");
        String translation = this.reader.nextLine();
        this.dict.add(word, translation);
    }

    private void translate() {
        System.out.print("Give a word: ");
        String word = this.reader.nextLine();
        
        if (this.dict.translate(word) == null) {
            System.out.println("Unknown word!");
        } else {
            System.out.println("Translation: " + this.dict.translate(word));
        }
    }
}

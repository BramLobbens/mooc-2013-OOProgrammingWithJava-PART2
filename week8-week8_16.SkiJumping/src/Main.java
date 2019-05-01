
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Tournament skijump = new Tournament();

        UserInterface ui = new UserInterface(reader, skijump);
        ui.start();
    }
}

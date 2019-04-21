
import java.util.Scanner;

public class TextUserInterface {

    private Scanner reader;
    private Records db;

    public TextUserInterface(Scanner reader, Records db) {
        this.reader = reader;
        this.db = db;
    }

    public void start() {
        airportPanel();
        flightPanel();
    }

    private void airportPanel() {

        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");

        while (true) {

            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            System.out.print("> ");
            String input = this.reader.nextLine();

            if (input.toLowerCase().equals("x")) {
                break;
            }

            handleStatementAirportPanel(input);

        }
        System.out.println("");
    }

    private void flightPanel() {

        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");

        while (true) {

            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            System.out.print("> ");
            String input = this.reader.nextLine();

            if (input.toLowerCase().equals("x")) {
                break;
            }

            handleStatementFlightPanel(input);
            System.out.println("");
        }

    }

    private void handleStatementAirportPanel(String statement) {

        if (statement.equals("1")) {
            addAirplane();
        } else if (statement.equals("2")) {
            addFlight();
        } else {
            System.out.println("Unknown statement");
        }
    }

    private void handleStatementFlightPanel(String statement) {

        if (statement.equals("1")) {
            printPlanes();
        } else if (statement.equals("2")) {
            printFlights();
        } else if (statement.equals("3")) {
            printPlaneInfo();
        } else {
            System.out.println("Unknown statement");
        }
    }

    private void addAirplane() {
        System.out.print("Give plane ID: ");
        String plane = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        db.addAirplane(plane, capacity);
    }

    private void addFlight() {
        System.out.print("Give plane ID: ");
        String plane = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String dep = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String dest = reader.nextLine();
        db.addFlight(plane, dep, dest);
    }

    private void printPlanes() {
        db.printPlanes();
    }

    private void printFlights() {
        db.printFlights();
    }

    private void printPlaneInfo() {
        System.out.print("Give plane ID: ");
        String plane = reader.nextLine();
        db.printPlaneInfo(plane);
    }
}

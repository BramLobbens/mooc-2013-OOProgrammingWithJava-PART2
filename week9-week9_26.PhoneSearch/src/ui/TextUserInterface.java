package ui;

import java.util.Scanner;
import java.util.Set;
import phonebook.Phonebook;

public class TextUserInterface implements UserInterface {

    private Scanner reader;
    private Phonebook phonebook;

    public TextUserInterface(Scanner reader, Phonebook phonebook) {
        this.reader = reader;
        this.phonebook = phonebook;
    }

    private void prompt() {
        System.out.println("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit");
    }

    @Override
    public void start() {
        prompt();

        while (true) {
            System.out.print("\ncommand: ");
            String input = reader.nextLine();
            if (input.toLowerCase().equals("x")) {
                break;
            }

            try {
                handleCommand(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid command");
            }
        }

    }

    private void handleCommand(String input) throws NumberFormatException {
        switch (Integer.parseInt(input)) {
            case 1:
                addNumber();
                break;
            case 2:
                searchNumber();
                break;
            case 3:
                searchPersonByNumber();
                break;
            default:
                break;
        }
    }

    private void addNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();

        phonebook.addNumber(name, number);
    }

    private void searchNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        try {
            Set<String> numbers = phonebook.getNumber(name);
            for (String number : numbers) {
                System.out.println(" " + number);
            }
        } catch (Exception e) {
            System.out.println("  not found");
        }
    }
    
    private void searchPersonByNumber() {
        System.out.print("number: ");
        String number = reader.nextLine();
        System.out.println(phonebook.getPerson(number));
    }

}

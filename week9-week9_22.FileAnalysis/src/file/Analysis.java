package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Analysis {

    private File file;

    public Analysis(File file) {
        this.file = file;
    }

    public int lines() {
        int count = 0;
        Scanner reader = null;
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                count++;
                reader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. " + e.getMessage());
        }
        reader.close();
        return count;
    }
    
    public int characters() {
        int count = 0;
        Scanner reader = null;
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                // count 1 extra to include the newline char
                count += reader.nextLine().length() + 1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. " + e.getMessage());
        }
        reader.close();
        return count;
    }
    
    // Java 7 <=
    /*
    public int lines() {
        int count = 0;
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                count++;
                reader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. " + e.getMessage());
        }
        return count;
    }
    
    public int characters() {
        int count = 0;
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                // count 1 extra to include the newline char
                count += reader.nextLine().length() + 1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. " + e.getMessage());
        }
        return count;
    }
    */
}

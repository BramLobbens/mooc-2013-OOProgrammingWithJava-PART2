import java.io.File;
import java.util.Scanner;

public class Printer {

    private File file;

    public Printer(String fileName) throws Exception {
        file = new File(fileName);
    }

    public void printLinesWhichContain(String word) {
        // pre Java 7 solution
        /*Scanner reader = null;
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.contains(word)) {
                    System.out.println(line);
                }
            }
        }
        catch (Exception e) {
            System.out.println("File not found. " + e.getMessage());
        }
        reader.close();
        */
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.contains(word)) {
                    System.out.println(line);
                }
            }
        }
        catch (Exception e) {
            System.out.println("File not found. " + e.getMessage());
        }
        
    }
}

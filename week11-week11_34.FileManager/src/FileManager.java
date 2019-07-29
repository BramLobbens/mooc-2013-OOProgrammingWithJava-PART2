
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        File f = new File(file);
        List<String> lines = new ArrayList<>();
        
        try (Scanner reader = new Scanner(f)) {
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

    public void save(String file, String text) throws IOException {
        try (FileWriter w = new FileWriter(file)) {
            w.write(text);
        }
    }

    public void save(String file, List<String> texts) throws IOException {
        try (FileWriter w = new FileWriter(file)) {
            for (String text : texts) {
                w.write(text  + "\n");
            }
        }
    }
}

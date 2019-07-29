
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
        List<String> lines = new ArrayList<String>();
        Scanner reader = null;
        
        try {
            reader = new Scanner(f);
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        reader.close();
        return lines;
    }

    public void save(String file, String text) throws IOException {
        FileWriter t = new FileWriter(file);
        t.write(text + "\n");
        t.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter t = new FileWriter(file);
        for (String text : texts) {
            t.write(text  + "\n");
        }
        t.close();
    }
}

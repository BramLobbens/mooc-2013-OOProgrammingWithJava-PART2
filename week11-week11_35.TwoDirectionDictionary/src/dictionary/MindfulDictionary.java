package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MindfulDictionary {

    private Map<String, String> words = new HashMap<>();
    private File file;

    public MindfulDictionary() {
    }

    public MindfulDictionary(String file) {
        this.file = new File(file);
    }

    public void add(String word, String translation) {
        words.putIfAbsent(word, translation);
    }

    public String translate(String word) {
        // return the value
        if (words.containsKey(word)) {
            return words.get(word);
        // return the key
        } else if (words.containsValue(word)) {
            for (String key : words.keySet()) {
                if (words.get(key).equals(word)) {
                    return key;
                }
            }
        }
        return null;
    }

    public void remove(String word) {
        if (words.containsKey(word)) {
            words.remove(word);
        } else if (words.containsValue(word)) {
            for (String key : words.keySet()) {
                if (words.get(key).equals(word)) {
                    words.remove(key);
                    break;
                }
            }
        }
    }
    
    public boolean load() {
        if (file == null) {
            return false;
        }
        
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");
                add(parts[0], parts[1]);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean save() {
        try (FileWriter writer = new FileWriter(file)) {
            for (Entry entry : words.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        return true;
    }
}

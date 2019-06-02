package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {

    private File file;

    public WordInspection(File file) {
        this.file = file;
        // read the file
        lines();
    }

    private List<String> lines() {
        List<String> lines = new ArrayList<String>();
        Scanner reader = null;
        try {
            reader = new Scanner(file, "UTF-8");
            while (reader.hasNextLine()) {
                String word = reader.nextLine();
                lines.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. " + e.getMessage());
        }
        reader.close();
        return lines;
    }

    private String reverseStr(String word) {
        String reversed = "";
        for (int i = 0; i < word.length(); i++) {
            reversed += word.charAt(word.length() - i - 1);
        }
        return reversed;
    }

    private boolean isPalindrome(String word) {
        return word.equalsIgnoreCase(reverseStr(word));
    }

    public int wordCount() {
        // Assume that each word is on a new line
        return lines().size();
    }

    public List<String> wordsContainingZ() {
        List<String> found = new ArrayList<String>();
        for (String l : lines()) {
            if (l.contains("z")) {
                found.add(l);
            }
        }
        return found;
    }

    public List<String> wordsEndingInL() {
        List<String> found = new ArrayList<String>();
        for (String l : lines()) {
            if (l.endsWith("l")) {
                found.add(l);
            }
        }
        return found;
    }

    public List<String> palindromes() {
        List<String> found = new ArrayList<String>();
        for (String l : lines()) {
            if (isPalindrome(l)) {
                found.add(l);
            }
        }
        return found;
    }

    public List<String> wordsWhichContainAllVowels() {
        // Vowels to contain.
        String vowels = "aeiouyäö";
        List<String> found = new ArrayList<String>();
        
        // Keep track of unique vowels in word.
        // Compare length of vowels to length of the vowels to be found.
        for (String l : lines()) {
            String vowelsInWord = "";
            for (char c : l.toCharArray()) {
                if (!(vowels.indexOf(c) < 0) && !vowelsInWord.contains("" + c)) {
                    vowelsInWord += c;
                }
            }
            if (vowelsInWord.length() == vowels.length()) {
                found.add(l);
            }
        }
        return found;
    }
}

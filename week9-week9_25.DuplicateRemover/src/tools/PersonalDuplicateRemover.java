
package tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {

    private List<String> characterStrings;
    private Set<String> uniqueCharacterStrings;
    
    public PersonalDuplicateRemover() {
        this.characterStrings = new ArrayList<String>();
        this.uniqueCharacterStrings = new HashSet<String>();
    }

    @Override
    public void add(String characterString) {
        this.characterStrings.add(characterString);
        if (!this.uniqueCharacterStrings.contains(characterString)) {
                this.uniqueCharacterStrings.add(characterString);
            }
    }

    @Override
    public void empty() {
        this.characterStrings.clear();
        this.uniqueCharacterStrings.clear();
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        int detectedDuplicates = 0;
        int pos = 0;
        for (String s : this.characterStrings) {
            if (pos < this.characterStrings.lastIndexOf(s)) {
                detectedDuplicates++;
            }
            pos++;
        }
        return detectedDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.uniqueCharacterStrings;
    }
    
    
}

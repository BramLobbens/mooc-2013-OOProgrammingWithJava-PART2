
package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {

    private Set<String> uniqueCharacterStrings = new HashSet<String>();
    private int numberOfDuplicates;

    @Override
    public void add(String characterString) {
        boolean added = uniqueCharacterStrings.add(characterString);
        if (!added) {
            numberOfDuplicates++;
        }
    }

    @Override
    public void empty() {
        this.uniqueCharacterStrings.clear();
        numberOfDuplicates = 0;
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return numberOfDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return uniqueCharacterStrings;
    }
    
    
}

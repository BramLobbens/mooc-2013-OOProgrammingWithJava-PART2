package phonebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phonebook {

    private Map<String, Set<String>> phoneNumbers;

    public Phonebook() {
        this.phoneNumbers = new HashMap<String, Set<String>>();
    }
    
    public void addNumber(String person, String phoneNumber) {
        if (!phoneNumbers.containsKey(person)) {
            phoneNumbers.put(person, new HashSet<String>());
        }
        phoneNumbers.get(person).add(phoneNumber);
    }
    
    public Set<String> getNumber(String person) {
        return phoneNumbers.get(person);
    }
    
    public String getPerson(String phoneNumber) {
        for (String entry : phoneNumbers.keySet()) {
            if (phoneNumbers.get(entry).contains(phoneNumber)) {
                return entry;
            }
        }
        return "not found";
    }
    
}

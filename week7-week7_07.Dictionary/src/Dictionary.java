import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    
    private Map<String, String> dict;
    
    public Dictionary() {
        this.dict = new HashMap<String, String>();
    }
    
    public String translate(String word) {
        return this.dict.get(word);
    }
    
    public void add(String word, String translation) {
        this.dict.put(word, translation);
    }
    
    public int amountOfWords() {
        return this.dict.size();
    }
    
    public List<String> translationList() {
        List<String> list = new ArrayList<String>();
        for (String key : this.dict.keySet()) {
            list.add(key + " = " + this.dict.get(key));
        }
        return list;
    }
}

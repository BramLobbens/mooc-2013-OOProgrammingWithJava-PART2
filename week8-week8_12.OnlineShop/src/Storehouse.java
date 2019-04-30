import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storehouse {

    private Map<String, Integer> products;
    private Map<String, Integer> stocks;

    public Storehouse() {
        products = new HashMap<String, Integer>();
        stocks = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock) {
        products.put(product, price);
        stocks.put(product, stock);
    }
    
    public int price(String product) {
        return products.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return stocks.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        if (stocks.containsKey(product) && stocks.get(product) > 0) {
            stocks.put(product, stocks.get(product) - 1);
            return true;
        }
        return false;
    }
    
    public Set<String> products() {
        return products.keySet();
    }
}

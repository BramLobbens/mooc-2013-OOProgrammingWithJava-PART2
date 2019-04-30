
import java.util.HashMap;
import java.util.Map;


public class ShoppingBasket {

    private Map<String, Purchase> purchases;

    public ShoppingBasket() {
        purchases = new HashMap<String, Purchase>();
    }
    
    public void add(String product, int price) {
        
        // update Purchase product by 1 if already in purchases
        if (purchases.containsKey(product)) {
            purchases.get(product).increaseAmount(); // key returns Product which we can call increaseAmount() on
        }
        else { // create new Purchase product and add to purchases
            purchases.put(product, new Purchase(product, 1, price));
        }
    }
    
    public int price() {
        int price = 0;
        for (Purchase purchase : purchases.values()) {
            price += purchase.price();
        }
        return price;
    }
    
    public void print() {
        for (Purchase purchase : purchases.values()) {
            System.out.println(purchase);
        }
    }
}

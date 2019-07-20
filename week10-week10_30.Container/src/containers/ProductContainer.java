
package containers;

public class ProductContainer extends Container {

    private String name;

    public ProductContainer(String productName, double tilavuus) {
        super(tilavuus);
        this.name = productName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + super.toString();
    }
    
    
    
}

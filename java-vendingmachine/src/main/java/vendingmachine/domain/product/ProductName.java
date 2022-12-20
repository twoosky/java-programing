package vendingmachine.domain.product;

public class ProductName {
    private String name;

    public ProductName(String name) {
        this.name = name;
    }

    public boolean isEqual(String name) {
        return this.name.equals(name);
    }
}

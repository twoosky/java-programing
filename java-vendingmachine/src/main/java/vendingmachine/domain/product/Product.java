package vendingmachine.domain.product;

public class Product {
    private final ProductName name;
    private final ProductPrice price;
    private final ProductQuantity quantity;

    public Product(String name, String price, String quantity) {
        this.name = new ProductName(name);
        this.price = new ProductPrice(price);
        this.quantity = new ProductQuantity(quantity);
    }

    public boolean isEqualName(String productName) {
        return name.isEqual(productName);
    }

    public boolean isOutOfStock() {
        return quantity.isOutOfStock();
    }

    public boolean isMoneyLessThanPrice(int money) {
        return price.isMoneyLessThanPrice(money);
    }

    public void decreaseQuantity() {
        quantity.decrease();
    }

    public ProductPrice getPrice() {
        return price;
    }
}

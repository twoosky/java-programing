package vendingmachine.domain.product;

import java.util.List;

public class Product {
    private ProductName name;
    private ProductPrice price;
    private ProductQuantity quantity;

    public Product(List<String> productInfo) {
        this.name = new ProductName(productInfo.get(0));
        this.price = new ProductPrice(productInfo.get(1));
        this.quantity = new ProductQuantity(productInfo.get(2));
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

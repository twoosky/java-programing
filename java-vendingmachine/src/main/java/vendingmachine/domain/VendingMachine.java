package vendingmachine.domain;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductPrice;
import vendingmachine.domain.product.Products;

public class VendingMachine {
    private final Products products;

    public VendingMachine(Products products) {
        this.products = products;
    }

    public ProductPrice buyProduct(String productName) {
        Product product = products.getProductByName(productName);
        product.decreaseQuantity();
        return product.getPrice();
    }

    public boolean isBuyable(Money money) {
        return !(isMoneyLessThanPrice(money.getMoney()) || isOutOfStock());
    }

    private boolean isOutOfStock() {
        return products.isOutOfStock();
    }

    private boolean isMoneyLessThanPrice(int money) {
        return products.isMoneyLessThanPrice(money);
    }
}

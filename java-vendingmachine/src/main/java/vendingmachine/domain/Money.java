package vendingmachine.domain;

import vendingmachine.domain.product.ProductPrice;

import static vendingmachine.utils.ErrorMessages.INVALID_UNIT_CONSUMER_MONEY;

public class Money {
    private int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateUnit(money);
    }

    private void validateUnit(int money) {
        if ((money % 10) != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_CONSUMER_MONEY);
        }
    }

    public boolean isMoneyGreaterThenAmount(Coin coin) {
        return money >= coin.getCount();
    }

    public void buyProduct(ProductPrice price) {
        money -= price.getPrice();
    }

    public int getMoney() {
        return money;
    }
}

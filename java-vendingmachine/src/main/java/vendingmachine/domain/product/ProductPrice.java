package vendingmachine.domain.product;

import vendingmachine.utils.IntegerConvertor;

import static vendingmachine.utils.ErrorMessages.*;

public class ProductPrice {
    private final int price;

    public ProductPrice(String input) {
        int price = IntegerConvertor.parseInt(input, NOT_INTEGER_PRODUCT_AMOUNT);
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        validateRange(price);
        validateUnit(price);
    }

    private void validateRange(int price) {
        if (price < 100) {
            throw new IllegalArgumentException(OUT_OF_RANGE_PRODUCT_AMOUNT);
        }
    }

    private void validateUnit(int price) {
        if ((price % 10) != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_PRODUCT_AMOUNT);
        }
    }

    public int getPrice() {
        return price;
    }

    public boolean isMoneyLessThanPrice(int money) {
        return price > money;
    }
}

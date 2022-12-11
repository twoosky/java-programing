package vendingmachine.domain.product;

import vendingmachine.utils.IntegerConvertor;

import static vendingmachine.utils.ErrorMessages.*;

public class ProductAmount {
    private final int amount;

    public ProductAmount(String input) {
        int amount = IntegerConvertor.parseInt(input, NOT_INTEGER_PRODUCT_AMOUNT);
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateRange(amount);
        validateUnit(amount);
    }

    private void validateRange(int amount) {
        if (amount < 100) {
            throw new IllegalArgumentException(OUT_OF_RANGE_PRODUCT_AMOUNT);
        }
    }

    private void validateUnit(int amount) {
        if ((amount % 10) != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_PRODUCT_AMOUNT);
        }
    }
}

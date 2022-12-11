package vendingmachine.domain.product;

import static vendingmachine.utils.ErrorMessages.INVALID_UNIT_PRODUCT_AMOUNT;
import static vendingmachine.utils.ErrorMessages.OUT_OF_RANGE_PRODUCT_AMOUNT;

public class ProductAmount {
    private final int amount;

    public ProductAmount(int amount) {
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

package vendingmachine.domain.product;

import static vendingmachine.utils.ErrorMessages.OUT_OF_RANGE_PRODUCT_QUANTITY;

public class ProductQuantity {
    private final int quantity;

    public ProductQuantity(int quantity) {
        validate(quantity);
        this.quantity = quantity;
    }

    private void validate(int quantity) {
        validateRange(quantity);
    }

    private void validateRange(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException(OUT_OF_RANGE_PRODUCT_QUANTITY);
        }
    }
}

package vendingmachine.domain.product;

import vendingmachine.utils.IntegerConvertor;

import static vendingmachine.utils.ErrorMessages.*;

public class ProductQuantity {
    private int quantity;

    public ProductQuantity(String input) {
        int quantity = IntegerConvertor.parseInt(input, NOT_INTEGER_PRODUCT_QUANTITY);
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

    public boolean isOutOfStock() {
        return quantity == 0;
    }

    public void decrease() {
        quantity--;
    }
}

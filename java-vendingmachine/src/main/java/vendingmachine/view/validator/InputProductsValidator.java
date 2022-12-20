package vendingmachine.view.validator;

import java.util.Arrays;

import static vendingmachine.utils.ErrorMessages.*;

public class InputProductsValidator {
    private static final String PRODUCT_INFO_END_FORMAT = "]";
    private static final String PRODUCT_SEPARATOR = ";";
    private static final String PRODUCT_INFO_SEPARATOR = ",";

    public static void validate(String products) {
        validateProductSeparator(products);
        validateProductInfoSeparator(products);
        validateProductInfo(products);
    }

    private static void validateProductSeparator(String products) {
        if (!isSeparateProduct(products)) {
            throw new IllegalArgumentException(INVALID_PRODUCT_SEPARATOR);
        }
    }

    private static boolean isSeparateProduct(String products) {
        int productCount = countBySeparator(products, PRODUCT_INFO_END_FORMAT);
        int productSeparatorCount = countBySeparator(products, PRODUCT_SEPARATOR);
        return (productCount - 1) == productSeparatorCount;
    }

    private static int countBySeparator(String products, String separator) {
        return (int) products.chars()
                .filter(ch -> ch == separator.charAt(0))
                .count();
    }

    private static void validateProductInfoSeparator(String products) {
        if (!isSeparateProductInfo(products)) {
            throw new IllegalArgumentException(INVALID_PRODUCT_INFO_SEPARATOR);
        }
    }

    private static boolean isSeparateProductInfo(String products) {
        return Arrays.stream(products.split(PRODUCT_SEPARATOR))
                .allMatch(product -> product.contains(PRODUCT_INFO_SEPARATOR));
    }

    private static void validateProductInfo(String products) {
        if (!isValidProductInfo(products)) {
            throw new IllegalArgumentException(INVALID_PRODUCT_INFO);
        }
    }

    private static boolean isValidProductInfo(String products) {
        return Arrays.stream(products.split(PRODUCT_SEPARATOR))
                .allMatch(product -> countBySeparator(product, PRODUCT_INFO_SEPARATOR) == 2);
    }
}

package vendingmachine.domain.product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.utils.ErrorMessages.*;

public class Products {
    private static final String PRODUCT_INFO_END_FORMAT = "]";
    private static final String PRODUCT_SEPARATOR = ";";
    private static final String PRODUCT_INFO_SEPARATOR = ",";

    private final List<Product> products;

    public Products(String products) {
        validate(products);
        this.products = initProducts(products);
    }

    private List<Product> initProducts(String products) {
        return Arrays.stream(products.split(PRODUCT_SEPARATOR))
                .map(this::toProduct)
                .collect(Collectors.toList());
    }

    private Product toProduct(String product) {
        String[] productInfo = product.replaceAll("[\\[\\]]", "")
                .split(PRODUCT_INFO_SEPARATOR);
        return new Product(Arrays.asList(productInfo));
    }

    private void validate(String products) {
        validateProductSeparator(products);
        validateProductInfoSeparator(products);
        validateProductInfo(products);
    }

    private void validateProductSeparator(String products) {
        if (!isSeparateProduct(products)) {
            throw new IllegalArgumentException(INVALID_PRODUCT_SEPARATOR);
        }
    }

    private boolean isSeparateProduct(String products) {
        int productCount = countBySeparator(products, PRODUCT_INFO_END_FORMAT);
        int productSeparatorCount = countBySeparator(products, PRODUCT_SEPARATOR);
        return (productCount - 1) == productSeparatorCount;
    }

    private int countBySeparator(String products, String separator) {
        return (int) products.chars()
                .filter(ch -> ch == separator.charAt(0))
                .count();
    }

    private void validateProductInfoSeparator(String products) {
        if (!isSeparateProductInfo(products)) {
            throw new IllegalArgumentException(INVALID_PRODUCT_INFO_SEPARATOR);
        }
    }

    private boolean isSeparateProductInfo(String products) {
        return Arrays.stream(products.split(PRODUCT_SEPARATOR))
                .allMatch(product -> product.contains(PRODUCT_INFO_SEPARATOR));
    }

    private void validateProductInfo(String products) {
        if (!isValidProductInfo(products)) {
            throw new IllegalArgumentException(INVALID_PRODUCT_INFO);
        }
    }

    private boolean isValidProductInfo(String products) {
        return Arrays.stream(products.split(PRODUCT_SEPARATOR))
                .allMatch(product -> countBySeparator(product, PRODUCT_INFO_SEPARATOR) == 2);
    }

    public Product getProductByName(String productName) {
        return products.stream()
                .filter(product -> product.isEqualName(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_PRODUCT));
    }

    public boolean isOutOfStock() {
        return products.stream()
                .allMatch(Product::isOutOfStock);
    }

    public boolean isMoneyLessThanPrice(int money) {
        return products.stream()
                .allMatch(product -> product.isMoneyLessThanPrice(money));
    }
}

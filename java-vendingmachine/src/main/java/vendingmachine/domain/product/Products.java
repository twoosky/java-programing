package vendingmachine.domain.product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.utils.ErrorMessages.*;

public class Products {
    private static final String PRODUCT_SEPARATOR = ";";
    private static final String PRODUCT_INFO_SEPARATOR = ",";
    private static final String PRODUCT_INFO_REGEX = "[\\[\\]]";
    private static final int PRODUCT_NAME_INDEX = 0;
    private static final int PRODUCT_PRICE_INDEX = 1;
    private static final int PRODUCT_QUANTITY_INDEX = 2;

    private final List<Product> products;

    public Products(String products) {
        this.products = initProducts(products);
    }

    private List<Product> initProducts(String products) {
        return Arrays.stream(products.split(PRODUCT_SEPARATOR))
                .map(this::getProduct)
                .collect(Collectors.toList());
    }

    private Product getProduct(String product) {
        String[] productInfo = product.replaceAll(PRODUCT_INFO_REGEX, "")
                .split(PRODUCT_INFO_SEPARATOR);
        return toProduct(Arrays.asList(productInfo));
    }

    private Product toProduct(List<String> productInfo) {
        return new Product(
                productInfo.get(PRODUCT_NAME_INDEX),
                productInfo.get(PRODUCT_PRICE_INDEX),
                productInfo.get(PRODUCT_QUANTITY_INDEX)
        );
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

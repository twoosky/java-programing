package vendingmachine.utils;

public class ErrorMessages {
    public static final String NOT_INTEGER_MACHINE_MONEY = "[ERROR] 자판기 보유 금액은 숫자만 입력 가능합니다.";
    public static final String OUT_OF_RANGE_MACHINE_MONEY = "[ERROR] 자판기 보유 금액은 10 이상이어야 합니다.";
    public static final String INVALID_UNIT_MACHINE_MONEY = "[ERROR] 자판기 보유 금액은 10으로 나누어 떨어져야 합니다.";

    public static final String INVALID_PRODUCT_SEPARATOR = "[ERROR] 상품은 세미콜론(;)으로 구분되어야 합니다.";
    public static final String INVALID_PRODUCT_INFO_SEPARATOR = "[ERROR] 상품 정보는 쉼표(,)로 구분되어야 합니다.";
    public static final String NOT_INTEGER_PRODUCT_AMOUNT = "[ERROR] 상품 가격은 숫자만 입력 가능합니다.";
    public static final String OUT_OF_RANGE_PRODUCT_AMOUNT = "[ERROR] 상품 가격은 100 이상이어야 합니다.";
    public static final String INVALID_UNIT_PRODUCT_AMOUNT = "[ERROR] 상품 가격은 10으로 나누어 떨어져야 합니다.";
    public static final String NOT_INTEGER_PRODUCT_COUNT = "[ERROR] 상품 수량은 숫자만 입력 가능합니다.";
    public static final String OUT_OF_RANGE_PRODUCT_COUNT = "[ERROR] 상품 수량은 1개 이상이어야 합니다.";
    public static final String NOT_INTEGER_CONSUMER_MONEY = "[ERROR] 투입 금액은 숫자만 입력 가능합니다.";
    public static final String INVALID_UNIT_CONSUMER_MONEY = "[ERROR] 투입 금액은 10으로 나누어 떨어져야 합니다.";

    public static final String NOT_EXIST_PRODUCT = "[ERROR] 존재하지 않는 상품입니다.";
}

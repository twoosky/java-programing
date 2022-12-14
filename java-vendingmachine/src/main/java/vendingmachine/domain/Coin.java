package vendingmachine.domain;

import java.util.Arrays;

import static vendingmachine.utils.ErrorMessages.NOT_EXIST_COIN_AMOUNT;

public enum Coin {
    COIN_500(500, 0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private final int amount;
    private int count;

    Coin(final int amount, final int count) {
        this.amount = amount;
        this.count = count;
    }

    public static Coin of(int amount) {
        return Arrays.stream(Coin.values())
                .filter(value -> value.amount == amount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_COIN_AMOUNT));
    }

    public void increaseCoinCount() {
        this.count++;
    }

    public void decreaseCount(int count) {
        this.count -= count;
    }

    public boolean hasCoin() {
        return count != 0;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }
}

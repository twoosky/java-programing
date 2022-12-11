package vendingmachine.domain;

import static vendingmachine.utils.ErrorMessages.INVALID_UNIT_MACHINE_MONEY;
import static vendingmachine.utils.ErrorMessages.OUT_OF_RANGE_MACHINE_MONEY;

public class VendingMachineMoney {
    private int money;

    public VendingMachineMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateRange(money);
        validateUnit(money);
    }

    private void validateRange(int money) {
        if (money < 10) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MACHINE_MONEY);
        }
    }

    private void validateUnit(int money) {
        if ((money % 10) != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_MACHINE_MONEY);
        }
    }

    public void exchangeCoin(int amount) {
        money -= amount;
    }

    public boolean hasAmount() {
        return money > 0;
    }

    public int get() {
        return money;
    }
}

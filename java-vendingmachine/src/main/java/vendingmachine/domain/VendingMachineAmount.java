package vendingmachine.domain;

import static vendingmachine.utils.ErrorMessages.INVALID_UNIT_MACHINE_MONEY;
import static vendingmachine.utils.ErrorMessages.OUT_OF_RANGE_MACHINE_MONEY;

public class VendingMachineAmount {
    private int amount;

    public VendingMachineAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateRange(amount);
        validateUnit(amount);
    }

    private void validateRange(int amount) {
        if (amount < 10) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MACHINE_MONEY);
        }
    }

    private void validateUnit(int amount) {
        if ((amount % 10) != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_MACHINE_MONEY);
        }
    }

    public void exchangeCoin(int amount) {
        this.amount -= amount;
    }

    public boolean hasAmount() {
        return amount > 0;
    }

    public boolean isGreaterThanCoinAmount(int coinAmount) {
        return coinAmount <= amount;
    }
}

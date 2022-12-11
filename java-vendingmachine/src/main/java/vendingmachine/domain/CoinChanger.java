package vendingmachine.domain;

import vendingmachine.utils.CoinGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoinChanger {
    private final CoinGenerator coinGenerator;

    public CoinChanger(CoinGenerator coinGenerator) {
        this.coinGenerator = coinGenerator;
    }

    public void generateCoin(VendingMachineAmount amount) {
        while (amount.hasAmount()) {
            generateRandomCoin(amount);
        }
    }

    private void generateRandomCoin(VendingMachineAmount amount) {
        int money = coinGenerator.generate(getAmounts(amount));
        amount.exchangeCoin(money);
        updateCoinCount(money);
    }

    private void updateCoinCount(int amount) {
        Coin coin = Coin.of(amount);
        coin.increaseCoinCount();
    }

    private List<Integer> getAmounts(VendingMachineAmount amount) {
        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .filter(amount::isGreaterThanCoinAmount)
                .collect(Collectors.toList());
    }
}

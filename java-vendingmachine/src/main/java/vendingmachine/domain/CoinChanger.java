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

    public void generateCoin(Money money) {
        while (money.hasAmount()) {
            generateRandomCoin(money);
        }
    }

    private void generateRandomCoin(Money money) {
        int amount = coinGenerator.generate(getAmounts(money.get()));
        money.exchangeCoin(amount);
        updateCoinCount(amount);
    }

    private void updateCoinCount(int amount) {
        Coin coin = Coin.of(amount);
        coin.updateCoinCount();
    }

    private List<Integer> getAmounts(int money) {
        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .filter(amount -> amount <= money)
                .collect(Collectors.toList());
    }
}

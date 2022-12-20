package vendingmachine.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Change {
    private final Map<Coin, Integer> change;

    public Change(Money money) {
        this.change = new EnumMap<>(Coin.class);
        putChange(money);
    }

    public void putChange(Money money) {
        Arrays.stream(Coin.values())
             .filter(Coin::hasCoin)
             .filter(money::isMoneyGreaterThenAmount)
             .forEach(coin -> change.put(coin, calculateChange(coin, money)));
    }

    private Integer calculateChange(Coin coin, Money money) {
        int coinCountByMoney = getCoinCountByMoney(coin, money);
        if (coinCountByMoney < coin.getCount()) {
            return updateCoinCount(coin, coinCountByMoney);
        }
        return updateCoinCount(coin, coin.getCount());
    }

    private int getCoinCountByMoney(Coin coin, Money consumerMoney) {
        return consumerMoney.getMoney() / coin.getAmount();
    }

    private Integer updateCoinCount(Coin coin, int count) {
        coin.decreaseCount(count);
        return count;
    }

    public Map<Coin, Integer> getChange() {
        return change;
    }
}

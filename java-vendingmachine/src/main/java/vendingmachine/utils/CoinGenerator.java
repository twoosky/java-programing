package vendingmachine.utils;

import java.util.List;

public interface CoinGenerator {
    int generate(List<Integer> amounts);
}

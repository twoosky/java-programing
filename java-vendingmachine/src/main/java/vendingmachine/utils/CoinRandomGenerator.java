package vendingmachine.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CoinRandomGenerator implements CoinGenerator{

    @Override
    public int generate(List<Integer> amounts) {
        return Randoms.pickNumberInList(amounts);
    }
}

package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class MovingRandomNumberGenerator implements MovingRuleGenerator<Integer> {
    @Override
    public Integer generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}

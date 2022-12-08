package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class ProgressRandomNumberGenerator implements ProgressRuleGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}

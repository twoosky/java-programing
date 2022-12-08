package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class AdvanceRandomNumberGenerator implements AdvanceRuleGenerator{
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}

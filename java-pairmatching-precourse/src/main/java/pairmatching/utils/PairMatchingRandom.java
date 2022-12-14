package pairmatching.utils;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;

import java.util.List;

public class PairMatchingRandom implements PairMatchingRule<String> {

    @Override
    public List<String> match(List<String> crews) {
        return Randoms.shuffle(crews);
    }
}

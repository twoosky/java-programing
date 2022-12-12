package pairmatching.utils;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;

import java.util.List;

public class PairMatchingRandom implements PairMatchingRule<Crew> {

    @Override
    public List<Crew> match(List<Crew> crews) {
        return Randoms.shuffle(crews);
    }
}

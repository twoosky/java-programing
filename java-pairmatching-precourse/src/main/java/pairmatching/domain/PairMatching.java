package pairmatching.domain;

import pairmatching.utils.PairMatchingRule;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PairMatching {
    private final PairMatchingRule<Crew> pairMatchingRule;

    public PairMatching(PairMatchingRule<Crew> pairMatchingRule) {
        this.pairMatchingRule = pairMatchingRule;
    }

    public List<List<Crew>> match(Crews crews) {
        return IntStream.range(0, crews.getCrews().size())
                .filter(i -> i % 2 == 0)
                .mapToObj(crews::matchPair)
                .collect(Collectors.toList());
    }

    private List<Crew> shufflesCrews(Crews crews) {
        return pairMatchingRule.match(crews.getCrews());
    }
}

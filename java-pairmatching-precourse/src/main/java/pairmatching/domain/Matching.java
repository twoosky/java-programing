package pairmatching.domain;

import pairmatching.utils.PairMatchingRule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Matching {
    private final PairMatchingRule<Crew> pairMatchingRule;

    public Matching(PairMatchingRule<Crew> pairMatchingRule) {
        this.pairMatchingRule = pairMatchingRule;
    }

    public Pair match(Crews crews) {
        List<Crew> randomCrews = shufflesCrews(crews);
        return new Pair(matchPair(randomCrews));
    }

    private List<Crew> shufflesCrews(Crews crews) {
        return pairMatchingRule.match(crews.getCrews());
    }

    private List<List<Crew>> matchPair(List<Crew> crews) {
        return IntStream.range(0, crews.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(index -> generatePair(index, crews))
                .collect(Collectors.toList());
    }

    private List<Crew> generatePair(int index, List<Crew> crews) {
        System.out.println("index = " + index);
        if (isLastPair(index, crews)) {
            return Arrays.asList(crews.get(index), crews.get(index + 1), crews.get(index + 2));
        }
        return Arrays.asList(crews.get(index), crews.get(index + 1));
    }

    private boolean isLastPair(int index, List<Crew> crews) {
        return (crews.size() - index) == 3;
    }
}

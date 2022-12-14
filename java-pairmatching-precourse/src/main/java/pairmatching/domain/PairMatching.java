package pairmatching.domain;

import pairmatching.utils.PairMatchingRule;

import java.util.stream.IntStream;

import static pairmatching.utils.ErrorMessages.IMPOSSIBLE_PAIR_MATCHING;

public class PairMatching {
    private final Crews crews;
    private final CrewPairHistories crewPairHistories;
    private final Matching matching;

    public PairMatching(PairMatchingRule<String> pairMatchingRule) {
        this.crews = new Crews();
        this.crewPairHistories = new CrewPairHistories(crews);
        this.matching = new Matching(pairMatchingRule);
    }

    public Pair match(Course course) {
        Pair pair = matchByPair(course);
        putCrewPairHistory(pair);
        return pair;
    }

    private Pair matchByPair(Course course) {
        return IntStream.range(0, 3)
                .mapToObj(i -> matching.match(course, crews))
                .filter(this::isNotMatched)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(IMPOSSIBLE_PAIR_MATCHING));
    }

    private boolean isNotMatched(Pair pair) {
        return !pair.getPair().stream()
                .allMatch(crewPairHistories::isMatchedPair);
    }

    private void putCrewPairHistory(Pair pair) {
        pair.getPair().forEach(crewPairHistories::putCrewPairHistory);
    }

    public void reset() {
        crewPairHistories.resetCrewPairHistory();
    }
}

package pairmatching.domain;

import java.util.List;
import java.util.stream.IntStream;

import static pairmatching.utils.ErrorMessages.IMPOSSIBLE_PAIR_MATCHING;

public class PairMatching {
    private final Crews crews;
    private final Matching matching;

    public PairMatching(Crews crews, Matching matching) {
        this.crews = crews;
        this.matching = matching;
    }

    public Pair match() {
        Pair pair = matchByPair();
        putCrewPairHistory(pair);
        return pair;
    }

    private Pair matchByPair() {
        return IntStream.range(0, 3)
                .mapToObj(i -> matching.match(crews))
                .filter(this::isMatched)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(IMPOSSIBLE_PAIR_MATCHING));
    }

    private boolean isMatched(Pair pair) {
        return pair.getPair().stream()
                .anyMatch(this::isMatchedByPair);
    }

    private boolean isMatchedByPair(List<Crew> pair) {
        return pair.stream()
                .allMatch(crews::isMatchedPair);
    }

    private void putCrewPairHistory(Pair pair) {
        pair.getPair().forEach(crews::putCrewPairHistory);
    }

    public void reset() {
        crews.resetCrewPairHistory();
    }
}

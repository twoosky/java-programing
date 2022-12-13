package pairmatching.dto;

import pairmatching.domain.Crew;
import pairmatching.domain.Pair;

import java.util.List;

public class PairMatchingDto {
    private final List<List<Crew>> pair;

    public PairMatchingDto(Pair pair) {
        this.pair = pair.getPair();
    }

    public List<List<Crew>> getPairs() {
        return pair;
    }
}

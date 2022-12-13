package pairmatching.domain;

import java.util.List;

public class Pair {
    private final List<List<Crew>> pairs;

    public Pair(List<List<Crew>> pairs) {
        this.pairs = pairs;
    }

    public List<List<Crew>> getPair() {
        return pairs;
    }
}

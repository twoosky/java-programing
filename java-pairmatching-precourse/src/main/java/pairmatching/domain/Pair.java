package pairmatching.domain;

import java.util.List;

public class Pair {
    private final List<List<Crew>> pair;

    public Pair(List<List<Crew>> pair) {
        this.pair = pair;
    }

    public List<List<Crew>> getPair() {
        return pair;
    }
}

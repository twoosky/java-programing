package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class CrewPairHistory {
    private final Crew crew;
    private final List<Crew> history;

    public CrewPairHistory(Crew crew) {
        this.crew = crew;
        this.history = new ArrayList<>();
    }

    public void putMatchedPair(Crew crew) {
        history.add(crew);
    }

    public boolean isMatchedPair(Crew pair) {
        return (crew.getCourse() == pair.getCourse()) && history.contains(pair);
    }

    public Crew getCrew() {
        return crew;
    }
}
